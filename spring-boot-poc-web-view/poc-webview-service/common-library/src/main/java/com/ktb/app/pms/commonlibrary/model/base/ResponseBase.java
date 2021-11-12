package com.ktb.app.pms.commonlibrary.model.base;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResponseBase implements Serializable
{
  @JsonIgnore
  private static final long serialVersionUID = -4549940090380658147L;
  
//	private ResponseHeader header;
//	
//	public ResponseHeader getHeader() {
//	  return header;
//	}
	public void setHeader(ResponseHeader header) {
//	  this.header = header;
		this.responseCode = header.getCode();
		this.responseDetail = header.getDesc();
	}
//	
//	public <T extends ResponseBase> T throwExceptionIfError() throws Exception{
//	  if(!ResponseConst.Response.CD2000.getValue().equalsIgnoreCase(this.header.getDesc())) {
//	    throw new Exception(this.header.getDesc());
//	  }
//	  return (T)this;
//	}
  
  	private String responseCode;
  	private String responseDetail;

	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseDetail() {
		return responseDetail;
	}
	public void setResponseDetail(String responseDetail) {
		this.responseDetail = responseDetail;
	}

	public <T extends ResponseBase> T throwExceptionIfError() throws Exception{
	  if(!ResponseConst.Response.CD2000.getValue().equalsIgnoreCase(this.getResponseDetail())) {
	    throw new Exception(this.getResponseDetail());
	  }
	  return (T)this;
	}

}