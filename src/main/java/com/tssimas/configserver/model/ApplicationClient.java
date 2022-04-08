package com.tssimas.configserver.model;

import lombok.Data;

@Data
public class ApplicationClient {

    private String username;
    private String password;
    private Boolean admin = false;
    private String[] roles;

}
