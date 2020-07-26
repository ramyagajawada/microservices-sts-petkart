package com.pojos;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pet_table")
public class Pet {
	@Id
	private String petId;
	private String petName;
	private String petType;
	private int petPrice;
	private String petDescription;
	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", petName=" + petName + ", petType=" + petType + ", petPrice=" + petPrice
				+ ", petDescription=" + petDescription + "]";
	}
	
	public String getPetId() {
		return petId;
	}
	public void setPetId(String petId) {
		this.petId = petId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetType() {
		return petType;
	}
	public void setPetType(String petType) {
		this.petType = petType;
	}
	public int getPetPrice() {
		return petPrice;
	}
	public void setPetPrice(int petPrice) {
		this.petPrice = petPrice;
	}
	public String getPetDescription() {
		return petDescription;
	}
	public void setPetDescription(String petDescription) {
		this.petDescription = petDescription;
	}
	
	}
