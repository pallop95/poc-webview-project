package com.ktb.app.pms.requestservice.service;

import java.util.List;

import com.ktb.app.pms.commonlibrary.model.requestCC.RequestCCModel;
import com.ktb.app.pms.commonlibrary.model.requestCC.RequestCCRequest;
import com.ktb.app.pms.commonlibrary.model.requestCC.RequestCCResponse;

public interface RequestCCService {
    List<RequestCCModel> getRequestCCList(RequestCCRequest requestCCRequest) throws Exception;
}
