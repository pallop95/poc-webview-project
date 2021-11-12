package com.ktb.app.pms.commonlibrary.model.requestType;

import lombok.Data;

@Data
public class UpdateRequest {

	public String system;
	public String action;
	public Long reqHeaderId;
	public String jobId;
	public String fromStatusCode;
	public String toStatusCode;
	public String remark;
	public String fromUserId;

}
