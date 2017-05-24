package com.bootcamp.pos.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="POS_MST_ITEM")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="itemId")
public class MstItemModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer categoryId;
	private String name;
	private Date createdOn;
	private Integer createdBy;
	private Date modifiedOn;
	private Integer modifiedBy;
	private Integer active;
	
	private Set<MstItemVariantModel> variant=new HashSet<MstItemVariantModel>(0);
	private MstCategoryModel category;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="MST_ITEM")
	@TableGenerator(name="MST_ITEM",table="POS_MST_SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="MST_ITEM", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="CATEGORY_ID")
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	@Column(name="NAME", columnDefinition="varchar(255)")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@OneToMany(fetch = FetchType.EAGER, mappedBy="item")
	@JsonManagedReference
	public Set<MstItemVariantModel> getVariant() {
		return variant;
	}
	public void setVariant(Set<MstItemVariantModel> variant) {
		this.variant = variant;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CATEGORY_ID",nullable=false,insertable=false, updatable=false)
	public MstCategoryModel getCategory() {
		return category;
	}
	public void setCategory(MstCategoryModel category) {
		this.category = category;
	}
	
}
