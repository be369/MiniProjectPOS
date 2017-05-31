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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.bootcamp.pos.model.MstInventoryModel;
import com.bootcamp.pos.model.MstItemModel;
import com.bootcamp.pos.model.TrxPrDetailModel;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="POS_MST_ITEM_VARIANT")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="variantId")
public class MstItemVariantModel {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int itemId;
	private String name;
	private String sku;
	private Double price;
	private Date createdOn;
	private int createdBy;
	private Date modifiedOn;
	private int modifiedBy;
	private int active;
	private MstInventoryModel inventory;
	private MstItemModel item;
	private TrxPrDetailModel prDetail;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="MST_ITEM_VARIANT")
	@TableGenerator(name="MST_ITEM_VARIANT",table="POS_MST_SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="MST_ITEM_VARIANT", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="ITEM_ID")
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	@Column(name="NAME", length=255)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="SKU", length=50)
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	@Column(name="PRICE")
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Column(name="CREATED_ON")
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@Column(name="CREATED_BY")
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
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
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	@Column(name="ACTIVE")
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy="variant", cascade=CascadeType.ALL)
	public MstInventoryModel getInventory() {
		return inventory;
	}
	public void setInventory(MstInventoryModel inventory) {
		this.inventory = inventory;
	}
	
	
	@OneToOne(fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn
	public TrxPrDetailModel getPrDetail() {
		return prDetail;
	}
	public void setPrDetail(TrxPrDetailModel prDetail) {
		this.prDetail = prDetail;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ITEM_ID",nullable=false,insertable=false, updatable=false)
	public MstItemModel getItem() {
		return item;
	}
	public void setItem(MstItemModel item) {
		this.item = item;
	}
}
