package com.pojo;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity
@Table(name="pet_table")
public class Pet {
	@Id
	private String petId;
	private String petName;
	private String petType;
	private Integer petPrice;
	private String petDescription;
	
	 
	
	}

