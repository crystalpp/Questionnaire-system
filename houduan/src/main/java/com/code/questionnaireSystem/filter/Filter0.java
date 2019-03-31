package com.code.questionnaireSystem.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 源控制过滤器
 * @date 2018年8月20日
 */
public class Filter0 implements Filter
{
    private Logger logger = LoggerFactory.getLogger(Filter0.class);

    private List<String> origins = Arrays.asList(new String[]{"http://193.112.64.47", "http://localhost:8083", "http://www.the15373.com", "http://dochub.the15373.com", null});

    public Filter0() {
    }

    public void destroy() {
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        String requestUri = req.getRequestURI();
        String originHeader = req.getHeader("Origin");
        if(origins.contains(originHeader)){
            res.setHeader("Access-Control-Allow-Origin", originHeader);
            res.setHeader("Access-Control-Allow-Methods", "POST, GET");
            res.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
            res.setHeader("Access-Control-Allow-Credentials", "true");
            chain.doFilter(req, res);
        }
        else{
            logger.info("@Filter0 " + originHeader + " not allowed!");
            return;
        }
    }
    public void init(FilterConfig fConfig) throws ServletException{
//        System.out.println(this.str);
    }
}
