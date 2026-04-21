package entities;

import java.io.Serializable;

import java.util.Date;

import enums.Priority;
import enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_taks")
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String title;
	
	@Column(nullable = false, unique = true)
	private String description;
	
	@Column(nullable = false)
	private Date deadline;
	
	@Column(nullable = false, name = "status_task")
	@Enumerated(EnumType.STRING)
	private Status statusTask = Status.EM_ANDAMENTO;

	@Column(nullable = false, name = "priority_level")
	@Enumerated(EnumType.STRING)
	private Priority priorityLevel;


	public Task(Long id, String title, String description, Date deadline, Status statusTask, Priority priorityLevel) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.deadline = deadline;
		this.statusTask = statusTask;
		this.priorityLevel = priorityLevel;
	}

	public Status getStatusTask() {
		return statusTask;
	}

	public void setStatusTask(Status statusTask) {
		this.statusTask = statusTask;
	}

	public Priority getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(Priority priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
