package com.rikkei.session8.config;

import com.cloudinary.Cloudinary;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloundiaryConfig {
   // cloud_name, api_key, api_secret.
    @Value("${cloudinary.cloud-name}")
    private String cloudName;
    @Value("{cloudinary.api-key")
    private String apiKey;
    @Value("${cloudinary.api-secret")
    private String apiSecret;

    @Bean
    public Cloudinary cloudinary() {
        Map<String,String> map = new HashMap<>();
        map.put("cloud_name", cloudName);
        map.put("api_key", apiKey);
        map.put("api_secret", apiSecret);
        return new Cloudinary(map);
    }
}
