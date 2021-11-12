package com.ktb.app.pms.requestservice.service;

import java.util.Map;

public interface RequestDetailService {
    Map<String,Object> getRequestDetail(String reqHeaderID) throws Exception;
}
