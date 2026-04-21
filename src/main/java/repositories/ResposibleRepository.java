package repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

import entities.Responsible;

public class ResposibleRepository {

	private static final EntityManagerFactory entitityManagerFactory = Persistence
			.createEntityManagerFactory("desafioEsigPU");

	public EntityManager getEntityManager() {
		
		return entitityManagerFactory.createEntityManager();
		
	}

	public void createResponsible(Responsible responsible) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();

			if (responsible.getId() == null) {
				entityManager.persist(responsible);
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

	public List<Responsible> getAllResponsibles() {
		EntityManager entityManager = getEntityManager();
		try {
			return entityManager.createQuery("SELECT r FROM Responsible r", Responsible.class).getResultList();
		} finally {
			entityManager.close();
		}
	}

	public Responsible findById(Long id) {
		EntityManager entityManager = getEntityManager();
		try {
			return entityManager.find(Responsible.class, id);
		} finally {
			entityManager.close();
		}

	}

	public void deleteResponsible(Long id) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			Responsible responsibleResult = entityManager.find(Responsible.class, id);

			if (responsibleResult != null) {
				entityManager.remove(responsibleResult);
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

	public void upadateNameResponsible(Responsible responsible) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();

			if (responsible.getId() != null) {
				entityManager.merge(responsible);
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
}
