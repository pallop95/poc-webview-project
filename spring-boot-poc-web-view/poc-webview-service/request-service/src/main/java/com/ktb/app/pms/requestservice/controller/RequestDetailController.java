package com.ktb.app.pms.requestservice.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ktb.app.pms.commonlibrary.controller.BaseController;
import com.ktb.app.pms.commonlibrary.model.base.ResponseVo;
import com.ktb.app.pms.requestservice.service.RequestDetailService;

import lombok.extern.slf4j.Slf4j;

@RestController("GetRequestDetailController")
@RequestMapping("/requestDetail")
@Slf4j
public class RequestDetailController extends BaseController
{
    @Autowired
    RequestDetailService requestDetailService;

    @GetMapping("/get/{reqHeaderId}")
    public ResponseVo<Map<String, Object>> getRequestDetail(@PathVariable String reqHeaderId,
        HttpServletResponse response) {
        ResponseVo<Map<String, Object>> respDataList = new ResponseVo<>();
        try {
            Map<String, Object> result = this.requestDetailService.getRequestDetail(reqHeaderId);
            respDataList.setHeader(initHeaderSuccess(result));
            respDataList.setResponse(result);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            respDataList.setHeader(initHeaderError(e));
        }
        return respDataList;
    }
}
