package in.strikes.filterDemo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

//@Component
public class ResponseBodyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        ContentCachingResponseWrapper wrappedResp = new ContentCachingResponseWrapper(httpServletResponse);
        chain.doFilter(request,wrappedResp);

        byte[] responseBodyInByte = wrappedResp.getContentAsByteArray();
        String orignalBody = new String(responseBodyInByte);
        String modifiedBody =
                """
                
                {
                   "originalResponse" : %S,
                   "appName" : "Student Management System"
                   
                }
                """.formatted(orignalBody);

        wrappedResp.resetBuffer();

        wrappedResp.getWriter().write(modifiedBody);

        wrappedResp.copyBodyToResponse();


    }
}
