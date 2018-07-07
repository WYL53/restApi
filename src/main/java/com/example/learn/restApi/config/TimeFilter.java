package com.example.learn.restApi.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("timeFiler init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(request,response);
        System.out.println("timeFilter :"+(System.currentTimeMillis()-start));
    }

    @Override
    public void destroy() {
        System.out.println("timeFilter destroy");
    }
}
