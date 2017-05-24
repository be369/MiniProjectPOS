package com.bootcamp.pos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="POS_MST_EMPLOYEE")
public class MstEmployeeModel {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String title;
	private Boolean haveAccount;
	private Long createdBy;
	private Date createdOn;
	private Long modifiedBy;
	private Date modifiedOn;
	private Boolean active;
	private MstUserModel user;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MST_EMPLOYEE")
	@TableGenerator(name="MST_EMPLOYEE", table="POS_MST_SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="MST_EMPLOYEE", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="FIRST_NAME", columnDefinition="varchar(50)", nullable=false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="LAST_NAME", columnDefinition="varchar(50)", nullable=false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="EMAIL", columnDefinition="varchar(50)", nullable=false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="TITLE", columnDefinition="varchar(50)")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="HAVE_ACCOUNT", nullable=false)
	public Boolean getHaveAccount() {
		return haveAccount;
	}
	public void setHaveAccount(Boolean haveAccount) {
		this.haveAccount = haveAccount;
	}
	
	@Column(name="CREATED_BY")
	public Long getCreateBy() {
		return createdBy;
	}
	public void setCreateBy(Long createBy) {
		this.createdBy = createBy;
	}
	
	@Column(name="CREATED_ON")
	public Date getCreateOn() {
		return createdOn;
	}
	public void setCreateOn(Date createOn) {
		this.createdOn = createOn;
	}
	
	@Column(name="MODIFIED_BY")
	public Long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	@Column(name="MODIFIED_ON")
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	@Column(name="active", nullable=false)
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn
	public MstUserModel getUser() {
		return user;
	}
	public void setUser(MstUserModel user) {
		this.user = user;
	}	
}
