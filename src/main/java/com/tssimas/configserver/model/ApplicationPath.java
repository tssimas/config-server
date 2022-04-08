package com.tssimas.configserver.model;

import lombok.Data;

@Data
public class ApplicationPath {

    private String name;
    private String path;
    private String[] requiredRoles;

}