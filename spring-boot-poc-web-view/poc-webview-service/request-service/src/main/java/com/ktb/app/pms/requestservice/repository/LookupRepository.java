package com.ktb.app.pms.requestservice.repository;

import java.util.List;

import com.ktb.app.pms.commonlibrary.model.lookup.LookupRequest;
import com.ktb.app.pms.commonlibrary.model.lookup.LookupResponse;
import com.ktb.app.pms.commonlibrary.model.requestType.RequestTypeRequest;
import com.ktb.app.pms.commonlibrary.model.requestType.RequestTypeResponse;

public interface LookupRepository
{
    List<LookupResponse> getLookupList(LookupRequest lookupRequest) throws Exception;
}
