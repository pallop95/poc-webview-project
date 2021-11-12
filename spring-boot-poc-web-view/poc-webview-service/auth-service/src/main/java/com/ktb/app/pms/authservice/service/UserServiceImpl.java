package com.ktb.app.pms.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktb.app.pms.authservice.repository.UserRepository;
import com.ktb.app.pms.commonlibrary.model.user.UserDetailRequest;
import com.ktb.app.pms.commonlibrary.model.user.UserDetailResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetailResponse getUserDetail(UserDetailRequest userDetailRequest) throws Exception {
		return userRepository.getUserDetail(userDetailRequest);
	}

}
