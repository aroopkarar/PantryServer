package com.pantryadmin.Controller;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.pantryadmin.Service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class WebFilter implements Filter {

    @Autowired
    UtilService utilService;

    @Autowired
    Environment environment;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Initiating WebFilter >> ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException{
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // Goes to default servlet
        System.out.println("Filter processed first: " + req.getServletPath());
        System.out.println("Authorization: "+req.getHeader("Authorization"));

        if(environment.getActiveProfiles().length>0){
            if(environment.getActiveProfiles()[0].equals("dev")){
                chain.doFilter(request, response);
                return;
            }
        }

        if (!(req.getServletPath().equals("/")) && !(req.getServletPath().contains("."))){
            String authHeader = req.getHeader("Authorization");
            System.out.println("authHeader: "+authHeader);
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                try {
                    if(req.getServletPath().equals("/loginUser"))
                    {
                        chain.doFilter(request, response);
                        return;
                    }
                    System.out.println("Not Accessible");
                    res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                    //res.sendRedirect("/");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Authentication authHeader: " + authHeader);
                String token = authHeader.split(" ")[1];
                System.out.println("token extracted: " + token);
                try {
                    utilService.verifyToken(token);
                    chain.doFilter(request, response);
                } catch (JWTVerificationException exception) {
                    res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                }
            }
        }
        else {
            System.out.println("Default Login Page");
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("Destroying WebFilter >> ");
    }
}