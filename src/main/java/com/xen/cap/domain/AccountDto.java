package com.xen.cap.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto {
	@JsonProperty("account_id")
	private int accountId;
	@JsonProperty("uid")
	private String userId;
	@JsonProperty("password")
	private String password;
	@JsonProperty( "first_name")
	private Double firstName;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("phone")
	private String phone;
	@JsonProperty("balance")
	private String balance;
}
