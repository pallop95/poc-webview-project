package com.ktb.app.pms.authservice.service;

import com.ktb.app.pms.commonlibrary.entity.Users;

public interface AuthenUserService {
	Users checkUser(String email) throws Exception;
}