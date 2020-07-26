package com.pojos;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="admin_table")
@Getter
@Setter
public class Admin {
	@Id
	private String adminId;
	private String adminName;
	private String adminPwd;
}
