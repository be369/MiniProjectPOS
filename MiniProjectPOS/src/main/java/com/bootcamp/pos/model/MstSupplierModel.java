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
@Table(name="POS_MST_SUPPLIER")
public class MstSupplierModel {

	private Long id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private Long provinceId;
	private Long regionId;
	private Long districtId;
	private String postalCode;
	private Long createdBy;
	private Date createdOn;
	private Long modifiedBy;
	private Date modifiedOn;
	private Boolean active;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="MST_SUPPLIER")
	@TableGenerator(name="MST_SUPPLIER",table="POS_MST_SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="MST_SUPPLIER", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="NAME", columnDefinition="varchar(50)", nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="ADDRESS", columnDefinition="varchar(255)")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="PHONE", columnDefinition="varchar(16)")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name="EMAIL", columnDefinition="varchar(255)")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="PROVINCE_ID", nullable=false)
	public Long getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}
	
	@Column(name="REGION_ID", columnDefinition="long(6)", nullable=false)
	public Long getRegionId() {
		return regionId;
	}
	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}
	
	@Column(name="DISTRICT_ID", columnDefinition="long(16)", nullable=false)
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	
	@Column(name="POSTAL_CODE", columnDefinition="varchar(50)")
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	@Column(name="CREATED_BY")
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	
	@Column(name="CREATED_ON")
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
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
	
	@Column(name="ACTIVE", nullable=false)
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
}
