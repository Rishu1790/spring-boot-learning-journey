package org.spring.day11springbootinterceptors.configuration;

import org.spring.day11springbootinterceptors.interceptor.AuthenticationIntercepter;
import org.spring.day11springbootinterceptors.interceptor.AuthorisationInterceptor;
import org.spring.day11springbootinterceptors.interceptor.LoggingInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public LoggingInterceptors LoggingInterceptors;
    public AuthenticationIntercepter authenticationIntercepter;
    public AuthorisationInterceptor authorisationInterceptor;


    public WebConfig(LoggingInterceptors logginginterceptors,
                     AuthenticationIntercepter authenticationIntercepter,
                     AuthorisationInterceptor authorisationInterceptor){
        this.LoggingInterceptors = logginginterceptors;
        this.authenticationIntercepter = authenticationIntercepter;
        this.authorisationInterceptor = authorisationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationIntercepter)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/admin/*","api/public/**")
                 .order(1);


        registry.addInterceptor(LoggingInterceptors)
                        .order(3);
        registry.addInterceptor(authorisationInterceptor)
                .order(2);
    }



}
