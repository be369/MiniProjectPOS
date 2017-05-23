package com.bootcamp.pos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="POS_MST_EMPLOYEE")
public class MstEmployeeModel {
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String title;
	private Integer haveAccount;
	private Integer createBy;
	private Date createOn;
	private Integer modifiedBy;
	private Date modifiedOn;
	private Integer active;
	private MstUserModel user;
	
	@Id
	@Column(name="ID", columnDefinition="long")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MST_EMPLOYEE")
	@TableGenerator(name="MST_EMPLOYEE", table="POS_MST_SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="MST_EMPLOYEE", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getHaveAccount() {
		return haveAccount;
	}
	public void setHaveAccount(Integer haveAccount) {
		this.haveAccount = haveAccount;
	}
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public Date getCreateOn() {
		return createOn;
	}
	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}
	public Integer getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public MstUserModel getUser() {
		return user;
	}
	public void setUser(MstUserModel user) {
		this.user = user;
	}	
}
