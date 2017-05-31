package com.bootcamp.pos.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="POS_TRX_PR_DETAIL")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property = "prDetailId")
public class TrxPrDetailModel {
	private int id;
	private int prId;
	private int variantId;
	private int requestQty;
	private int createdBy;
	private Date createdOn;
	private int modifiedBy;
	private Date modifiedOn;
	private TrxPrModel pr;
	private MstItemVariantModel variant;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.TABLE,generator="TRX_PR_DETAIL")
	@TableGenerator(name="TRX_PR_DETAIL",table="POST_MST_SEQUENCE", pkColumnName="SEQUENCE_ID",pkColumnValue="TRX_PR_DETAIL",valueColumnName="SEQUENCE_VALUE",allocationSize=1,initialValue=1)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="PR_ID")
	public int getPrId() {
		return prId;
	}
	public void setPrId(int prId) {
		this.prId = prId;
	}
	
	@Column(name="VARIANT_ID")
	public int getVariantId() {
		return variantId;
	}
	public void setVariantId(int variantId) {
		this.variantId = variantId;
	}
	
	@Column(name="REQUEST_QTY")
	public int getRequestQty() {
		return requestQty;
	}
	public void setRequestQty(int requestQty) {
		this.requestQty = requestQty;
	}
	
	@Column(name="CREATED_BY")
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
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
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	@Column(name="MODIFIED_ON")
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PR_ID",nullable=false,insertable=false,updatable=false)
	public TrxPrModel getPr() {
		return pr;
	}
	public void setPr(TrxPrModel pr) {
		this.pr = pr;
	}
	
	@OneToOne(fetch=FetchType.EAGER, mappedBy="prDetail", cascade=CascadeType.ALL)
	public MstItemVariantModel getVariant() {
		return variant;
	}
	public void setVariant(MstItemVariantModel variant) {
		this.variant = variant;
	}
}
