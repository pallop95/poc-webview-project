package com.ktb.app.pms.requestservice.repository;

import java.util.List;

import com.ktb.app.pms.commonlibrary.entity.request.AsmAppSetting;
import com.ktb.app.pms.commonlibrary.entity.request.AsmWfTaskHistory;
import com.ktb.app.pms.commonlibrary.entity.request.AsmWfTaskList;
import com.ktb.app.pms.commonlibrary.entity.request.OpcRequestFile;
import com.ktb.app.pms.commonlibrary.entity.request.OpcRequestHeader;
import com.ktb.app.pms.commonlibrary.entity.request.SpGetCurrWf;



public interface RequestRepository {
    AsmWfTaskList insertAsmWfTaskList(AsmWfTaskList asmWfTaskList) throws Exception;
    AsmWfTaskHistory insertAsmWfTaskHistory(AsmWfTaskHistory asmWfTaskHistory) throws Exception;
    AsmAppSetting findByAppKey(String appKey) throws Exception;
    OpcRequestHeader insertRequest(OpcRequestHeader opcRequestHeader) throws Exception;

    List<SpGetCurrWf> listSpGetCurrWf(String reqTaskType, String buidingID) throws Exception;
//    sp_GET_CURR_WF  fnDealOutCards(@reqTaskType,@buidingID)
//    SpGetCurrWf fnDealOutCards(String reqTaskType, String buidingID) throws Exception;

    OpcRequestFile insertOpcRequestFile(OpcRequestFile opcRequestFile) throws Exception;
    String getRunningNumber(String sYear, String sCostCenter) throws Exception;
}
