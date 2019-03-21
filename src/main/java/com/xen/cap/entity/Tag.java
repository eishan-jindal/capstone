package com.xen.cap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name=Tag.Columns.TABLE)
public class Tag extends BaseEntity implements Serializable {
	public interface Columns extends BaseEntity.Columns{
		String TABLE = "tags";
		String TAG_ID = "tag_id";
		String ACCOUNT_ID = "account_id";
		String PIN = "pin";
		String LOCK_ACTIVE = "lock_active";
		String VALID = "valid";
		String CREDIT_LIMIT = "credit_limit";
	}
	@Column(unique = true, name = Columns.TAG_ID, length = 8, nullable = false)
	private String tagId;
	
	@Column(name = Columns.ACCOUNT_ID, nullable = false, unique = true)
	private String accountId;
	
	@Column(name=Columns.PIN, length = 4, nullable = false)
	private String pin;
	
	@Column(name=Columns.LOCK_ACTIVE, nullable = false)
	private String isLockActive;
	
	@Column(name=Columns.VALID, nullable = false)
	private String isValid;
	
	@Column(name=Columns.CREDIT_LIMIT, nullable = false)
	private String creditLimit;
}
