package com.ktb.app.pms.requestservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktb.app.pms.commonlibrary.entity.request.RequestDetailHeaders;
import com.ktb.app.pms.commonlibrary.model.requestDetail.RequestDetailFilesModel;
import com.ktb.app.pms.commonlibrary.model.requestDetail.RequestDetailHeadersModel;
import com.ktb.app.pms.requestservice.repository.RequestDetailRepository;

@Service("RequestDetailServiceImpl")
public class RequestDetailServiceImpl implements RequestDetailService{

    @Autowired
    RequestDetailRepository requestDetailRepository;

    @Override
    public Map<String, Object> getRequestDetail(String reqHeaderID) throws Exception
    {
        Map<String, Object> result = new HashMap<>();

        RequestDetailHeadersModel requestDetailHeader =
            this.requestDetailRepository.listRequestDetailHeader(reqHeaderID);

        List<RequestDetailFilesModel> requestDetailFilesList =
            this.requestDetailRepository.listRequestDetailFile(reqHeaderID, requestDetailHeader.getReqHeaderNum());

        result.put("header",requestDetailHeader);
        result.put("fileList",requestDetailFilesList);

        return result;
    }
}
