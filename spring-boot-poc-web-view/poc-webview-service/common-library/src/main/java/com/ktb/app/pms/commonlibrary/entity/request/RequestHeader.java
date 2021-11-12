package com.ktb.app.pms.commonlibrary.entity.request;

import lombok.Data;

@Data
public class RequestHeader {
    private String system;
    private String reqUserID;
    private String reqCC;
    private String reqTel;
    private String reqRemark;
    private String reqCCName;
    private String reqUserName;
    private String remark;
    private String reqTaskType;
    private String reqUserEmail;
    private String reqType;
    private String reqCCProcess;
    private String hqProcess;
    private String buidingID;
    private String ccClose;
    private String ccMain;
    private String fromStatusCode;
    private String toStatusCode;

}
