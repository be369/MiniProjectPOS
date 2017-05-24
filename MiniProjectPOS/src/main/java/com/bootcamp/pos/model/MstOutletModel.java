package com.bootcamp.pos.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="POS_MST_OUTLET")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="outletId")
public class MstOutletModel {
	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private Integer provinceId;
	private Integer regionId;
	private Integer districtId;
	private Integer villageId;
	private Integer postalCode;
	private Date createdOn;
	private Integer createdBy;
	private Date modifiedOn;
	private Integer modifiedBy;
	private Integer active;
	private Set<MstInventoryModel> inventory = new HashSet<MstInventoryModel>(0);
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="MST_OUTLET")
	@TableGenerator(name="MST_OUTLET",table="POS_MST_SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="MST_OUTLET", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="NAME", columnDefinition="varchar(50)")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="EMAIL", columnDefinition="varchar(50)")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="PHONE", columnDefinition="varchar(16)")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name="ADDRESS", columnDefinition="varchar(255)")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="PROVINCE_ID")
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	
	@Column(name="REGION_ID")
	public Integer getRegionId() {
		return regionId;
	}
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}
	
	@Column(name="DISTRICT_ID")
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	
	@Column(name="VILLAGE_ID")
	public Integer getVillageId() {
		return villageId;
	}
	public void setVillageId(Integer villageId) {
		this.villageId = villageId;
	}
	
	@Column(name="POSTAL_CODE", columnDefinition="varchar(6)")
	public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	
	@Column(name="CREATED_ON")
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@Column(name="CREATED_BY")
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="MODIFIED_ON")
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	@Column(name="MODIFIED_BY")
	public Integer getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	@Column(name="ACTIVE")
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="outlet")
	@JsonManagedReference
	public Set<MstInventoryModel> getInventory() {
		return inventory;
	}
	public void setInventory(Set<MstInventoryModel> inventory) {
		this.inventory = inventory;
	}
}
