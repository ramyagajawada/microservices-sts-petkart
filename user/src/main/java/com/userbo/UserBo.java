package com.userbo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserBo {
	private String userId;
	private String userName;
	private String userPwd;
	private String email;
	private String confirmed;
	private String petId;
	private Integer petPrice;
}
