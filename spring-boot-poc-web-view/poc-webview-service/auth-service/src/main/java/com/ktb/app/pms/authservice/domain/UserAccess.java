package com.ktb.app.pms.authservice.domain;

import lombok.Data;

@Data
public class UserAccess {
    private String username;
    private String password;
    private String role;

}
