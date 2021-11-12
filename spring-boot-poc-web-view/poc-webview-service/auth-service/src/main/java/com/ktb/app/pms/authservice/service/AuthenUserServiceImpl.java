package com.ktb.app.pms.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktb.app.pms.authservice.repository.UserRepository;
import com.ktb.app.pms.commonlibrary.entity.Users;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthenUserServiceImpl implements AuthenUserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Users checkUser(String email) throws Exception {
		
		
		Users user  = this.userRepository.getUserByEmail(email);
		
		if(user != null) {
			return user;
		}else {
			
			//call service
			
			//insert new users
			Users userModel = new Users(); 
			userModel.setUsername("4105223");
			userModel.setFullname("แสนชัย"+" "+"จันโสภา");
			userModel.setRoleId("USE");
			userModel.setEnableFlag("Y");
			userModel.setEmail(email);
			userModel.setPosition("รองผู้จัดการบริการลูกค้า");
			userModel.setCcCode("108504");
			userModel.setCcName("ฝ่ายพัฒนาและปรับปรุงระบบงาน 2");
			userModel.setSystemCode("0");
			
			Users userInsert = this.userRepository.insertUser(userModel);
			
			return userInsert;
			
		}
		
		
	}

}
