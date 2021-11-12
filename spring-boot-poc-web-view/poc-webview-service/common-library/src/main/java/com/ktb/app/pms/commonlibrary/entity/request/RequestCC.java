package com.ktb.app.pms.commonlibrary.entity.request;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class RequestCC
{
    public Long reqHeaderID;
    public String reqHeaderNum;
    public Timestamp reqDate;
    public String reqDesc;
    public String reqUserID;
    public String reqUserName;
    public Long reqResponseUser;
    public String reqResponseName;
    public String reqResponseTel;
    public String reqCCProcess;
    public String reqStatus;
}
