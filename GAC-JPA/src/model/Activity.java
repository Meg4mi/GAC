package model;

// Generated 14 janv. 2013 16:54:08 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Activity generated by hbm2java
 */
@Entity
@Table(name = "activity")
public class Activity implements java.io.Serializable {

	private int idactivity;
	private Employee employee;
	private Project project;
	private Integer charge;
	private Date day;
	private String description;
	private int estTermine;

	public Activity() {
	}

	public Activity(int idactivity, Employee employee, Project project,
			int estTermine) {
		this.idactivity = idactivity;
		this.employee = employee;
		this.project = project;
		this.estTermine = estTermine;
	}

	public Activity(int idactivity, Employee employee, Project project,
			Integer charge, Date day, String description, int estTermine) {
		this.idactivity = idactivity;
		this.employee = employee;
		this.project = project;
		this.charge = charge;
		this.day = day;
		this.description = description;
		this.estTermine = estTermine;
	}

	@Id
	@Column(name = "idactivity", unique = true, nullable = false)
	public int getIdactivity() {
		return this.idactivity;
	}

	public void setIdactivity(int idactivity) {
		this.idactivity = idactivity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_idemployee", nullable = false)
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_idproject", nullable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Column(name = "charge")
	public Integer getCharge() {
		return this.charge;
	}

	public void setCharge(Integer charge) {
		this.charge = charge;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "day", length = 10)
	public Date getDay() {
		return this.day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	@Column(name = "description", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "estTermine", nullable = false)
	public int getEstTermine() {
		return this.estTermine;
	}

	public void setEstTermine(int estTermine) {
		this.estTermine = estTermine;
	}

}
