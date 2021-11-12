package com.ktb.app.pms.requestservice.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.ktb.app.pms.commonlibrary.config.repository.BaseRepository;
import com.ktb.app.pms.commonlibrary.config.repository.ShareBaseRepository;
import com.ktb.app.pms.commonlibrary.model.requestCC.RequestCCModel;
import com.ktb.app.pms.commonlibrary.model.requestCC.RequestCCRequest;
import com.ktb.app.pms.commonlibrary.model.requestCC.RequestCCResponse;
import com.ktb.app.pms.commonlibrary.model.requestType.RequestTypeResponse;

import lombok.extern.slf4j.Slf4j;

@Repository("RequestCCRepositoryImpl")
@Slf4j
public class RequestCCRepositoryImpl extends BaseRepository implements RequestCCRepository
{

    @Override public List<RequestCCModel> getRequestCCList(RequestCCRequest requestCCRequest) throws Exception
    {

        Map<String, Object> param = new HashMap<String, Object>();
        StringBuilder query = new StringBuilder();
        query.append("exec sp_OPC_WORK_LIST_CC @COSTCENTER=:ccCode, @NOT_STATUS=:notStatus");
        param.put("ccCode", requestCCRequest.getCcCode());
        param.put("notStatus", requestCCRequest.getNotStatus());

        return getNamedJdbcTemplate().query(query.toString(), param, new RowMapper<RequestCCModel>()
        {
            @Override public RequestCCModel mapRow(ResultSet rs, int i) throws SQLException
            {
                RequestCCModel requestCCModel = new RequestCCModel();

                requestCCModel.setReqHeaderID(rs.getLong("REQ_HEADER_ID"));
                requestCCModel.setReqHeaderNum(rs.getString("REQ_HEADER_NUM"));
                requestCCModel.setReqDate(rs.getTimestamp("REQ_DATE"));
                requestCCModel.setReqDesc(rs.getString("REQ_DESC"));
                requestCCModel.setReqUserID(rs.getString("REQ_USER_ID"));
                requestCCModel.setReqUserName(rs.getString("REQ_USER_NAME"));
                requestCCModel.setReqResponseUser(rs.getLong("TO_USER_ID"));
                requestCCModel.setReqResponseName(rs.getString("TO_USER_NAME"));
                requestCCModel.setReqResponseTel(rs.getString("TO_USER_TEL"));
                requestCCModel.setReqCCProcess(rs.getString("CC_PROCESS"));
                requestCCModel.setReqStatus(rs.getString("STATUS_NAME"));

                return requestCCModel;
            }
        });
    }
}
