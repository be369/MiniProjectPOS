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
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="POS_TRX_PR_DETAIL")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="prdetilId")
public class TrxPrDetailModel {
	private Integer id;
	private Integer prId;
	private Integer variantId;
	private Integer requestQty;
	private Date createdOn;
	private Integer createdBy;
	private Date modifiedOn;
	private Integer modifiedBy;
	private TrxPrModel pr;
	private MstItemVariantModel variant;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="TRX_PR_DETAIL")
	@TableGenerator(name="TRX_PR_DETAIL",table="POS_MST_SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="TRX_PR_DETAIL", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="PR_ID")
	public Integer getPrId() {
		return prId;
	}
	public void setPrId(Integer prId) {
		this.prId = prId;
	}
	
	@Column(name="VARIANT_ID")
	public Integer getVariantId() {
		return variantId;
	}
	public void setVariantId(Integer variantId) {
		this.variantId = variantId;
	}
	
	@Column(name="REQUEST_QTY")
	public Integer getRequestQty() {
		return requestQty;
	}
	public void setRequestQty(Integer requestQty) {
		this.requestQty = requestQty;
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
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PR_ID",nullable=false,insertable=false, updatable=false)
	public TrxPrModel getPr() {
		return pr;
	}
	public void setPr(TrxPrModel pr) {
		this.pr = pr;
	}
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy="prDetail", cascade=CascadeType.ALL)
	public MstItemVariantModel getVariant() {
		return variant;
	}
	public void setVariant(MstItemVariantModel variant) {
		this.variant = variant;
	}
}
