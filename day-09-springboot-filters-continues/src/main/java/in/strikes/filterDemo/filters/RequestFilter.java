package in.strikes.filterDemo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpServletResponse =
                (HttpServletResponse) response;
        HttpServletRequest httpServletRequest =
                (HttpServletRequest) request;



    }
}
