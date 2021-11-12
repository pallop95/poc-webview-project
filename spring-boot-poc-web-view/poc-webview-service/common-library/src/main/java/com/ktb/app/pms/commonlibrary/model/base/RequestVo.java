package com.ktb.app.pms.commonlibrary.model.base;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class RequestVo<T> extends ResponseBase implements Serializable 
{
	@JsonIgnore
	private static final long serialVersionUID = 5282106190451823196L;
	private T data;

}