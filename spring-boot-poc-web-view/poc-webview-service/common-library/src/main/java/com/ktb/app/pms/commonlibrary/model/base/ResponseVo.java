package com.ktb.app.pms.commonlibrary.model.base;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResponseVo<T> extends ResponseBase implements Serializable
{
    private static final long serialVersionUID = 5282106190451823196L;
    private T response;
}
