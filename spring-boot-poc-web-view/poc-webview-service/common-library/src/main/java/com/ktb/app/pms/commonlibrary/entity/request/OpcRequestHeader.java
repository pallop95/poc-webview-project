package com.ktb.app.pms.commonlibrary.entity.request;

import java.util.Date;

import lombok.Data;

@Data
public class OpcRequestHeader {

	private Long reqHeaderId;
	private String reqHeaderNum;
	private String reqUserId;
	private String reqCostCenter;
	private String reqTel;
	private String reqRemark;
	private Date createDate;
	private String createBy;
	private String lastUpdate;
	private String lastUpdateBy;
	private String jobId;
	private Long wfSeq;
	private String reqCcName;
	private String reqUserName;
	private String remark;
	private String responseGroupCc;
	private String reqTaskType;
	private String reqUserEmail;
	private String reqType;
	private String remark1;
	private String ccProcess;
	private String responseCc;
	private String hqProcess;
	private String responseUser;
	private String buildingId;
	private Long psResponseUser;
	private String costCenterClose;
	private String costCenterMain;

}
