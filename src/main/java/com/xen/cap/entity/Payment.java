package com.xen.cap.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name=Payment.Columns.TABLE)
public class Payment {
	public interface Columns{
		String TABLE = "payment";
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition="INT UNSIGNED", nullable = false)
    private Long id;
	
	
	@Column(name="merchant", nullable = false)
	private String merchant;
	
	@Column(name="customer", nullable = false)
	private String customer;	
	
	@Column(name="money")
	private String money;

}
