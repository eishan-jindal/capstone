package com.xen.cap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xen.cap.entity.Account.Columns;

import lombok.Data;

@Data
@Entity
@Table(name=Payment.Columns.TABLE)
public class Payment extends BaseEntity implements Serializable {
	public interface Columns extends BaseEntity.Columns{
		String TABLE = "payments";
		String TAG_ID = "tag_id";
		String MERCHANT_ID = "merchant_id";
		String CUSTOMER_ID = "customer_id";
		String AMOUNT = "amount";
		String STATUS = "status";
	}
	@Column(name=Columns.TAG_ID, length=8, nullable = false, unique = true)
	private String tagId;
	
	@Column(name=Columns.MERCHANT_ID, nullable = false)
	private String merchantID;
	
	@Column(name=Columns.CUSTOMER_ID, nullable = false)
	private String customerID;	
	
	@Column(name=Columns.AMOUNT)
	private String amount;
	
	@Column(name=Columns.STATUS, nullable = false)
	private String status;
}
