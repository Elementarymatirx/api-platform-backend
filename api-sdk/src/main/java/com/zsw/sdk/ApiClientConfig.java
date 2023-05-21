package com.zsw.sdk;

import com.zsw.sdk.client.ApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * SDK配置类
 */
@Configuration
@ConfigurationProperties("api-client")
@Data
@Component
public class ApiClientConfig {

    private String accessKey;

    private String secretKey;

    public ApiClient apiClient() {
        ApiClient apiClient = new ApiClient(accessKey,secretKey);
        return apiClient;
    }
}
