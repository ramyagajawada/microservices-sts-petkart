package com.pojos;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="admin_table")
@Getter
@Setter
@ToString

public class Admin {
	@Id
	private String adminId;
	private String adminName;
	private String adminPwd;
}
