package com.ktb.app.pms.requestservice.service;

import java.util.List;

import com.ktb.app.pms.commonlibrary.model.lookup.LookupRequest;
import com.ktb.app.pms.commonlibrary.model.lookup.LookupResponse;

public interface LookupService {
	
	List<LookupResponse> getLookupList(LookupRequest lookupRequest) throws Exception;

}
