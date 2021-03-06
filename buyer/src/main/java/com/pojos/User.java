package com.pojos;
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
@Table(name="user_table")
public class User {
	@Id
	private String userId;
	private String userName;
	private String userPwd;
	private String email;
	private String confirmed;
	
	}
