package com.ktb.app.pms.authservice.domain;

import lombok.Data;

@Data
public class AuthenRequest {
	private String system;
	private String bearer;
}
