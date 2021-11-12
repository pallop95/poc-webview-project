package com.ktb.app.pms.commonlibrary.model.requestCC;

import lombok.Data;

@Data
public class RequestCCRequest {
    public String system;
    public String ccCode;
    public String notStatus;
}
