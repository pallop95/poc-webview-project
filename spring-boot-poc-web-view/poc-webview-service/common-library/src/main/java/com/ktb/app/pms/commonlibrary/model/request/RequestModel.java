package com.ktb.app.pms.commonlibrary.model.request;

import java.util.List;

import lombok.Data;

@Data
public class RequestModel {
    public RequestHeaderModel RequestHeader;
    public List<RequestFileModel> RequestFileList;
}
