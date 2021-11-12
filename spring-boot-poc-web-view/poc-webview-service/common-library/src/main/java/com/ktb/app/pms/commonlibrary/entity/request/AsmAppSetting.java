package com.ktb.app.pms.commonlibrary.entity.request;

import java.sql.Timestamp;

import lombok.Data;


@Data
public class AsmAppSetting {
    private String appKey;
    private String type;
    private String value;
    private String description;
    private Timestamp createDate;
    private String createBy;
    private Timestamp lastUpdateDate;
    private String lastUpdateBy;
    private String name;
}
