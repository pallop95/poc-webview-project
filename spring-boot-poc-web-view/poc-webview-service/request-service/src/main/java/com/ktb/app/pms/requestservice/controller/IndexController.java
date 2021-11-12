package com.ktb.app.pms.requestservice.controller;

import com.ktb.app.pms.commonlibrary.model.UploadModel;

import com.ws.hrms.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.ktb.app.pms.requestservice.config.SOAPConnector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;

import javax.xml.bind.JAXBElement;
import java.io.InputStream;
import java.lang.Exception;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.*;


@Slf4j
@RestController
public class IndexController {

    @Value("${app.ws.hrms.url}")
    private String ENDPOINT_HRMS;

    @Autowired
    SOAPConnector soapConnector;

    @PostMapping("/upload")
    public ResponseEntity<byte[]> index(@RequestBody UploadModel uploadModel){

        try{

            String filePath = "/data/image-path/sample11111.png";

            //upload file
            byte[] decodedImg = Base64.getDecoder().decode(uploadModel.getBase64Str().getBytes(StandardCharsets.UTF_8));
            Path destinationFile = Paths.get(filePath);
            Files.write(destinationFile, decodedImg);


            //download file
            InputStream inputStream = Files.newInputStream(destinationFile);
            byte[] bytes = StreamUtils.copyToByteArray(inputStream);
            MediaType mediaType = MediaType.IMAGE_PNG;

            return ResponseEntity
                    .ok()
                    .contentType(mediaType)
                    .body(bytes);


        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    private GetEmpAbsenceResponse getItems(SOAPConnector soapConnector, String refId) throws Exception {

        HeaderRq headerRq = new HeaderRq();
        headerRq.setSystemName("AMS");//Fix AMS
        headerRq.setChannelID("AMS");//Fix AMS
        headerRq.setCurrentDt("");//Format yyyyMMdd Ex. 20211005
        headerRq.setCurrentTime("");//Format HH:mm:ss Ex. 11:01:01
        headerRq.setRefID(refId);//Fix ""

        KtbEmpAbsRq ktbEmpAbsRq = new KtbEmpAbsRq();
        ktbEmpAbsRq.setSystemName("AMS");//Fix AMS
        ktbEmpAbsRq.setEmplid("");//Input value
        ktbEmpAbsRq.setDatereq("");//Format yyyyMMdd Ex. 20211005
        ktbEmpAbsRq.setHeaderRq(headerRq);

        GetEmpAbsence getEmpAbsence = new GetEmpAbsence();
        getEmpAbsence.setKtbEmpAbsRq1(ktbEmpAbsRq);

        GetEmpAbsenceResponse getEmpAbsenceResponse = (GetEmpAbsenceResponse) soapConnector.callWebService(ENDPOINT_HRMS, getEmpAbsence);

        return getEmpAbsenceResponse;
    }


    private GetEmployeeDetailResponse getItem2(SOAPConnector soapConnector, String emplid) throws Exception {


        KtbEmployeeWS ktbEmployeeWS = new KtbEmployeeWS();
        ktbEmployeeWS.setEmplid(emplid);
        ktbEmployeeWS.setSystemName("AMS");

        GetEmployeeDetail getEmployeeDetail = new GetEmployeeDetail();
        getEmployeeDetail.setKtbEmployeeWS1(ktbEmployeeWS);

        JAXBElement<GetEmployeeDetailResponse> response = (JAXBElement<GetEmployeeDetailResponse>) soapConnector.callWebService(ENDPOINT_HRMS, getEmployeeDetail);

        System.out.println("email"+response.getValue().getResult().getEmail());

//		System.out.println(">>>5555>>>>"+soapConnector.callWebService(ENDPOINT_HRMS, GetEmployeeDetail));

        return response.getValue();
    }

    @GetMapping("/{username}")
    public String index(@PathVariable(name = "username") String username) throws Exception {

        GetEmployeeDetailResponse getItemsResponse = new GetEmployeeDetailResponse();
        try {
            getItemsResponse = getItem2(soapConnector, "username");
        }catch (Exception e){
            log.error("Error", e);
        }

        return getItemsResponse.getResult().getEmail();
    }


//    @Value("${spring.application.name}")
//    String appName;

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

//    @GetMapping("/")
////    public String index(){
//    public Map<String, Object> index(){
//
////        System.out.println("Start>>>>>>>");
////        String sql = "SELECT * FROM vw_USER";
////        List<Object> objectList = jdbcTemplate.query(sql,
////                BeanPropertyRowMapper.newInstance(Object.class));
////
////        System.out.println(objectList.size());
//
//
////        SimpleJdbcCall jdbcCall =  new SimpleJdbcCall(jdbcTemplate).withProcedureName("spGetEmpDetails");
////        Map<String, Object> inParamMap = new HashMap<>();
////        inParamMap.put("EmpID", "108972");
////        inParamMap.put("EmpID", "CLO,REJ");
////        inParamMap.put("EmpID", 1);
////        inParamMap.put("EmpID", 20);
////        SqlParameterSource in = new MapSqlParameterSource(inParamMap);
////
////        Map<String, Object> simpleJdbcCallResult = jdbcCall.execute(in);
////
////        System.out.println(">>>"+simpleJdbcCallResult.toString());
//
//
//        List<SqlParameter> parameters = Arrays.asList(
//                new SqlParameter(Types.NVARCHAR)
//                , new SqlParameter(Types.NVARCHAR)
////                , new SqlParameter(Types.INTEGER)
////                , new SqlParameter(Types.INTEGER)
//        );
//
//
//        Map<String, Object> t = jdbcTemplate.call(new CallableStatementCreator() {
//            @Override
//            public CallableStatement createCallableStatement(Connection con) throws SQLException {
//                CallableStatement callableStatement = con.prepareCall(" {call sp_OPC_WORK_LIST_CC_PG (?,?,1,20)}");
//                callableStatement.setString(1, "108972");
//                callableStatement.setString(2, "CLO,REJ");
////                callableStatement.setInt(3, 1);
////                callableStatement.setInt(4, 20);
//                return callableStatement;
//            }
//        }, parameters);
//
//        for (Map.Entry<String, Object> entry : t.entrySet()) {
//            System.out.println(entry.getKey() + "/" + entry.getValue());
//        }
//
//        return t;
//    }

}
