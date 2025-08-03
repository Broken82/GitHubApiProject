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
