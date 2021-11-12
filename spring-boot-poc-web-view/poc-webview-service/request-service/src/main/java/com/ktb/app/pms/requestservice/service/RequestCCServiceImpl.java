package com.ktb.app.pms.requestservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktb.app.pms.commonlibrary.model.requestCC.RequestCCModel;
import com.ktb.app.pms.commonlibrary.model.requestCC.RequestCCRequest;
import com.ktb.app.pms.commonlibrary.model.requestCC.RequestCCResponse;
import com.ktb.app.pms.requestservice.repository.RequestCCRepository;

@Service("RequestCCServiceImpl")
public class RequestCCServiceImpl implements RequestCCService{

    @Autowired
    private RequestCCRepository requestCCRepository;

    @Override
    public List<RequestCCModel> getRequestCCList(RequestCCRequest requestCCRequest) throws Exception
    {
        return this.requestCCRepository.getRequestCCList(requestCCRequest);
    }
}
