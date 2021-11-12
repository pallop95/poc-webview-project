package com.ktb.app.pms.requestservice.repository;

import java.util.List;
import java.util.Map;

import com.ktb.app.pms.commonlibrary.model.requestDetail.RequestDetailFilesModel;
import com.ktb.app.pms.commonlibrary.model.requestDetail.RequestDetailHeadersModel;

public interface RequestDetailRepository {
    RequestDetailHeadersModel listRequestDetailHeader(String reqHeaderID) throws Exception;
    List<RequestDetailFilesModel> listRequestDetailFile(String reqHeaderID,String reqHeaderNum) throws Exception;
}
