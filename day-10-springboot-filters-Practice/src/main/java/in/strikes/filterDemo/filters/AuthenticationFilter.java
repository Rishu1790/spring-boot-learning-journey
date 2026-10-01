package in.strikes.filterDemo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpRes = (HttpServletResponse) response;

        String token = httpReq.getHeader("token");

        if(token == null || !token.equals("12345")){

            httpRes.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            httpRes.setContentType("application/json");
            httpRes.getWriter().write(
                    "{\n" +
                            " \"User\": \"User Authenticated\"\n" +
                            "}"

            );
            return;

        }

    }
}
