package org.spring.day11springbootinterceptors.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthorisationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)
            throws Exception {
        String userRole = request.getHeader("x-user-role");

        if(userRole != null && !userRole.equals("ADMIN")){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json");
            response.getWriter().write(
                            "{\n" +
                            "    \"message\" : \"You are not Authorised to perform this action\n" +
                            "}"
                           );
            return false;
        }

        return true;
    }
}
