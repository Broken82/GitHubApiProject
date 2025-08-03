package com.broken.githubapiproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Value("${github.token}")
    private String TOKEN;

    @Bean
    public RestClient restClient(){
        return RestClient.builder().baseUrl("https://api.github.com")
                .defaultHeader("Authorization", "Bearer " + TOKEN)
                .build();
    }
}
