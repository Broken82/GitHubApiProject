package com.broken.githubapiproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    private final static String TOKEN = "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";

    @Bean
    public RestClient restClient(){
        return RestClient.builder().baseUrl("https://api.github.com")
                .defaultHeader("Authorization", "Bearer " + TOKEN)
                .build();
    }
}
