package com.ktb.app.pms.commonlibrary.model.user;

import com.ktb.app.pms.commonlibrary.util.Validate;

import lombok.Data;

@Data
public class UserDetailResponse {

	private String username;
	private String fullName;
	private String costCenterCode;
	private String costCenterName;
	private String email;
	
	private String additionalText;
	private String address;
	private String telephone;

	public String getFullname() {
		return fullName;
	}

	public String getCcCode() {
		return costCenterCode;
	}
	
	public String getCcName() {
		return costCenterName;
	}
	
	public String getCcAddress() {
		return (!Validate.empty(additionalText) ? additionalText: "") + 
			(!Validate.empty(additionalText) ? " ": "") +
			(!Validate.empty(address) ? address: "");
	}

	public String getCcTelphone() {
		return telephone;
	}
}
