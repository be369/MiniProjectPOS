package com.bootcamp.pos.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="POS_MST_OUTLET")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="outletId")
public class MstOutletModel {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private int provinceId;
	private int regionId;
	private int districtId;
	private int villageId;
	private int postalCode;
	private Date createdOn;
	private int createdBy;
	private Date modifiedOn;
	private int modifiedBy;
	private int active;
	
}
