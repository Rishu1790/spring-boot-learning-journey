package in.strikes.filterDemo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class AutenticationFilter implements Filter {

    @Override
public void doFilter(ServletRequest request,
                     ServletResponse response,
                     FilterChain chain)
        throws IOException, ServletException {
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    String token = httpServletRequest.getHeader("token");

    if(token == null || !token.equals("12345") ){
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        // Bta rHa h ki jo Content h wo json format ka h mna ki text/ plain text;
        httpServletResponse.setContentType("application/json" );
        // Body Response
        httpServletResponse.getWriter().write(
                "{\n" +
                       " \"User\": \"User Authenticated\"\n" +
                        "}"


        );
        return;
    }
    chain.doFilter(request, response);



}

        }

