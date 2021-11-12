package com.ktb.app.pms.commonlibrary.entity.request;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class RequestDetailHeaders
{
    private Long reqHeaderID;
    private String reqHeaderNum;
    private Timestamp reqDate;
    private String reqDesc;
    private String reqUserID;
    private String reqUserName;
    private String reqUserTel;
    private String reqResponseUser;
    private String reqResponseName;
    private String reqResponseTel;
    private String reqCCProcess;
    private String reqStatus;
    private String reqCC;
    private String reqCCName;
    private String reqCCAddress;
    private String reqCCTel;
    private String reqType;
}
