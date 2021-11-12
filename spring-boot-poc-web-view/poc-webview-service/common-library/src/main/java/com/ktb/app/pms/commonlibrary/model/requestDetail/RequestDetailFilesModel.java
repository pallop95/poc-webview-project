package com.ktb.app.pms.commonlibrary.model.requestDetail;


import com.ktb.app.pms.commonlibrary.entity.request.RequestDetailFiles;

import lombok.Data;

@Data
public class RequestDetailFilesModel extends RequestDetailFiles
{
    public String fullUrl;
}
