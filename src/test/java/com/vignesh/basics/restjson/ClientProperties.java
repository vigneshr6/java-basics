package com.vignesh.basics.restjson;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "rest")
@Data
public class ClientProperties {
    private String url;
    private List<Long> userIds;
}
