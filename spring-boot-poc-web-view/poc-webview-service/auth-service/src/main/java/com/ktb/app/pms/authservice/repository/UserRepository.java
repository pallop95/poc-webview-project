package com.ktb.app.pms.authservice.repository;

import com.ktb.app.pms.authservice.domain.UserAccess;
import com.ktb.app.pms.commonlibrary.entity.Users;
import com.ktb.app.pms.commonlibrary.model.user.UserDetailRequest;
import com.ktb.app.pms.commonlibrary.model.user.UserDetailResponse;

public interface UserRepository {
    UserAccess getUserAccessByUserName(String username);
    Users getUserByEmail(String email) throws Exception;
    UserDetailResponse getUserDetail(UserDetailRequest userDetailRequest) throws Exception;
    Users insertUser(Users users) throws Exception;
}
