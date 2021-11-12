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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import com.ktb.app.pms.commonlibrary.config.repository.BaseRepository;
import com.ktb.app.pms.commonlibrary.config.repository.ShareBaseRepository;
import com.ktb.app.pms.commonlibrary.model.requestCC.RequestCCModel;
import com.ktb.app.pms.commonlibrary.model.requestDetail.RequestDetailFilesModel;
import com.ktb.app.pms.commonlibrary.model.requestDetail.RequestDetailHeadersModel;

import lombok.extern.slf4j.Slf4j;

@Repository("RequestDetailRepositoryImpl")
@Slf4j
public class RequestDetailRepositoryImpl extends BaseRepository implements RequestDetailRepository{

    @Value("${server.servlet.context-path}")
    private String CONTEXT_PATH;

    @Override
    public RequestDetailHeadersModel listRequestDetailHeader(String reqHeaderID) throws Exception
    {
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuilder query = new StringBuilder();
        query.append("exec sp_OPC_HEADER_WL @req_heade_id=:reqHeaderID ");
        param.put("reqHeaderID", reqHeaderID);

        return getNamedJdbcTemplate().query2Object(query.toString(), param, new RowMapper<RequestDetailHeadersModel>()
        {
            @Override
            public RequestDetailHeadersModel mapRow(ResultSet rs, int i) throws SQLException
            {
                RequestDetailHeadersModel requestDetailHeadersModel = new RequestDetailHeadersModel();

                requestDetailHeadersModel.setReqHeaderID(rs.getLong("REQ_HEADER_ID"));
                requestDetailHeadersModel.setReqHeaderNum(rs.getString("REQ_HEADER_NUM"));
                requestDetailHeadersModel.setReqDate(rs.getTimestamp("CREATE_DATE"));
                requestDetailHeadersModel.setReqDesc(rs.getString("REQ_REMARK"));
                requestDetailHeadersModel.setReqUserID(rs.getString("REQ_USER_ID"));
                requestDetailHeadersModel.setReqUserName(rs.getString("REQ_USER_NAME"));
                requestDetailHeadersModel.setReqUserTel(rs.getString("REQ_TEL"));
                requestDetailHeadersModel.setReqResponseUser(rs.getString("TO_USER_ID"));
                requestDetailHeadersModel.setReqResponseName(rs.getString("TO_USER_NAME"));
                requestDetailHeadersModel.setReqResponseTel(rs.getString("TO_USER_TELPHONE"));
                requestDetailHeadersModel.setReqCCProcess(rs.getString("CC_PROCESS"));
                requestDetailHeadersModel.setReqStatus(rs.getString("TO_STATUS_NAME"));
                requestDetailHeadersModel.setReqCC(rs.getString("REQ_COST_CENTER"));
                requestDetailHeadersModel.setReqCCName(rs.getString("REQ_CC_NAME"));
                requestDetailHeadersModel.setReqCCAddress(rs.getString("REQ_CC_ADDRESS"));
                requestDetailHeadersModel.setReqCCTel(rs.getString("REQ_CC_TELPHONE"));
                requestDetailHeadersModel.setReqType(rs.getString("REQ_TASK_TYPE_NAME"));

                return requestDetailHeadersModel;
            }
        });
    }

    @Override
    public List<RequestDetailFilesModel> listRequestDetailFile(String reqHeaderID,String reqHeaderNum) throws Exception
    {
        Map<String, Object> param = new HashMap<String, Object>();
        StringBuilder query = new StringBuilder();
        query.append("exec sp_OPC_REQUEST_FILE @req_heade_id=:reqHeaderID ");
        param.put("reqHeaderID", reqHeaderID);
        return getNamedJdbcTemplate().query(query.toString(), param, new RowMapper<RequestDetailFilesModel>()
        {
            @Override
            public RequestDetailFilesModel mapRow(ResultSet rs, int i) throws SQLException
            {
                RequestDetailFilesModel requestDetailFilesModel = new RequestDetailFilesModel();
                requestDetailFilesModel.setReqHeaderID(rs.getLong("REQ_HEADER_ID"));
                requestDetailFilesModel.setReqFileID(rs.getLong("FILE_ID"));
                requestDetailFilesModel.setReqFileName(rs.getString("FILE_NAME"));
                requestDetailFilesModel.setReqFileURL(rs.getString("FILE_URL"));
                requestDetailFilesModel.setFullUrl(CONTEXT_PATH+"/request/download/"+reqHeaderNum+"/"+rs.getString(
                    "FILE_NAME"));

                return requestDetailFilesModel;
            }
        });
    }

}
