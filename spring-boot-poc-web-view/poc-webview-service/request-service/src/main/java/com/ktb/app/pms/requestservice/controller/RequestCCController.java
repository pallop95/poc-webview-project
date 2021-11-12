package com.ktb.app.pms.requestservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktb.app.pms.commonlibrary.controller.BaseController;
import com.ktb.app.pms.commonlibrary.model.base.ResponseList;
import com.ktb.app.pms.commonlibrary.model.requestCC.RequestCCModel;
import com.ktb.app.pms.commonlibrary.model.requestCC.RequestCCRequest;
import com.ktb.app.pms.commonlibrary.model.requestCC.RequestCCResponse;
import com.ktb.app.pms.requestservice.service.RequestCCService;

import lombok.extern.slf4j.Slf4j;

@RestController("RequestCCController")
@RequestMapping("/requestCC")
@Slf4j
public class RequestCCController extends BaseController
{

    @Autowired
    RequestCCService requestCCService;

    @PostMapping("/list")
    public ResponseList<RequestCCModel> getJudgeTypeConstList(

        @RequestBody RequestCCRequest requestCCRequest,
        HttpServletResponse response) {
        ResponseList<RequestCCModel> respDataList = new ResponseList<>();
        try {
            List<RequestCCModel> result = this.requestCCService.getRequestCCList(requestCCRequest);
            respDataList.setHeader(initHeaderSuccess(result));
            respDataList.setResponseList(result);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            respDataList.setHeader(initHeaderError(e));
        }
        return respDataList;
    }
}
