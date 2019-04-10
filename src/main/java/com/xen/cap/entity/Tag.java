package com.xen.cap.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name=Tag.Columns.TABLE)
public class Tag {
	public interface Columns{
		String TABLE = "tag";
		String PK = "id";
	}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition="INT UNSIGNED", name = Columns.PK, nullable = false)
	private Long id;
	
	@Column(name = "uin", length = 8, nullable = false, unique = true)
	private String uin;
    
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name="pin", length = 4, nullable = false)
	private String pin;
	
	@Column(name="lock", nullable = false)
	private String lock;
	
	@Column(name="valid", nullable = false)
	private String valid;
	
	@Column(name="limit", nullable = false)
	private String limit;
}
