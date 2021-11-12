package com.ktb.app.pms.commonlibrary.entity;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Users {
	private String keytoken;
	private String username;
	private String fullname;
	private String ccCode;
	private String ccName;
	private String roleId;
	private String enableFlag;
	private String email;
	private String position;
	private Long groupId;
	private String systemCode;
}
