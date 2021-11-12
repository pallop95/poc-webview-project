package com.ktb.app.pms.requestservice.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ktb.app.pms.commonlibrary.config.repository.BaseRepository;
import com.ktb.app.pms.commonlibrary.model.lookup.LookupRequest;
import com.ktb.app.pms.commonlibrary.model.lookup.LookupResponse;
import com.ktb.app.pms.commonlibrary.util.StringUtil;

import lombok.extern.slf4j.Slf4j;

@Repository("LookupRepositoryImpl")
@Slf4j
public class LookupRepositoryImpl extends BaseRepository implements LookupRepository
{
	
	@Override public List<LookupResponse> getLookupList(LookupRequest lookupRequest) throws Exception
    {

        Map<String, Object> param = new HashMap<String, Object>();
        StringBuilder query = new StringBuilder();
        query.append("exec sp_ASM_ASSET_LOOKUP @LOOKUP_TYPE=:lookupType");
        param.put("lookupType", lookupRequest.getLookupType());

        log.info("Params : " + StringUtil.objectToJson(param));

        return getNamedJdbcTemplate().query(query.toString(), param, new RowMapper<LookupResponse>()
        {
            @Override public LookupResponse mapRow(ResultSet rs, int i) throws SQLException
            {
            	LookupResponse lookupResponse = new LookupResponse();

            	lookupResponse.setLookupType(rs.getString("LOOKUP_TYPE"));
            	lookupResponse.setLookupCode(rs.getString("LOOKUP_CODE"));
            	lookupResponse.setMeaning(rs.getString("MEANING"));
                lookupResponse.setDesc(rs.getString("DESCRIPTION"));
                lookupResponse.setOrder(rs.getString("ORDER"));

                return lookupResponse;
            }
        });
    }
}
