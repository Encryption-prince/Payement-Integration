package com.spring.implementation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:5173", "https://virtual-herbal-garden-frontend.vercel.app/") // your React app address
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}