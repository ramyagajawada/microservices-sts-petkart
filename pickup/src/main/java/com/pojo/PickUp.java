package com.pojo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity

@Table(name="pickup")
public class PickUp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pickupid;
	@Column
	private Long petid;
	@Column
	@JsonIgnore
	private Long userid;
	public Long getPickupid() {
		return pickupid;
	}
	public void setPickupid(Long pickupid) {
		this.pickupid = pickupid;
	}
	public Long getPetid() {
		return petid;
	}
	public void setPetid(Long petid) {
		this.petid = petid;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	
	
	
	
}

