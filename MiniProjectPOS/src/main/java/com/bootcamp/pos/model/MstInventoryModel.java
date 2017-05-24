package com.bootcamp.pos.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="POS_MST_INVENTORY")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="inventoryId")
public class MstInventoryModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer outletId;
	private Integer variantId;
	private Integer beginningQty;
	private Integer poQty;
	private Integer soQty;
	private Integer tranferQty;
	private Integer adjustmentQty;
	private Integer endingQty;
	private Integer alertAtQty;
	private Date createdOn;
	private Integer createdBy;
	private Date modifiedOn;
	private Integer modifiedBy;
	private Integer active;
	private MstItemVariantModel variant;
	private MstOutletModel outlet;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="MST_INVENTORY")
	@TableGenerator(name="MST_INVENTORY",table="POS_MST_SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="MST_INVENTORY", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
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
	
	@Column(name="VARIANT_ID")
	public Integer getVariantId() {
		return variantId;
	}
	public void setVariantId(Integer variantId) {
		this.variantId = variantId;
	}
	
	@Column(name="BEGINNING_QTY")
	public Integer getBeginningQty() {
		return beginningQty;
	}
	public void setBeginningQty(Integer beginningQty) {
		this.beginningQty = beginningQty;
	}
	
	@Column(name="PO_QTY")
	public Integer getPoQty() {
		return poQty;
	}
	public void setPoQty(Integer poQty) {
		this.poQty = poQty;
	}
	
	@Column(name="SO_QTY")
	public int getSoQty() {
		return soQty;
	}
	public void setSoQty(Integer soQty) {
		this.soQty = soQty;
	}
	
	@Column(name="TRANSFER_QTY")
	public int getTranferQty() {
		return tranferQty;
	}
	public void setTranferQty(Integer tranferQty) {
		this.tranferQty = tranferQty;
	}
	
	@Column(name="ADJUSTMENT_QTY")
	public int getAdjustmentQty() {
		return adjustmentQty;
	}
	public void setAdjustmentQty(Integer adjustmentQty) {
		this.adjustmentQty = adjustmentQty;
	}
	
	@Column(name="ENDING_QTY")
	public Integer getEndingQty() {
		return endingQty;
	}
	public void setEndingQty(Integer endingQty) {
		this.endingQty = endingQty;
	}
	
	@Column(name="ALERT_AT_QTY")
	public Integer getAlertAtQty() {
		return alertAtQty;
	}
	public void setAlertAtQty(Integer alertAtQty) {
		this.alertAtQty = alertAtQty;
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
	
	@OneToOne(fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn
	public MstItemVariantModel getVariant() {
		return variant;
	}
	public void setVariant(MstItemVariantModel variant) {
		this.variant = variant;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="OUTLET_ID",nullable=false,insertable=false, updatable=false)
	public MstOutletModel getOutlet() {
		return outlet;
	}
	public void setOutlet(MstOutletModel outlet) {
		this.outlet = outlet;
	}
}
