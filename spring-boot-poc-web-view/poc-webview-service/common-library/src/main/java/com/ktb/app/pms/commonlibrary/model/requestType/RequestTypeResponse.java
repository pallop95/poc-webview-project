package com.ktb.app.pms.commonlibrary.model.requestType;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class RequestTypeResponse {

	@SerializedName("TYPE_ID")
	private Long typeId;

	@SerializedName("TYPE_CODE")
	private String typeCode;

	@SerializedName("TYPE_NAME")
	private String typeName;

	@SerializedName("SLA_DAY")
	private Long slaDay;

	@SerializedName("USE_FROM")
	private String useFrom;

}
