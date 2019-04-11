package com.xen.cap.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TagDto {
	@JsonProperty("uin")
	private String uin;
	@JsonProperty("username")
	private String username;
	@JsonProperty("pin")
	private String pin;
	@JsonProperty("lock")
	private String lock;
	@JsonProperty("valid")
	private String valid;
	@JsonProperty("limit")
	private String limit;
}
