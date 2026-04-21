package repositories;

import java.util.List;

import entities.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TaskRepository {
	private static final EntityManagerFactory entitityManagerFactory = Persistence
			.createEntityManagerFactory("desafioEsigPU");

	public EntityManager getEntityManager() {

		return entitityManagerFactory.createEntityManager();

	}

	public void createTask(Task task) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();

			if (task.getId() == null) {
				entityManager.persist(task);
			}

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			throw e;
		} finally {
			entityManager.close();
		}
	}

	public void UpdateTask(Task task) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();

			if (task.getId() != null) {
				entityManager.merge(task);
			}

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			throw e;
		} finally {
			entityManager.close();
		}
	}

	public void deleteTask(Long id) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			Task taskResult = entityManager.find(Task.class, id);

			if (taskResult != null) {
				entityManager.remove(taskResult);
			}

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			throw e;
		} finally {
			entityManager.close();
		}
	}
	
	public List<Task> listarPendentes() {
		
        EntityManager entityManager = getEntityManager();
        try {
            String jpql = "SELECT t FROM Task t WHERE t.status_task = enums.Status.EM_ANDAMENTO ORDER BY t.deadline ASC";
            return entityManager.createQuery(jpql, Task.class)
                     .getResultList();
        } finally {
            entityManager.close();
        }
    }
}


