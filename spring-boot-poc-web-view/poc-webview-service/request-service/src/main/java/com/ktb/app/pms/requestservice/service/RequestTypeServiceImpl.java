package com.ktb.app.pms.requestservice.service;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktb.app.pms.commonlibrary.model.requestType.RequestTypeRequest;
import com.ktb.app.pms.commonlibrary.model.requestType.RequestTypeResponse;
import com.ktb.app.pms.commonlibrary.model.requestType.UpdateRequest;
import com.ktb.app.pms.requestservice.repository.RequestTypeRepository;


@Service("RequestTypeServiceImpl")
public class RequestTypeServiceImpl implements RequestTypeService
{
	@Autowired
	private RequestTypeRepository requestTypeRepository;
	
	@Override
	public List<RequestTypeResponse> getRequestTypeList(RequestTypeRequest requestTypeRequest) throws Exception {
        return this.requestTypeRepository.getRequestTypeList(requestTypeRequest);
    }

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer updateRequest(UpdateRequest updateRequest) throws Exception {
		return requestTypeRepository.updateRequest(updateRequest);
	}
}
