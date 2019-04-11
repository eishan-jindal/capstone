package com.xen.cap.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDto {
	@JsonProperty("money")
	private String money;
	@JsonProperty("customer")
	private String customer;
	@JsonProperty("merchant")
	private String merchant;

}
