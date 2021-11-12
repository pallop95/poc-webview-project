package com.ktb.app.pms.authservice.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ktb.app.pms.authservice.domain.UserAccess;
import com.ktb.app.pms.commonlibrary.config.repository.BaseRepository;
import com.ktb.app.pms.commonlibrary.entity.Users;
import com.ktb.app.pms.commonlibrary.entity.request.AsmAppSetting;
import com.ktb.app.pms.commonlibrary.model.requestDetail.RequestDetailHeadersModel;
import com.ktb.app.pms.commonlibrary.model.user.UserDetailRequest;
import com.ktb.app.pms.commonlibrary.model.user.UserDetailResponse;
import com.ktb.app.pms.commonlibrary.util.Validate;

@Repository
public class UserRepositoryImpl extends BaseRepository implements UserRepository {
    @Override
    public UserAccess getUserAccessByUserName(String username) {
        UserAccess userAccess = new UserAccess();
        userAccess.setUsername(username);
        userAccess.setPassword("");
        userAccess.setRole("ROLE_ADMIN");
        return userAccess;
    }

//	@Override
//	public UserDetailResponse getUserDetail(UserDetailRequest userDetailRequest) throws Exception {
//
//		Map<String, Object> param = new HashMap<String, Object>();
//        StringBuilder query = new StringBuilder();
////        exec sp_GET_CURR_WF '4','','1'
////        query.append("exec sp_ASM_UP_USER @username=:username");
//        
////        select top(1)* from vw_USER WHERE USERNAME =username AND GROUP_ID is null
////        param.put("username", userDetailRequest.getUsername());
//
//        List<UserDetailResponse> userDetailResponseList = getNamedJdbcTemplate().query(query.toString(), param, new RowMapper<UserDetailResponse>()
//        {
//            @Override
//            public UserDetailResponse mapRow(ResultSet rs, int i) throws SQLException
//            {
//            	UserDetailResponse userDetailResponse = new UserDetailResponse();
//
//            	userDetailResponse.setUsername(rs.getString("USERNAME"));
//            	userDetailResponse.setFullname(rs.getString("FULNAME"));
//            	userDetailResponse.setCcCode(rs.getString("CC_CODE"));
//            	userDetailResponse.setCcName(rs.getString("CC_NAME"));
//            	userDetailResponse.setCcAddress(rs.getString("CC_ADDRESS"));
//            	userDetailResponse.setCcTelphone(rs.getString("CC_TELPHONE"));
//            	userDetailResponse.setEmail(rs.getString("EMAIL"));
//
//                return userDetailResponse;
//            }
//        });
// 
//        if(Validate.empty(userDetailResponseList)) {
//        	throw new Exception("User not found!");
//        }
//        return userDetailResponseList.get(0);
//        
//	}
    
    @Override
    public UserDetailResponse getUserDetail(UserDetailRequest userDetailRequest) throws Exception
    {
        StringBuilder query = new StringBuilder();
        
        query.append("SELECT TOP(1)* FROM VW_USER VU ");
        query.append("LEFT JOIN ASM_BRANCH AB ON VU.COST_CENTER_CODE = AB.COST_CENTER ");
        query.append("WHERE VU.USERNAME = :username AND VU.GROUP_ID IS NULL");

        Map<String,Object> param = new HashMap<>();
        param.put("username", userDetailRequest.getUsername());

        return getNamedJdbcTemplate().query2Object(query.toString(),param, new BeanPropertyRowMapper<>(UserDetailResponse.class));
    }

	@Override
	public Users getUserByEmail(String email) throws Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
        StringBuilder query = new StringBuilder();
        
        query.append(" select top(1)* from vw_USER WHERE EMAIL= :email AND GROUP_ID is null ");
        param.put("email", email);
        
        return getNamedJdbcTemplate().query2Object(query.toString(), param, new RowMapper<Users>()
        {

			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				Users users = new Users();
				users.setUsername(rs.getString("USERNAME"));
				users.setFullname(rs.getString("FULL_NAME"));
				users.setCcCode(rs.getString("COST_CENTER_CODE"));
				users.setCcName(rs.getString("COST_CENTER_NAME"));
				users.setRoleId(rs.getString("ROLE_ID"));
				
				return users;
			}
        	
        });
	}

	@Override
	public Users insertUser(Users users) throws Exception {
		
		StringBuilder sql = new StringBuilder();
        
        sql.append(" INSERT INTO ").append(" amsdba.[USER] ");
        sql.append(" ( USERNAME, FULL_NAME, ROLE_ID, ENABLE_FLAG, EMAIL ");
        sql.append(" , POSITION, COST_CENTER_CODE , COST_CENTER_NAME, GROUP_ID, SYSTEM_CODE ) ");
        sql.append(" VALUES( :USERNAME, :FULL_NAME, :ROLE_ID, :ENABLE_FLAG, :EMAIL ");
        sql.append(" , :POSITION, :COST_CENTER_CODE, :COST_CENTER_NAME, :GROUP_ID, :SYSTEM_CODE ");
        sql.append(" )");

        Map<String,Object> param = new HashMap<>();
        param.put("USERNAME", users.getUsername());
        param.put("FULL_NAME", users.getFullname());
        param.put("ROLE_ID", users.getRoleId());
        param.put("ENABLE_FLAG", users.getEnableFlag());
        param.put("EMAIL", users.getEmail());
        param.put("POSITION", users.getPosition());
        param.put("COST_CENTER_CODE", users.getCcCode());
        param.put("COST_CENTER_NAME", users.getCcName());
        param.put("GROUP_ID", users.getGroupId());
        param.put("SYSTEM_CODE", users.getSystemCode());
        
        int result = getNamedJdbcTemplate().update(sql.toString(), param);

        return result > 0 ? users : null;
	}
}
