package com.pojos;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
@Getter
@Setter
@ToString
@Entity
@Table(name="user_table")

public class User {
	@Id
	private String userId;
	private String userName;
	private String userPwd;
	private String email;
	private String confirmed;
	
	private String petId;
	
	
	}
