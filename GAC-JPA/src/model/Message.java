package model;

// Generated 14 janv. 2013 16:54:08 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Message generated by hbm2java
 */
@Entity
@Table(name = "message")
public class Message implements java.io.Serializable {

	private Integer idmessage;
	private Conversation conversation;
	private Employee employee;
	private String content;
	private Date sendTime;

	public Message() {
	}

	public Message(Conversation conversation) {
		this.conversation = conversation;
	}

	public Message(Conversation conversation, Employee employee,
			String content, Date sendTime) {
		this.conversation = conversation;
		this.employee = employee;
		this.content = content;
		this.sendTime = sendTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idmessage", unique = true, nullable = false)
	public Integer getIdmessage() {
		return this.idmessage;
	}

	public void setIdmessage(Integer idmessage) {
		this.idmessage = idmessage;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conversation_idconversation", nullable = false)
	public Conversation getConversation() {
		return this.conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsender")
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Column(name = "content", length = 128)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "send_time", length = 19)
	public Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

}
