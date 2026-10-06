package org.spring.day11springbootinterceptors.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptors implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)
            throws Exception {

        System.out.println("Incoming Request -------------");

        System.out.println("HTTP Methods: "+ request.getMethod());
        System.out.println("Request URI: "+request.getRequestURI());
        System.out.println("Request Parameters: "+request.getQueryString());
        System.out.println("Token Header: "+request.getHeader("token"));
        System.out.println("Client IP: " + request.getRemoteAddr());


        if(handler instanceof HandlerMethod handlerMethod){
            System.out.println("Controller: " + handlerMethod.getBeanType().getName());
            System.out.println("Controller Methods: "+ handlerMethod.getMethod().getName());
        }



        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                 @Nullable Exception ex)
            throws Exception {
        System.out.println("Response Status: "+ response.getStatus() );

    }
}
