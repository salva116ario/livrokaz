package co.simplon.livrokaz.model;
// Generated 14 janv. 2019 à 21:06:11 by Hibernate Tools 5.2.11.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Employees generated by hbm2java
 */
@Entity
@Table(name = "employees", catalog = "livrokaz")
public class Employees implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer emId;
	private Role role;
	private String emMail;
	private String emPassword;

	public Employees() {
	}

	public Employees(Role role, String emMail, String emPassword) {
		this.role = role;
		this.emMail = emMail;
		this.emPassword = emPassword;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "em_id", unique = true, nullable = false)
	public Integer getEmId() {
		return this.emId;
	}

	public void setEmId(Integer emId) {
		this.emId = emId;
	}
	//@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ro_id", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "em_mail", nullable = false, length = 50)
	public String getEmMail() {
		return this.emMail;
	}

	public void setEmMail(String emMail) {
		this.emMail = emMail;
	}

	@Column(name = "em_password", nullable = false, length = 50)
	public String getEmPassword() {
		return this.emPassword;
	}

	public void setEmPassword(String emPassword) {
		this.emPassword = emPassword;
	}

}
