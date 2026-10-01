package in.strikes.filterDemo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

//@Component
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

        BufferedReader reader = httpServletRequest.getReader();

        StringBuilder body = new StringBuilder();
        String line = reader.readLine();

        while(line!=null){
            body.append(line);
            line = reader.readLine();
        }


        System.out.println(body);
        chain.doFilter(request, response);

        // Ekbaar Body read lkarr li phirr dubara uss body ko read nhi karr skte wo null ho jaya h

        // To Read That body After reading once:--> Humlog req ki wrapper class use karr sakte h



    }
}
