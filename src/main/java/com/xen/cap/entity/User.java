package com.xen.cap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


import lombok.Data;

@Data
@Entity
@Table(name = "User")
public class User {
	public interface Columns{
		String PHONE = "phone";
		String BALANCE = "balance";
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition="INT UNSIGNED",nullable = false)
    private Long id;
	
	@NotEmpty(message = "*Please provide your password")
    @Column(name = "password", length = 16, nullable = false)
    private String password;
	
    @Column(name = "username", nullable = false)
    private String username;
	
	@Column(name=Columns.BALANCE)
	private String balance;
	
    @Column(name = "role", nullable = false)
    private String role;
	
	
}
