package model;

<<<<<<< HEAD
// Generated 14 janv. 2013 16:54:08 by Hibernate Tools 3.4.0.CR1
=======
// Generated 14 janv. 2013 14:20:50 by Hibernate Tools 3.4.0.CR1
>>>>>>> branch 'master' of https://github.com/Meg4mi/GAC.git

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Conversation generated by hbm2java
 */
@Entity
@Table(name = "conversation")
public class Conversation implements java.io.Serializable {

	private Integer idconversation;
	private Employee employeeByCallerIdemployee;
	private Employee employeeByCalledIdemployee;
	private Date dayTimeBegin;
	private Date dayTimeEnd;
	private Set<Message> messages = new HashSet<Message>(0);

	public Conversation() {
	}

	public Conversation(Employee employeeByCallerIdemployee,
			Employee employeeByCalledIdemployee) {
		this.employeeByCallerIdemployee = employeeByCallerIdemployee;
		this.employeeByCalledIdemployee = employeeByCalledIdemployee;
	}

	public Conversation(Employee employeeByCallerIdemployee,
			Employee employeeByCalledIdemployee, Date dayTimeBegin,
			Date dayTimeEnd, Set<Message> messages) {
		this.employeeByCallerIdemployee = employeeByCallerIdemployee;
		this.employeeByCalledIdemployee = employeeByCalledIdemployee;
		this.dayTimeBegin = dayTimeBegin;
		this.dayTimeEnd = dayTimeEnd;
		this.messages = messages;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idconversation", unique = true, nullable = false)
	public Integer getIdconversation() {
		return this.idconversation;
	}

	public void setIdconversation(Integer idconversation) {
		this.idconversation = idconversation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "caller_idemployee", nullable = false)
	public Employee getEmployeeByCallerIdemployee() {
		return this.employeeByCallerIdemployee;
	}

	public void setEmployeeByCallerIdemployee(
			Employee employeeByCallerIdemployee) {
		this.employeeByCallerIdemployee = employeeByCallerIdemployee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "called_idemployee", nullable = false)
	public Employee getEmployeeByCalledIdemployee() {
		return this.employeeByCalledIdemployee;
	}

	public void setEmployeeByCalledIdemployee(
			Employee employeeByCalledIdemployee) {
		this.employeeByCalledIdemployee = employeeByCalledIdemployee;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "day_time_begin", length = 19)
	public Date getDayTimeBegin() {
		return this.dayTimeBegin;
	}

	public void setDayTimeBegin(Date dayTimeBegin) {
		this.dayTimeBegin = dayTimeBegin;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "day_time_end", length = 19)
	public Date getDayTimeEnd() {
		return this.dayTimeEnd;
	}

	public void setDayTimeEnd(Date dayTimeEnd) {
		this.dayTimeEnd = dayTimeEnd;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conversation")
	public Set<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

}
