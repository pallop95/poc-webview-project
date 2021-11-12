package com.ktb.app.pms.requestservice.controller;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktb.app.pms.commonlibrary.controller.BaseController;
import com.ktb.app.pms.commonlibrary.model.base.ResponseBase;
import com.ktb.app.pms.commonlibrary.model.base.ResponseList;
import com.ktb.app.pms.commonlibrary.model.base.ResponseVo;
import com.ktb.app.pms.commonlibrary.model.requestType.RequestTypeRequest;
import com.ktb.app.pms.commonlibrary.model.requestType.RequestTypeResponse;
import com.ktb.app.pms.commonlibrary.model.requestType.UpdateRequest;
import com.ktb.app.pms.requestservice.service.RequestTypeService;

import lombok.extern.slf4j.Slf4j;

@RestController("RequestTypeController")
@RequestMapping("/requestType")
@Slf4j
public class RequestTypeController extends BaseController
{
    @Autowired
    RequestTypeService requestTypeService;
    
    @PostMapping("/list")
    public ResponseList<RequestTypeResponse> getJudgeTypeConstList(
    		@RequestBody RequestTypeRequest requestTypeRequest,
    		HttpServletResponse response) {
        ResponseList<RequestTypeResponse> respDataList = new ResponseList<>();
        try {
            List<RequestTypeResponse> result = this.requestTypeService.getRequestTypeList(requestTypeRequest);
            respDataList.setHeader(initHeaderSuccess(result));
            respDataList.setResponseList(result);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            respDataList.setHeader(initHeaderError(e));
        }
        return respDataList;
    }

    @PostMapping("/updateRequest")
//    public ResponseVo<ResponseBase> updateRequest(
    public ResponseBase updateRequest(
    		@RequestBody UpdateRequest updateRequest,
    		HttpServletResponse response) {
//    	ResponseVo<ResponseBase> respDataList = new ResponseVo<>();
    	ResponseBase responseBase = new ResponseBase();
        try {
        	Integer result = requestTypeService.updateRequest(updateRequest);
        	responseBase.setHeader(initHeaderSuccess(result));
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            responseBase.setHeader(initHeaderError(e));
        }
        return responseBase;
    }
}
