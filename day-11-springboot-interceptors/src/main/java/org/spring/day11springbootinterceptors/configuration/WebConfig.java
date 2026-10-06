package org.spring.day11springbootinterceptors.configuration;

import org.spring.day11springbootinterceptors.interceptor.AuthenticationIntercepter;
import org.spring.day11springbootinterceptors.interceptor.LoggingInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public LoggingInterceptors LoggingInterceptors;

    public AuthenticationIntercepter authenticationIntercepter;
    public WebConfig(LoggingInterceptors interceptors,
                     AuthenticationIntercepter authenticationIntercepter){
        this.LoggingInterceptors = interceptors;
        this.authenticationIntercepter = authenticationIntercepter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(LoggingInterceptors)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/admin/*");
    }



}
