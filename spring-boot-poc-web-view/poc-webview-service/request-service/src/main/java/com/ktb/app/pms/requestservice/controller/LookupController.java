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
import com.ktb.app.pms.commonlibrary.model.lookup.LookupRequest;
import com.ktb.app.pms.commonlibrary.model.lookup.LookupResponse;
import com.ktb.app.pms.requestservice.service.LookupService;

import lombok.extern.slf4j.Slf4j;

@RestController("LookupController")
@RequestMapping("/lookup")
@Slf4j
public class LookupController extends BaseController {
    @Autowired
    LookupService lookupService;
    
    @PostMapping("/list")
    public ResponseList<LookupResponse> getJudgeTypeConstList(
    		@RequestBody LookupRequest lookupRequest,
    		HttpServletResponse response) {
        ResponseList<LookupResponse> respDataList = new ResponseList<>();
        try {
            List<LookupResponse> result = this.lookupService.getLookupList(lookupRequest);
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
