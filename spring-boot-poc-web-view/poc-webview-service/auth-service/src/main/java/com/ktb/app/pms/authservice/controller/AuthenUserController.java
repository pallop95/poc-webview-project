package com.ktb.app.pms.authservice.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ktb.app.pms.authservice.domain.AuthenRequest;
import com.ktb.app.pms.authservice.repository.UserRepository;
import com.ktb.app.pms.authservice.service.AuthenUserService;
import com.ktb.app.pms.commonlibrary.controller.BaseController;
import com.ktb.app.pms.commonlibrary.entity.Users;
import com.ktb.app.pms.commonlibrary.model.base.ResponseVo;
import com.ktb.app.pms.commonlibrary.model.request.ResponseModel;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AuthenUserController extends BaseController {

	
	@Autowired
	AuthenUserService authenUserService;
	
	@RequestMapping(value = "/authenUser", method = RequestMethod.POST)
	public ResponseVo<Users> authenUser(@RequestBody AuthenRequest authenRequest,  HttpServletResponse response) throws Exception{
		
		
		//select User
		//Users user = this.userRepository.getUserByEmail("wanchai.janvivattanakul@ktb.co.th");
		//log.info("user : "+user);
		ResponseVo<Users> respData = new ResponseVo<>();
		try {
            
			Users user = this.authenUserService.checkUser("w");
			
			respData.setHeader(initHeaderSuccess(user));
			respData.setResponse(user);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            respData.setHeader(initHeaderError(e));
        }

		return respData;
		
	}
}
