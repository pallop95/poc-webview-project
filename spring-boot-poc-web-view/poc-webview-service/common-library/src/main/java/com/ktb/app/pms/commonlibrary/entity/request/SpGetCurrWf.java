package com.ktb.app.pms.commonlibrary.entity.request;

import lombok.Data;

@Data
public class SpGetCurrWf {
	
	private Long rowNum;
	private String wfId;
	private Long wfSeq;
	private String userId;
	private String userName;
	private String userCc;
	private String userCcName;
	private String userEmail;
	private String telphone;

}
