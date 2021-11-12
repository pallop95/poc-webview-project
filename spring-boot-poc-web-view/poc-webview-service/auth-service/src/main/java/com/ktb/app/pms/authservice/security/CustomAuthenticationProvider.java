package com.ktb.app.pms.authservice.security;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import java.util.ArrayList;

@Slf4j
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        try {

            //TODO
            Boolean loginSuccess = true;

            if(loginSuccess){
                // use the credentials
                // and authenticate against the third-party system
                return new UsernamePasswordAuthenticationToken(
                        username, password, new ArrayList<>());
            }else{
                return null;
            }

        } catch (Exception e) {
            log.info(" User not found : " + username);
        }
        return null;
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}
