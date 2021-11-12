package com.ktb.app.pms.requestservice.service;

import java.util.List;

import com.ktb.app.pms.commonlibrary.model.request.RequestModel;
import com.ktb.app.pms.commonlibrary.model.request.ResponseModel;

public interface RequestService {
    ResponseModel createRequest(RequestModel request) throws Exception;
//    ResponseModel createRequest(RequestHeaderModel requestHeader, List<RequestFileModel> RequestFileList) throws Exception;
}
