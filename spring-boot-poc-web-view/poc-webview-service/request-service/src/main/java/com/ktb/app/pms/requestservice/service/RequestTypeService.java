package com.ktb.app.pms.requestservice.service;

import java.util.List;

import com.ktb.app.pms.commonlibrary.model.requestType.RequestTypeRequest;
import com.ktb.app.pms.commonlibrary.model.requestType.RequestTypeResponse;
import com.ktb.app.pms.commonlibrary.model.requestType.UpdateRequest;

public interface RequestTypeService {
	
	List<RequestTypeResponse> getRequestTypeList(RequestTypeRequest requestTypeRequest) throws Exception;
	Integer updateRequest(UpdateRequest updateRequest) throws Exception;
}
