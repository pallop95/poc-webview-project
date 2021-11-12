package com.ktb.app.pms.commonlibrary.controller;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import com.ktb.app.pms.commonlibrary.model.base.ResponseConst;
import com.ktb.app.pms.commonlibrary.model.base.ResponseHeader;
import com.ktb.app.pms.commonlibrary.util.Validate;

import lombok.extern.slf4j.Slf4j;

//import org.apache.commons.collections4.CollectionUtils;

@Slf4j
@Component
public class BaseController {

	protected ResponseHeader initHeaderSuccess(final Object data) {
	    if(data == null) {
	
	      return initHeader(ResponseConst.Response.CD2001, null);
	    } else if (data instanceof Collection && CollectionUtils.size(data) <= 0) {
	
	      return initHeader(ResponseConst.Response.CD2001, null);
	    } else {
	
	      return initHeader(ResponseConst.Response.CD2000, null);
	    }
	}
	
	private ResponseHeader initHeader(ResponseConst.Response code, String desc) {
	    String code2 = code.name();
	    if(code2.startsWith("CD")) {
	      code2 = code2.substring(2);
	    }
	    ResponseHeader header = new ResponseHeader();
	    header.setCode(code2);
	    header.setDesc(desc);
//	    header.setRefreshVersion(flagRefreshClient.getFlagRefreshClient());
	    if (Validate.empty(desc)) {
	      header.setDesc(code.getValue());
	    }

	    return header;
	}
	
	protected ResponseHeader initHeaderError(final Exception data) {
	    if(data == null) {

	      return initHeader(ResponseConst.Response.CD5000, data.getMessage());
	    } else if (data instanceof Exception){

	      return initHeader(ResponseConst.Response.CD5000, data.getMessage());
	    } else if (data instanceof RuntimeException){

	      return initHeader(ResponseConst.Response.CD5101, data.getMessage());
	    } else {
	      ResponseConst.Response[]codes = ResponseConst.Response.values();
	      for(ResponseConst.Response code : codes) {
	        String cd = code.name().substring(2);
	        if(data.getClass().getSimpleName().endsWith(cd)) {

	          return initHeader(code, data.getMessage());
	        }
	      }
	    }

	    return initHeader(ResponseConst.Response.CD5000, data.getMessage());
	  }
}
