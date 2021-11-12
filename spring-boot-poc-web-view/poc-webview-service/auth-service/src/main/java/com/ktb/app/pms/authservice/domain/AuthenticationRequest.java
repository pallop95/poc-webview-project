package com.ktb.app.pms.authservice.domain;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String username;
    private String password;

}
