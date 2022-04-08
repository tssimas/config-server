package com.tssimas.configserver.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@Data
@ConfigurationProperties("config-server.security")
public class ConfigServerProperties {

    private final List<ApplicationClient> clients = new ArrayList<>();
    private final List<ApplicationPath> paths = new ArrayList<>();

}
