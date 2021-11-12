package com.ktb.app.pms.commonlibrary.entity.request;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AsmWfTaskList {
    private String jobId;
    private String reqNum;
    private Timestamp reqDate;
    private Timestamp sentDate;
    private Long fromUserId;
    private String fromUserName;
    private String fromCostCenterId;
    private String fromCostCenterName;
    private Long toUserId;
    private String toUserName;
    private String toCostCenterId;
    private String toCostCenterName;
    private String sourceType;
    private Long taskId;
    private Long subTaskId;
    private Long responsibleUserId;
    private String responsibleName;
    private String responsibleCostCenterId;
    private String responsibleCostCenterName;
    private String fromStatusCode;
    private String fromStatusName;
    private String toStatusCode;
    private Timestamp createDate;
}
