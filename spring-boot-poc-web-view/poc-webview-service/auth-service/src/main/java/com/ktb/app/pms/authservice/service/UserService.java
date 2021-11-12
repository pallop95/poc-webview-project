package com.ktb.app.pms.authservice.service;

import com.ktb.app.pms.commonlibrary.model.user.UserDetailRequest;
import com.ktb.app.pms.commonlibrary.model.user.UserDetailResponse;

public interface UserService {
	UserDetailResponse getUserDetail(UserDetailRequest userDetailRequest) throws Exception;
}
