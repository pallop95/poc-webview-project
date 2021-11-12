package com.ktb.app.pms.requestservice.service;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktb.app.pms.commonlibrary.entity.request.AsmAppSetting;
import com.ktb.app.pms.commonlibrary.entity.request.AsmWfTaskHistory;
import com.ktb.app.pms.commonlibrary.entity.request.AsmWfTaskList;
import com.ktb.app.pms.commonlibrary.entity.request.OpcRequestFile;
import com.ktb.app.pms.commonlibrary.entity.request.OpcRequestHeader;
import com.ktb.app.pms.commonlibrary.entity.request.RequestHeader;
import com.ktb.app.pms.commonlibrary.entity.request.SpGetCurrWf;
import com.ktb.app.pms.commonlibrary.model.request.RequestFileModel;
import com.ktb.app.pms.commonlibrary.model.request.RequestHeaderModel;
import com.ktb.app.pms.commonlibrary.model.request.RequestModel;
import com.ktb.app.pms.commonlibrary.model.request.ResponseModel;
import com.ktb.app.pms.commonlibrary.util.DateUtil;
import com.ktb.app.pms.commonlibrary.util.Validate;
import com.ktb.app.pms.commonlibrary.util.service.constants.LookupConst;
import com.ktb.app.pms.requestservice.config.SOAPConnector;
import com.ktb.app.pms.requestservice.repository.RequestRepository;
import com.ws.hrms.GetEmpAbsence;
import com.ws.hrms.GetEmpAbsenceResponse;
import com.ws.hrms.HeaderRq;
import com.ws.hrms.KtbEmpAbsRq;
import java.nio.file.Files;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RequestServiceImpl implements RequestService{

	 @Value("${app.ws.hrms.url}")
    private String ENDPOINT_HRMS;

	 @Value("${app.nasPath}")
    private String NAS_PATH;

    @Autowired
    SOAPConnector soapConnector;

    @Autowired
    RequestRepository requestRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseModel createRequest(RequestModel request) throws Exception {
//    public ResponseModel createRequest(RequestHeaderModel requestHeader, List<RequestFileModel> RequestFileList) throws Exception {
        ResponseModel response = new ResponseModel();
        RequestHeaderModel requestHeader = request.getRequestHeader();
        
        List<RequestFileModel> requestFileList = request.getRequestFileList();

        String yearTH = DateUtil.getYearTH().substring(2,4);
        SpGetCurrWf spGetCurrWf = fnDealOutCards(requestHeader.getReqTaskType(), requestHeader.getBuidingID());
        String reqHeaderNum = getRunningNumber(yearTH, requestHeader.getReqCC());

//        if(requestHeader == null){
//        	throw new Exception("requestHeader no data!");
//        }

        OpcRequestHeader opcRequestHeader = setOpcRequestHeader(requestHeader, spGetCurrWf, reqHeaderNum);
        opcRequestHeader = requestRepository.insertRequest(opcRequestHeader);
//        TODO: use OpcRequestHeader to insert next...

//        TODO: 2 save file
        insertOpcRequestFile(requestFileList, opcRequestHeader);
        
//        log.info("spGetCurrWf : "+spGetCurrWf);
//        log.info("reqHeaderNum : "+reqHeaderNum);
        AsmWfTaskList asmWfTaskList = this.insertAsmWfTaskList(requestHeader,spGetCurrWf,reqHeaderNum);
        log.info("asmWfTaskList : "+asmWfTaskList);
        AsmWfTaskHistory asmWfTaskHistory = this.insertAsmWfTaskHistory(requestHeader,spGetCurrWf,reqHeaderNum);
        log.info("asmWfTaskHistory : "+ asmWfTaskHistory);

        response.setReqHeaderId(opcRequestHeader.getReqHeaderId());
        response.setReqHeaderNum(opcRequestHeader.getReqHeaderNum());
        return response;
    }

    private void insertOpcRequestFile(List<RequestFileModel> requestFileList, OpcRequestHeader opcRequestHeader) throws Exception
    {
    	String pathSeparator = File.separator;
    	String subPath = pathSeparator + "File" + pathSeparator + "Request_File";

//    	Map<String , MediaType> FILE_TYPE_MAP = LookupConst.FILE_TYPE_MAP;

//        AsmAppSetting NAS_PATH = this.requestRepository.findByAppKey("NAS_PATH");
//        log.info("NAS_PATH : "+NAS_PATH);
//        AsmAppSetting NAS_USER = this.requestRepository.findByAppKey("NAS_USER");
//        log.info("NAS_USER : "+NAS_USER);
//        AsmAppSetting NAS_PASSWORD = this.requestRepository.findByAppKey("NAS_PASSWORD");
//        log.info("NAS_PASSWORD : "+NAS_PASSWORD);

        if(!Validate.empty(requestFileList) && requestFileList.size() > 0){
        	String dirPath = this.NAS_PATH + subPath + pathSeparator + opcRequestHeader.getReqHeaderNum();

        	for(RequestFileModel requestFile : requestFileList) {
//        		TODO: refactoring code later
        		String type = requestFile.getFileName().split("\\.(?=[^\\.]+$)")[1];
        		requestFile.setType(type);
//            	method 2.1

//            	~/File/Request_File/46410845100001/464108451000011.jpg
        		String newFileName = opcRequestHeader.getReqHeaderNum() + requestFile.getFileNo() + "." + type;
        		requestFile.setFileName(newFileName);
            	String filePath = dirPath + pathSeparator + newFileName;

            	File dir = new File(dirPath);
            	dir.mkdirs();
            	
            	byte[] decodedFile = Base64.getDecoder().decode(requestFile.getBase64Str().getBytes(StandardCharsets.UTF_8));
                Path destinationFile = Paths.get(filePath);

                Files.write(destinationFile, decodedFile);
                
//                method 2.2 insert into OPC_REQUEST_FILE
                OpcRequestFile opcRequestFile = setOpcRequestFile(requestFile, opcRequestHeader);
                requestRepository.insertOpcRequestFile(opcRequestFile);
                
            }
        }
    }

    private OpcRequestFile setOpcRequestFile(RequestFileModel requestFile, OpcRequestHeader opcRequestHeader) throws Exception {
    	OpcRequestFile opcRequestFile = new OpcRequestFile();
    	opcRequestFile.setFileFlag("Y");
    	opcRequestFile.setFileNo(requestFile.getFileNo());
    	opcRequestFile.setFileName(requestFile.getFileName());

        
    	String fileUrl = "~/File/Request_File/" + opcRequestHeader.getReqHeaderNum() + "/" + requestFile.getFileName();
    	opcRequestFile.setFileUrl(fileUrl);
    	opcRequestFile.setReqHeaderId(opcRequestHeader.getReqHeaderId());
    	return opcRequestFile;
    }

    private AsmWfTaskList insertAsmWfTaskList(RequestHeaderModel requestHeaderModel
        , SpGetCurrWf spGetCurrWf, String reqHeaderNum) throws Exception
    {
        AsmWfTaskList asmWfTaskList = new AsmWfTaskList();
        asmWfTaskList.setJobId(reqHeaderNum + "000001");
        asmWfTaskList.setReqNum(reqHeaderNum);
        asmWfTaskList.setReqDate(DateUtil.getCurrent());
        asmWfTaskList.setSentDate(DateUtil.getCurrent());
        asmWfTaskList.setToUserId(Long.parseLong(requestHeaderModel.getReqUserID()));
        asmWfTaskList.setToUserName(requestHeaderModel.getReqUserName());
        asmWfTaskList.setFromCostCenterId(requestHeaderModel.getReqCC());
        asmWfTaskList.setFromCostCenterName(requestHeaderModel.getReqCCName());
        asmWfTaskList.setToUserId(Long.parseLong(spGetCurrWf.getUserId()));
        asmWfTaskList.setToUserName(spGetCurrWf.getUserName());
        asmWfTaskList.setToCostCenterId(spGetCurrWf.getUserCc());
        asmWfTaskList.setToCostCenterName(spGetCurrWf.getUserCcName());
        asmWfTaskList.setFromStatusCode(requestHeaderModel.getFromStatusCode());
        asmWfTaskList.setToStatusCode(requestHeaderModel.getToStatusCode());
        asmWfTaskList.setCreateDate(DateUtil.getCurrent());

        AsmWfTaskList result = this.requestRepository.insertAsmWfTaskList(asmWfTaskList);

        return result;
    }
    private AsmWfTaskHistory insertAsmWfTaskHistory(RequestHeaderModel requestHeaderModel
        ,SpGetCurrWf spGetCurrWf, String reqHeaderNum) throws Exception
    {
        AsmWfTaskHistory asmWfTaskHistory = new AsmWfTaskHistory();
        asmWfTaskHistory.setJobId(reqHeaderNum + "000001");
        asmWfTaskHistory.setReqNum(reqHeaderNum);
        asmWfTaskHistory.setReqDate(DateUtil.getCurrent());
        asmWfTaskHistory.setSentDate(DateUtil.getCurrent());
        asmWfTaskHistory.setToUserId(Long.parseLong(requestHeaderModel.getReqUserID()));
        asmWfTaskHistory.setToUserName(requestHeaderModel.getReqUserName());
        asmWfTaskHistory.setFromCostCenterId(requestHeaderModel.getReqCC());
        asmWfTaskHistory.setFromCostCenterName(requestHeaderModel.getReqCCName());
        asmWfTaskHistory.setToUserId(Long.parseLong(spGetCurrWf.getUserId()));
        asmWfTaskHistory.setToUserName(spGetCurrWf.getUserName());
        asmWfTaskHistory.setToCostCenterId(spGetCurrWf.getUserCc());
        asmWfTaskHistory.setToCostCenterName(spGetCurrWf.getUserCcName());
        asmWfTaskHistory.setFromStatusCode(requestHeaderModel.getFromStatusCode());
        asmWfTaskHistory.setToStatusCode(requestHeaderModel.getToStatusCode());
        asmWfTaskHistory.setCreateDate(DateUtil.getCurrent());

        AsmWfTaskHistory result = this.requestRepository.insertAsmWfTaskHistory(asmWfTaskHistory);

        return result;
    }

    private OpcRequestHeader setOpcRequestHeader(RequestHeader requestHeader, SpGetCurrWf spGetCurrWf, String reqHeaderNum) throws Exception {
    	OpcRequestHeader opcRequestHeader = new OpcRequestHeader();

    	opcRequestHeader.setReqUserId(requestHeader.getReqUserID());
    	opcRequestHeader.setReqCostCenter(requestHeader.getReqCC());
    	opcRequestHeader.setReqTel(requestHeader.getReqTel());
    	opcRequestHeader.setReqRemark(requestHeader.getReqRemark());
    	opcRequestHeader.setCreateDate(DateUtil.getCurrent());
    	opcRequestHeader.setCreateBy(requestHeader.getReqUserID());
    	opcRequestHeader.setJobId(reqHeaderNum + "000001");
    	opcRequestHeader.setReqCcName(requestHeader.getReqCCName());
    	opcRequestHeader.setReqUserName(requestHeader.getReqUserName());
    	opcRequestHeader.setReqTaskType(requestHeader.getReqTaskType());
    	opcRequestHeader.setReqUserEmail(requestHeader.getReqUserEmail());
    	opcRequestHeader.setReqType(requestHeader.getReqType());
    	opcRequestHeader.setCcProcess(requestHeader.getReqCCProcess());
    	opcRequestHeader.setHqProcess(requestHeader.getHqProcess());
    	opcRequestHeader.setBuildingId(requestHeader.getBuidingID());
    	opcRequestHeader.setCostCenterClose(requestHeader.getCcClose());
    	opcRequestHeader.setCostCenterMain(requestHeader.getCcMain());
    	opcRequestHeader.setReqHeaderNum(reqHeaderNum);
    	opcRequestHeader.setWfSeq(spGetCurrWf.getWfSeq());

    	return opcRequestHeader;
    }
    
    private SpGetCurrWf fnDealOutCards(String reqTaskType, String buidingID) throws Exception {

    	SpGetCurrWf spGetCurrWf = new SpGetCurrWf();
    	List<SpGetCurrWf> spGetCurrWfList = requestRepository.listSpGetCurrWf(reqTaskType, buidingID);
    	
    	if(Validate.empty(spGetCurrWfList)) {
    		throw new Exception("SpGetCurrWf not found.");
    	} else {
    		boolean check = false;
    		for(SpGetCurrWf spGetCurrWfTemp : spGetCurrWfList) {
    			check = fnCheckUserLeave(spGetCurrWfTemp.getUserId());
    			if (check) {
                    return spGetCurrWfTemp;
    			}
    		}
    		if (!check) {
    			return spGetCurrWfList.get(0);
    		}
    	}
    	return spGetCurrWf;
    }
    
    private String getRunningNumber(String sYear, String sCostCenter) throws Exception {
    	String runningNumber = requestRepository.getRunningNumber(sYear, sCostCenter);
    	log.info("runningNumber : "+runningNumber);
    	Long nextRunningNumber = 0L;
    	if (!Validate.empty(runningNumber)) {
    		nextRunningNumber = Long.parseLong(runningNumber) + 1;
    	} else {
    		throw new Exception("RunningNumber not found.");
    	}
    	return Long.toString(nextRunningNumber);
    }
    
    private boolean fnCheckUserLeave(String userId) throws Exception {
    	boolean isEmpAbsence = false;

    	GetEmpAbsenceResponse getEmpAbsenceResponse = getEmpAbsence(soapConnector, userId);
    	if (!Validate.empty(getEmpAbsenceResponse.getResult())) {
    		if (getEmpAbsenceResponse.getResult().getResponseCode().equals("1001")) {  //แสดงว่าไม่ลา
//    			TODO: select ...
    		} else if (getEmpAbsenceResponse.getResult().getResponseDescr().equals("SUCCESS")) {
    			isEmpAbsence = false;
    		} else {
    			isEmpAbsence = false;
    		}
    	}
    	return isEmpAbsence;
    }
    
    private GetEmpAbsenceResponse getEmpAbsence(SOAPConnector soapConnector, String userId) throws Exception {
	    String systemname = "AMS";//"AMS";
        String channelid = "AMS"; //"AMS";

        Timestamp ts = DateUtil.getCurrent();
        String currdate = DateUtil.covertTimestampToUSYYYYMMDD(ts);
        String currtime = DateUtil.covertTimestampToUSHHMMSS(ts);

        HeaderRq headerRq = new HeaderRq();
        headerRq.setSystemName(systemname);//Fix AMS
        headerRq.setChannelID(channelid );//Fix AMS

        
        headerRq.setCurrentDt(currdate);//Format yyyyMMdd Ex. 20211005
        headerRq.setCurrentTime(currtime);//Format HH:mm:ss Ex. 11:01:01
        headerRq.setRefID("");//Fix ""

        KtbEmpAbsRq ktbEmpAbsRq = new KtbEmpAbsRq();
        ktbEmpAbsRq.setSystemName(systemname);//Fix AMS
        ktbEmpAbsRq.setEmplid(userId);//Input value
        ktbEmpAbsRq.setDatereq(currdate);//Format yyyyMMdd Ex. 20211005
        ktbEmpAbsRq.setHeaderRq(headerRq);

        GetEmpAbsence getEmpAbsence = new GetEmpAbsence();
        getEmpAbsence.setKtbEmpAbsRq1(ktbEmpAbsRq);

        GetEmpAbsenceResponse getEmpAbsenceResponse = new GetEmpAbsenceResponse();
        
        try {
        	getEmpAbsenceResponse = (GetEmpAbsenceResponse) soapConnector.callWebService(ENDPOINT_HRMS, getEmpAbsence);
        }catch (Exception e){
//            log.error("Error", e);
        	log.error("============ Error getEmpAbsenceResponse: Open real LOG commend later !!!!!! ======================");
        }

        return getEmpAbsenceResponse;
    }

}
