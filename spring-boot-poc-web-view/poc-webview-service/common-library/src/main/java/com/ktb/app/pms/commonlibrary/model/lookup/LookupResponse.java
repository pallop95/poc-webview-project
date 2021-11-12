package com.ktb.app.pms.commonlibrary.model.lookup;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class LookupResponse {
	@SerializedName("LOOKUP_TYPE")
	public String lookupType;
	@SerializedName("LOOKUP_CODE")
	public String lookupCode;
	@SerializedName("MEANING")
	public String meaning;
	@SerializedName("DESCRIPTION")
	public String desc;
	@SerializedName("ORDER")
	public String order;
}
