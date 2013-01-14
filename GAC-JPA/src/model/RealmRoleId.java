package model;

// Generated 14 janv. 2013 16:54:08 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RealmRoleId generated by hbm2java
 */
@Embeddable
public class RealmRoleId implements java.io.Serializable {

	private String username;
	private String roleName;

	public RealmRoleId() {
	}

	public RealmRoleId(String username, String roleName) {
		this.username = username;
		this.roleName = roleName;
	}

	@Column(name = "username", nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "role_name", nullable = false, length = 45)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RealmRoleId))
			return false;
		RealmRoleId castOther = (RealmRoleId) other;

		return ((this.getUsername() == castOther.getUsername()) || (this
				.getUsername() != null && castOther.getUsername() != null && this
				.getUsername().equals(castOther.getUsername())))
				&& ((this.getRoleName() == castOther.getRoleName()) || (this
						.getRoleName() != null
						&& castOther.getRoleName() != null && this
						.getRoleName().equals(castOther.getRoleName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result
				+ (getRoleName() == null ? 0 : this.getRoleName().hashCode());
		return result;
	}

}
