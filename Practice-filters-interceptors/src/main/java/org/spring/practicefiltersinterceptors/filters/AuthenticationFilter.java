package org.spring.practicefiltersinterceptors.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Primary
public class AuthenticationFilter implements Filter {

    private final HttpServletResponse httpServletResponse;

    public AuthenticationFilter(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String tokenId = httpServletRequest.getHeader("token");
        String apiKey = httpServletRequest.getHeader("x-api-key");

        if(tokenId==null || !tokenId.equals("12345")){
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().write(
                "{\n" +
                        "   \"message\" : \"Invalid or missing api key\"\n" +
                        "}"
        );
    }
}
