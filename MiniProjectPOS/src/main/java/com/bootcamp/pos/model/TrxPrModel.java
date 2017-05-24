package com.bootcamp.pos.model;

import java.util.Date;
import java.util.HashSet;
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
@Table(name="POS_TRX_PR")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="prId")
public class TrxPrModel {
	private Integer id;
	private Integer outletId;
	private Date readyTime;
	private String prNo;
	private String notes;
	private Integer statusId;
	private Date createdOn;
	private Integer createdBy;
	private Date modifiedOn;
	private Integer modifiedBy;
	private Set<TrxPrDetailModel> details = new HashSet<TrxPrDetailModel>(0);
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="TRX_PR")
	@TableGenerator(name="TRX_PR",table="POS_MST_SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="TRX_PR", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="OUTLET_ID")
	public Integer getOutletId() {
		return outletId;
	}
	public void setOutletId(Integer outletId) {
		this.outletId = outletId;
	}
	
	@Column(name="READY_TIME")
	public Date getReadyTime() {
		return readyTime;
	}
	public void setReadyTime(Date readyTime) {
		this.readyTime = readyTime;
	}
	
	@Column(name="PR_NO")
	public String getPrNo() {
		return prNo;
	}
	public void setPrNo(String prNo) {
		this.prNo = prNo;
	}
	
	@Column(name="NOTES")
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	@Column(name="STATUS_ID")
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
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
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="pr")
	@JsonManagedReference
	public Set<TrxPrDetailModel> getDetails() {
		return details;
	}
	public void setDetails(Set<TrxPrDetailModel> details) {
		this.details = details;
	}
}
