package com.ktb.app.pms.requestservice.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ktb.app.pms.commonlibrary.config.repository.BaseRepository;
import com.ktb.app.pms.commonlibrary.entity.request.AsmAppSetting;
import com.ktb.app.pms.commonlibrary.entity.request.AsmWfTaskHistory;
import com.ktb.app.pms.commonlibrary.entity.request.AsmWfTaskList;
import com.ktb.app.pms.commonlibrary.entity.request.OpcRequestFile;
import com.ktb.app.pms.commonlibrary.entity.request.OpcRequestHeader;
import com.ktb.app.pms.commonlibrary.entity.request.SpGetCurrWf;
import com.ktb.app.pms.commonlibrary.util.Validate;

@Repository
public class RequestRepositoryImpl extends BaseRepository implements RequestRepository {

	
	
    @Override
    public AsmWfTaskList insertAsmWfTaskList(AsmWfTaskList asmWfTaskList) throws Exception
    {
        StringBuilder sql = new StringBuilder();
        
        sql.append(" INSERT INTO ").append(" ASM_WF_TASK_LIST ");
        sql.append(" ( JOB_ID, REQ_NUM, REQ_DATE, SENT_DATE, FROM_USER_ID ");
        sql.append(" , FROM_USER_NAME, FROM_COST_CENTER_ID, FROM_COST_CENTER_NAME ");
        sql.append(" , TO_USER_ID, TO_USER_NAME, TO_COST_CENTER_ID, TO_COST_CENTER_NAME ");
        sql.append(" , FROM_STATUS_CODE, TO_STATUS_CODE, CREATE_DATE ) ");
        sql.append(" VALUES(:JOB_ID, :REQ_NUM, :REQ_DATE, :SENT_DATE, :FROM_USER_ID ");
        sql.append(" , :FROM_USER_NAME, :FROM_COST_CENTER_ID , :FROM_COST_CENTER_NAME ");
        sql.append(" , :TO_USER_ID, :TO_USER_NAME, :TO_COST_CENTER_ID, :TO_COST_CENTER_NAME ");
        sql.append(" , :FROM_STATUS_CODE, :TO_STATUS_CODE, :CREATE_DATE ");
        sql.append(" )");

        Map<String,Object> param = new HashMap<>();
        param.put("JOB_ID",asmWfTaskList.getJobId());
        param.put("REQ_NUM", asmWfTaskList.getReqNum());
        param.put("REQ_DATE", asmWfTaskList.getReqDate());
        param.put("SENT_DATE", asmWfTaskList.getSentDate());
        param.put("FROM_USER_ID", asmWfTaskList.getFromUserId());
        param.put("FROM_USER_NAME", asmWfTaskList.getFromUserName());
        param.put("FROM_COST_CENTER_ID", asmWfTaskList.getFromCostCenterId());
        param.put("FROM_COST_CENTER_NAME", asmWfTaskList.getFromCostCenterName());
        param.put("TO_USER_ID", asmWfTaskList.getToUserId());
        param.put("TO_USER_NAME", asmWfTaskList.getToUserName());
        param.put("TO_COST_CENTER_ID", asmWfTaskList.getToCostCenterId());
        param.put("TO_COST_CENTER_NAME", asmWfTaskList.getToCostCenterName());
        param.put("FROM_STATUS_CODE", asmWfTaskList.getFromStatusCode());
        param.put("TO_STATUS_CODE", asmWfTaskList.getToStatusCode());
        param.put("CREATE_DATE", asmWfTaskList.getCreateDate());

        int result = getNamedJdbcTemplate().update(sql.toString(), param);

        return result > 0 ? asmWfTaskList : null;
    }

    @Override
    public OpcRequestFile insertOpcRequestFile(OpcRequestFile opcRequestFile) throws Exception
    {
//    	opcRequestFile.setFileId(getNextSeq("FILE_ID", "OPC_REQUEST_FILE"));
        StringBuilder sql = new StringBuilder();
        
        sql.append(" INSERT INTO ").append(" OPC_REQUEST_FILE ");
        sql.append(" ( REQ_HEADER_ID, FILE_NO ");
        sql.append(" , FILE_NAME, FILE_URL, FILE_FLAG ) ");
        sql.append(" VALUES(:REQ_HEADER_ID, :FILE_NO ");
        sql.append(" , :FILE_NAME, :FILE_URL, :FILE_FLAG ");
        sql.append(" )");

        Map<String,Object> param = new HashMap<>();
//        param.put("FILE_ID",opcRequestFile.getFileId());
        param.put("REQ_HEADER_ID", opcRequestFile.getReqHeaderId());
        param.put("FILE_NO", opcRequestFile.getFileNo());
        param.put("FILE_NAME", opcRequestFile.getFileName());
        param.put("FILE_URL", opcRequestFile.getFileUrl());
        param.put("FILE_FLAG", opcRequestFile.getFileFlag());

        int result = getNamedJdbcTemplate().update(sql.toString(), param);

        return result > 0 ? opcRequestFile : null;
    }

    @Override
    public AsmWfTaskHistory insertAsmWfTaskHistory(AsmWfTaskHistory asmWfTaskHistory) throws Exception
    {
        StringBuilder sql = new StringBuilder();

        sql.append(" INSERT INTO ").append(" ASM_WF_TASK_HISTORY ");
        sql.append(" ( JOB_ID, REQ_NUM, REQ_DATE, SENT_DATE, FROM_USER_ID ");
        sql.append(" , FROM_USER_NAME, FROM_COST_CENTER_ID, FROM_COST_CENTER_NAME ");
        sql.append(" , TO_USER_ID, TO_USER_NAME, TO_COST_CENTER_ID, TO_COST_CENTER_NAME ");
        sql.append(" , FROM_STATUS_CODE, TO_STATUS_CODE, CREATE_DATE ) ");
        sql.append(" VALUES(:JOB_ID, :REQ_NUM, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, :FROM_USER_ID ");
        sql.append(" , :FROM_USER_NAME, :FROM_COST_CENTER_ID , :FROM_COST_CENTER_NAME ");
        sql.append(" , :TO_USER_ID, :TO_USER_NAME, :TO_COST_CENTER_ID, :TO_COST_CENTER_NAME ");
        sql.append(" , :FROM_STATUS_CODE, :TO_STATUS_CODE, CURRENT_TIMESTAMP ");
        sql.append(" )");

        Map<String,Object> param = new HashMap<>();
        param.put("JOB_ID",asmWfTaskHistory.getJobId());
        param.put("REQ_NUM", asmWfTaskHistory.getReqNum());
        param.put("REQ_DATE", asmWfTaskHistory.getReqDate());
        param.put("SENT_DATE", asmWfTaskHistory.getSentDate());
        param.put("FROM_USER_ID", asmWfTaskHistory.getFromUserId());
        param.put("FROM_USER_NAME", asmWfTaskHistory.getFromUserName());
        param.put("FROM_COST_CENTER_ID", asmWfTaskHistory.getFromCostCenterId());
        param.put("FROM_COST_CENTER_NAME", asmWfTaskHistory.getFromCostCenterName());
        param.put("TO_USER_ID", asmWfTaskHistory.getToUserId());
        param.put("TO_USER_NAME", asmWfTaskHistory.getToUserName());
        param.put("TO_COST_CENTER_ID", asmWfTaskHistory.getToCostCenterId());
        param.put("TO_COST_CENTER_NAME", asmWfTaskHistory.getToCostCenterName());
        param.put("FROM_STATUS_CODE", asmWfTaskHistory.getFromStatusCode());
        param.put("TO_STATUS_CODE", asmWfTaskHistory.getToStatusCode());
        param.put("CREATE_DATE", asmWfTaskHistory.getCreateDate());

        int result = getNamedJdbcTemplate().update(sql.toString(), param);

        return result > 0 ? asmWfTaskHistory : null;
    }

    @Override
    public AsmAppSetting findByAppKey(String appKey) throws Exception
    {
        StringBuilder query = new StringBuilder();
//        \\kcsnanasapp46.kcs\NPROP
        query.append(" select * from ").append(" ASM_APPSETTING ");
        query.append(" WHERE APP_KEY = :appKey ");

        Map<String,Object> param = new HashMap<>();
        param.put("appKey", appKey);

        return getNamedJdbcTemplate().query2Object(query.toString(),param, new BeanPropertyRowMapper<>(AsmAppSetting.class));
    }

    @Override
	public OpcRequestHeader insertRequest(OpcRequestHeader opcRequestHeader) throws Exception {

    	opcRequestHeader.setReqHeaderId(getNextSeq("REQ_HEADER_ID", "OPC_REQUEST_HEADER"));

    	StringBuilder sql = new StringBuilder();

        sql.append(" INSERT INTO ").append(" OPC_REQUEST_HEADER ");
        sql.append(" ( REQ_HEADER_ID, REQ_USER_ID, REQ_COST_CENTER, REQ_TEL, REQ_REMARK, CREATE_DATE ");
        sql.append(" , CREATE_BY, JOB_ID, REQ_CC_NAME ");
        sql.append(" , REQ_USER_NAME, REQ_TASK_TYPE, REQ_USER_EMAIL ");
        sql.append(" , REQ_TYPE, CC_PROCESS, HQ_PROCESS ");
        sql.append(" , BUILDING_ID, COST_CENTER_CLOSE, COST_CENTER_MAIN ");
        sql.append(" , REQ_HEADER_NUM, WF_SEQ ) ");
        sql.append(" VALUES(:REQ_HEADER_ID, :REQ_USER_ID, :REQ_COST_CENTER, :REQ_TEL, :REQ_REMARK, :CREATE_DATE ");
        sql.append(" , :CREATE_BY, :JOB_ID , :REQ_CC_NAME ");
        sql.append(" , :REQ_USER_NAME, :REQ_TASK_TYPE, :REQ_USER_EMAIL ");
        sql.append(" , :REQ_TYPE, :CC_PROCESS, :HQ_PROCESS ");
        sql.append(" , :BUILDING_ID, :COST_CENTER_CLOSE, :COST_CENTER_MAIN ");
        sql.append(" , :REQ_HEADER_NUM, :WF_SEQ ");
        sql.append(" )");

        Map<String,Object> param = this.setParamInsertRequest(opcRequestHeader);

        int result = getNamedJdbcTemplate().update(sql.toString(), param);

        return opcRequestHeader;
	}

    private Map<String,Object> setParamInsertRequest(OpcRequestHeader opcRequestHeader) {

        Map<String,Object> param = new HashMap<>();

        param.put("REQ_HEADER_ID", opcRequestHeader.getReqHeaderId());
        param.put("REQ_USER_ID", opcRequestHeader.getReqUserId());
        param.put("REQ_COST_CENTER", opcRequestHeader.getReqCostCenter());
        param.put("REQ_TEL", opcRequestHeader.getReqTel());
        param.put("REQ_REMARK", opcRequestHeader.getReqRemark());
        param.put("CREATE_DATE", opcRequestHeader.getCreateDate());
        param.put("CREATE_BY", opcRequestHeader.getCreateBy());
        param.put("JOB_ID", opcRequestHeader.getJobId());
        param.put("REQ_CC_NAME", opcRequestHeader.getReqCcName());
        param.put("REQ_USER_NAME", opcRequestHeader.getReqUserName());
        param.put("REQ_TASK_TYPE", opcRequestHeader.getReqTaskType());
        param.put("REQ_USER_EMAIL", opcRequestHeader.getReqUserEmail());
        param.put("REQ_TYPE", opcRequestHeader.getReqType());
        param.put("CC_PROCESS", opcRequestHeader.getCcProcess());
        param.put("HQ_PROCESS", opcRequestHeader.getHqProcess());
        param.put("BUILDING_ID", opcRequestHeader.getBuildingId());
        param.put("COST_CENTER_CLOSE", opcRequestHeader.getCostCenterClose());
        param.put("COST_CENTER_MAIN", opcRequestHeader.getCostCenterMain());
        param.put("REQ_HEADER_NUM", opcRequestHeader.getReqHeaderNum());
        param.put("WF_SEQ", opcRequestHeader.getWfSeq());

        return param;
    }

    @Override
    public List<SpGetCurrWf> listSpGetCurrWf(String reqTaskType, String buidingID) throws Exception
    {
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuilder query = new StringBuilder();
//        exec sp_GET_CURR_WF '4','','1'
        query.append("exec sp_GET_CURR_WF @type_id=:reqTaskType, "
        		+ "@response_group_cc=:responseGroupCc, @build_id=:buidingID");
        param.put("reqTaskType", reqTaskType);
        param.put("responseGroupCc", "");
        param.put("buidingID", buidingID);

        return getNamedJdbcTemplate().query(query.toString(), param, new RowMapper<SpGetCurrWf>()
        {
            @Override
            public SpGetCurrWf mapRow(ResultSet rs, int i) throws SQLException
            {
            	SpGetCurrWf spGetCurrWf = new SpGetCurrWf();

            	spGetCurrWf.setRowNum(rs.getLong("ROW_NUM"));
            	spGetCurrWf.setWfId(rs.getString("WF_ID"));
            	spGetCurrWf.setWfSeq(rs.getLong("WF_SEQ"));
            	spGetCurrWf.setUserId(rs.getString("USER_ID"));
            	spGetCurrWf.setUserName(rs.getString("USER_NAME"));
            	spGetCurrWf.setUserCc(rs.getString("USER_CC"));
            	spGetCurrWf.setUserCcName(rs.getString("USER_CC_NAME"));
            	spGetCurrWf.setUserEmail(rs.getString("USER_EMAIL"));
            	spGetCurrWf.setTelphone(rs.getString("TELPHONE"));

                return spGetCurrWf;
            }
        });
    }

	@Override
	public String getRunningNumber(String sYear, String sCostCenter) throws Exception {
		 Map<String, Object> params = new HashMap<String, Object>();
        StringBuilder query = new StringBuilder();

//        WHERE substring(REQ_HEADER_NUM,2,2) = '64'and substring(REQ_HEADER_NUM,4,6) = '108388'
//        query.append("SELECT max(substring(REQ_HEADER_NUM,10,5)) "
        query.append("SELECT max(REQ_HEADER_NUM) "
        		+ "as Running_Number FROM OPC_REQUEST_HEADER\r\n" +
        		"WHERE substring(REQ_HEADER_NUM,2,2) = :sYear and substring(REQ_HEADER_NUM,4,6) = :sCostCenter");
        params.put("sYear", sYear);
        params.put("sCostCenter", sCostCenter);
	        
        List<String> runningNumbers = getNamedJdbcTemplate().query(query.toString(), params, new RowMapper<String>()
        {
            @Override
            public String mapRow(ResultSet rs, int i) throws SQLException
            {
            	return rs.getString("RUNNING_NUMBER");
            }
        });
        if (Validate.empty(runningNumbers)) {
        	throw new Exception("RunningNumber not found!");
        }
        
        return runningNumbers.get(0);
	}
}
