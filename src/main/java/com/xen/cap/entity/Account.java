package com.xen.cap.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = Account.Columns.TABLE)
public class Account extends BaseEntity implements Serializable {
	public interface Columns extends BaseEntity.Columns{
		String TABLE = "accounts";
		String UID = "uid";
		String PWD = "password";
		String F_NAME = "first_name";
		String L_NAME = "last_name";
		String PHONE = "phone";
		String BALANCE = "balance";
	}

	@Column(name = Columns.UID, length = 9, nullable = false, unique = true)
	@NotEmpty(message = "Please provide your University Roll No")
	private String userId;
	
	@Column(name=Columns.PWD, nullable = false)
	private String password;
	
	@Column(name=Columns.F_NAME, nullable = false)
	private String firstName;
	
	@Column(name=Columns.L_NAME, nullable = false)
	private String lastName;
	
	@Column(name=Columns.PHONE,length=10, nullable = false, unique = true)
	private String phone;
	
	@Column(name=Columns.BALANCE)
	private String balance;
	
}
