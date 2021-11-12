package com.ktb.app.pms.commonlibrary.entity.request;

import lombok.Data;

@Data
public class RequestDetailFiles
{
    private Long reqHeaderID;
    private Long reqFileID;
    private String reqFileName;
    private String reqFileURL;
}
