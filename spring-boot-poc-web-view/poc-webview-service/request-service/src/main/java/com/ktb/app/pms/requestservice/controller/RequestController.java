package com.ktb.app.pms.requestservice.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktb.app.pms.commonlibrary.controller.BaseController;
import com.ktb.app.pms.commonlibrary.model.base.ResponseVo;
import com.ktb.app.pms.commonlibrary.model.request.RequestModel;
import com.ktb.app.pms.commonlibrary.model.request.ResponseModel;
import com.ktb.app.pms.requestservice.service.RequestService;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@RestController("CreateRequestController")
@RequestMapping("/request")
@Slf4j
public class RequestController extends BaseController{

    @Autowired
    RequestService requestService;

    @Value("${app.nasPath}")
    private String NAS_PATH;

    @Autowired
    ResourceLoader resourceLoader;
    @PostMapping("/create")
    public ResponseVo<ResponseModel> save(@RequestBody RequestModel requestModel, HttpServletResponse response)  throws Exception {
        ResponseVo<ResponseModel> responseVo = new ResponseVo<>();
        try {
            ResponseModel result = this.requestService.createRequest(requestModel);
//        	ResponseModel result = this.requestService.createRequest(requestModel.getRequestHeader(), requestModel.getRequestFileList());
            responseVo.setHeader(initHeaderSuccess(result));
            responseVo.setResponse(result);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            responseVo.setHeader(initHeaderError(e));
        }

        return responseVo;
    }
    @GetMapping("/download/{reqHeaderNum}/{filename}")
    public ResponseEntity<byte[]> download(@PathVariable String reqHeaderNum, @PathVariable String filename) {
        try
        {

            String type = filename.split("\\.(?=[^\\.]+$)")[1];
            //System.out.print("type :"+type[1]);
            String pathSeparator = File.separator;
            String subPath = pathSeparator + "File" + pathSeparator + "Request_File";
            String path = "file:" + this.NAS_PATH + pathSeparator + subPath + pathSeparator + reqHeaderNum + pathSeparator + filename;
            Resource resource = resourceLoader.getResource(path);
            InputStream inputStream = resource.getInputStream();
            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
//           String data = new String(bdata, StandardCharsets.UTF_8);
//           LOGGER.info(data);
            Map<String , MediaType> SEND_TYPE_MAP = new HashMap<String , MediaType>() {{
                put("png", MediaType.IMAGE_PNG);
                put("jpeg", MediaType.IMAGE_JPEG);
                put("jpg", MediaType.IMAGE_JPEG);
                put("gif", MediaType.IMAGE_GIF);
                put("pdf", MediaType.APPLICATION_PDF);
                put("doc",MediaType.valueOf("application/msword"));
                put("docx",MediaType.valueOf("application/vnd.openxmlformats-officedocument.wordprocessingml.document"));
                put("xls",MediaType.valueOf("application/vnd.ms-excel"));
                put("xlsx",MediaType.valueOf("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
                put("ppt",MediaType.valueOf("application/vnd.ms-powerpoint"));
                put("pptx",MediaType.valueOf("application/vnd.openxmlformats-officedocument.presentationml.presentation"));
            }};

            return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + filename)
                .contentType(SEND_TYPE_MAP.get(type))
                .body(bdata);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
