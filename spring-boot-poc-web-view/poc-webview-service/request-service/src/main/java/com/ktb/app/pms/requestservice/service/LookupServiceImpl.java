package com.ktb.app.pms.requestservice.service;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktb.app.pms.commonlibrary.model.lookup.LookupRequest;
import com.ktb.app.pms.commonlibrary.model.lookup.LookupResponse;
import com.ktb.app.pms.requestservice.repository.LookupRepository;


@Service("LookupServiceImpl")
public class LookupServiceImpl implements LookupService
{
	@Autowired
	private LookupRepository lookupRepository;
	
	@Override
	public List<LookupResponse> getLookupList(LookupRequest lookupRequest) throws Exception {
        return this.lookupRepository.getLookupList(lookupRequest);
    }
}
