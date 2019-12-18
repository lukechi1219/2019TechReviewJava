package com.nv.tech.retrofit2.example.dto;

import java.math.BigDecimal;

import lombok.Getter;

// {username=null, balance=0.0, outstanding=0.0, error={id=3303.0, msg=UserNotExists}, serverId=A71}
public class SBOBETResponse {

	@Getter
	private String username;
	@Getter
	private BigDecimal balance;
	@Getter
	private String outstanding;
	@Getter
	private String serverId;

	@Getter
	private ApiError error;

	public class ApiError {

		@Getter
		private int id;
		@Getter
		private String msg = "";
	}
}
