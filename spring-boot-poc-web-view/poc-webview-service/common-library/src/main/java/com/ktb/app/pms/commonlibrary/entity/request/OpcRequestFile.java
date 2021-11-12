package com.ktb.app.pms.commonlibrary.entity.request;

import lombok.Data;

@Data
public class OpcRequestFile {

//	FILE_ID| Long
//	REQ_HEADER_ID| Long
//	FILE_NO| Long
//	FILE_NAME| String
//	FILE_URL| String
//	FILE_FLAG| String
//	   8877|
//	   1|
//	   1|
//	   464108451000011.jpg|
//	   ~/File/Request_File/46410845100001/464108451000011.jpg|
//	   Y|

	private Long fileId;
	private Long reqHeaderId;
	private Long fileNo;
	private String fileName;
	private String fileUrl;
	private String fileFlag;
}
