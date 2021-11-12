package com.ktb.app.pms.commonlibrary.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.util.Arrays;

@Data
public class SeUsers {

	private Long id;
	private String enabled;
	private String username;
	private String description;
	private String passwd;
	private String userRealName;
	private String title;
	private String firstname;
	private String lastname;
	private String email;
	private String jobTitle;
	private String userTypeConst;
	private String rankCode;
	private String titleCode;
	private String encryptedPassword;
	private String passwordSalt;
	private String authenticationToken;
	private String rememberToken;
	private Timestamp rememberCreatedAt;
	private String signInCount;
	private Timestamp currentSignInAt;
	private Timestamp lastSignInAt;
	private String currentSignInIp;
	private String lastSignInIp;
	private Long branchId;
	private Long lawOfficeLawyerId;
	private Long employedToId;
	private String pass;
	private String address;
	private Long districtId;
	private String mobile;
	private String phone;
	private Long provinceId;
	private String subdistrict;
	private String jobCodeDesc;
	private Long subBranchId;
	private String subBranchFlag;
	private String userClassCode;
	private String userClassCaption;
	private String refreshToken;
	private String custType;


}
