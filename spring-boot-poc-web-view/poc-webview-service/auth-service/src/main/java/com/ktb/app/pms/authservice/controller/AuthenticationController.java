package com.ktb.app.pms.authservice.controller;

import com.ktb.app.pms.authservice.domain.AuthenticationRequest;
import com.ktb.app.pms.authservice.domain.AuthenticationRequest2;
import com.ktb.app.pms.authservice.domain.AuthenticationResponse;
import com.ktb.app.pms.authservice.service.UserService;
import com.ktb.app.pms.commonlibrary.controller.BaseController;
import com.ktb.app.pms.commonlibrary.entity.SeUsers;
import com.ktb.app.pms.commonlibrary.model.base.ResponseList;
import com.ktb.app.pms.commonlibrary.model.base.ResponseVo;
import com.ktb.app.pms.commonlibrary.model.request.RequestModel;
import com.ktb.app.pms.commonlibrary.model.request.ResponseModel;
import com.ktb.app.pms.commonlibrary.model.requestCC.RequestCCModel;
import com.ktb.app.pms.commonlibrary.model.requestCC.RequestCCRequest;
import com.ktb.app.pms.commonlibrary.model.user.UserDetailRequest;
import com.ktb.app.pms.commonlibrary.model.user.UserDetailResponse;
import com.ktb.app.pms.commonlibrary.security.JwtUtil;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@RestController
@Slf4j
public class AuthenticationController extends BaseController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;
    
    @Autowired
    UserService userService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest2 authenticationRequest2)
            throws Exception {
        try {
            /*authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));*/
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        //TODO
        SeUsers seUsers = new SeUsers();
        seUsers.setId(1L);

        //String token = jwtUtil.generateToken(authenticationRequest.getUsername(), String.valueOf(seUsers.getId()));
        String token = jwtUtil.generateToken("ASV", String.valueOf(seUsers.getId()));
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(token);
        return ResponseEntity.ok(authenticationResponse);
    }
    
    @RequestMapping(value = "/authenticate2", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken2(@RequestBody AuthenticationRequest2 authenticationRequest2)
            throws Exception {
        try {
            /*authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));*/
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        //TODO
        SeUsers seUsers = new SeUsers();
        seUsers.setId(1L);

        String token = jwtUtil.generateToken("HelloWorld", String.valueOf(seUsers.getId()));
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(token);
        return ResponseEntity.ok(authenticationResponse);
    }


    @RequestMapping(value = "/refreshtoken", method = RequestMethod.GET)
    public ResponseEntity<?> refreshtoken(HttpServletRequest request) throws Exception {
        // From the HttpRequest get the claims
        DefaultClaims claims = (DefaultClaims) request.getAttribute("claims");

        Map<String, Object> expectedMap = getMapFromIoJsonwebtokenClaims(claims);
        String token = jwtUtil.doGenerateRefreshToken(expectedMap, expectedMap.get("sub").toString());
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(token);
        return ResponseEntity.ok(authenticationResponse);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/getUserDetail")
    public ResponseVo<UserDetailResponse> getUserDetail(@RequestBody UserDetailRequest userDetailRequest, HttpServletResponse response)  throws Exception {
        ResponseVo<UserDetailResponse> responseVo = new ResponseVo<>();
        try {
            UserDetailResponse result = this.userService.getUserDetail(userDetailRequest);
            responseVo.setHeader(initHeaderSuccess(result));
            responseVo.setResponse(result);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            responseVo.setHeader(initHeaderError(e));
        }

        return responseVo;
    }

    public Map<String, Object> getMapFromIoJsonwebtokenClaims(DefaultClaims claims) {
        Map<String, Object> expectedMap = new HashMap<String, Object>();
        for (Entry<String, Object> entry : claims.entrySet()) {
            expectedMap.put(entry.getKey(), entry.getValue());
        }
        return expectedMap;
    }
}
