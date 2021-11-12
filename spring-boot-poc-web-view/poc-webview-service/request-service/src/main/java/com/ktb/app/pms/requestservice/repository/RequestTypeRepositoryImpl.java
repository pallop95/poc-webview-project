package com.ktb.app.pms.requestservice.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ktb.app.pms.commonlibrary.config.repository.BaseRepository;
import com.ktb.app.pms.commonlibrary.model.requestType.RequestTypeRequest;
import com.ktb.app.pms.commonlibrary.model.requestType.RequestTypeResponse;
import com.ktb.app.pms.commonlibrary.model.requestType.UpdateRequest;
import com.ktb.app.pms.commonlibrary.util.StringUtil;

import lombok.extern.slf4j.Slf4j;

@Repository("RequestTypeRepositoryImpl")
@Slf4j
public class RequestTypeRepositoryImpl extends BaseRepository implements RequestTypeRepository
{

    /* @Override
    public List<RequestTypeResponse> getRequestTypeList(RequestTypeRequest requestTypeRequest) throws Exception {	
    	List<SqlParameter> parameters = Arrays.asList(
                new SqlParameter(Types.NVARCHAR),
                new SqlParameter(Types.NVARCHAR)
        );

    	List<RequestTypeResponse> requestTypeResponseList = new ArrayList<RequestTypeResponse>();

        Map<String, Object> mapResult = jdbcTemplate.call(new CallableStatementCreator() {
            @Override
            public CallableStatement createCallableStatement(Connection con) throws SQLException {
                CallableStatement callableStatement = con.prepareCall(" {call sp_OPC_REQUEST_TYPE (?,?)}");
                callableStatement.setString(1, requestTypeRequest.getHqProcess());
                callableStatement.setString(2, requestTypeRequest.getFixSpecialCC());
                return callableStatement;
            }
        }, parameters);

        RequestTypeResponse requestTypeResponse = new RequestTypeResponse();
        requestTypeResponseList = (List<RequestTypeResponse>) (Object) procedureMapToList(mapResult, requestTypeResponse);

        return requestTypeResponseList;

    } */
	
	@Override public List<RequestTypeResponse> getRequestTypeList(RequestTypeRequest requestTypeRequest) throws Exception
    {
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuilder query = new StringBuilder();
        query.append("exec sp_OPC_REQUEST_TYPE @HQ_PROCESS=:hqProcess, @FIX_SPECIAL_CC=:fixSpecialCC");
        param.put("hqProcess", requestTypeRequest.getHqProcess());
        param.put("fixSpecialCC", requestTypeRequest.getFixSpecialCC());

        log.info("Params : " + StringUtil.objectToJson(param));

        return getNamedJdbcTemplate().query(query.toString(), param, new RowMapper<RequestTypeResponse>()
        {
            @Override public RequestTypeResponse mapRow(ResultSet rs, int i) throws SQLException
            {
            	RequestTypeResponse requestTypeResponse = new RequestTypeResponse();

            	requestTypeResponse.setTypeId(rs.getLong("TYPE_ID"));
            	requestTypeResponse.setTypeCode(rs.getString("TYPE_CODE"));
            	requestTypeResponse.setTypeName(rs.getString("TYPE_NAME"));
            	requestTypeResponse.setSlaDay(rs.getLong("SLA_DAY"));
            	requestTypeResponse.setUseFrom(rs.getString("USE_FROM"));

                return requestTypeResponse;
            }
        });
    }

	@Override
	public Integer updateRequest(UpdateRequest updateRequest) throws Exception {

		Map<String, Object> params = new HashMap<String, Object>();

        StringBuilder query = new StringBuilder();
        query.append("exec sp_UPDATE_REQUEST "
        		+ "@action=:action, @req_header_id=:reqHeaderId, "
        		+ "@job_id=:jobId, @from_status_code=:fromStatusCode, "
        		+ "@to_status_code=:toStatusCode, @remark=:remark, "
        		+ "@from_user_id=:fromUserId");

        params.put("action", updateRequest.getAction());
        params.put("reqHeaderId", updateRequest.getReqHeaderId());
        params.put("jobId", updateRequest.getJobId());
        params.put("fromStatusCode", updateRequest.getFromStatusCode());
        params.put("toStatusCode", updateRequest.getToStatusCode());
        params.put("remark", updateRequest.getRemark());
        params.put("fromUserId", updateRequest.getFromUserId());

        log.info("Params : " + StringUtil.objectToJson(params));

        Integer result = getNamedJdbcTemplate().update(query.toString(), params);

//        if (result > 0 && pojoOldData != null) {
//            //TODO save history pojoExec and pojoOldData
//        }

        return result;
	}

}
