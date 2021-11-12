package com.ktb.app.pms.commonlibrary.model.request;

import com.ktb.app.pms.commonlibrary.entity.request.RequestFile;

import lombok.Data;

@Data
public class RequestFileModel extends RequestFile
{
	public String base64Str;
	public String type;
}
