package com.ktb.app.pms.commonlibrary.model.requestCC;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class RequestCCResponse {
    @SerializedName("REQ_HEADER_ID")
    public Long reqHeaderID;
    @SerializedName("REQ_HEADER_NUM")
    public Long reqHeaderNum;
    @SerializedName("REQ_DATE")
    public Date reqDate;
    @SerializedName("REQ_DESC")
    public String reqDesc;
    @SerializedName("REQ_USER_ID")
    public Long reqUserID;
    @SerializedName("REQ_USER_NAME")
    public String reqUserName;
    @SerializedName("TO_USER_ID")
    public Long reqResponseUser;
    @SerializedName("TO_USER_NAME")
    public String reqResponseName;
    @SerializedName("TO_USER_TEL")
    public String reqResponseTel;
    @SerializedName("CC_PROCESS")
    public String reqCCProcess;
    @SerializedName("STATUS_NAME")
    public String reqStatus;

}
