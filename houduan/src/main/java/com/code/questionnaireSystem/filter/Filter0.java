package com.code.questionnaireSystem.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 源控制过滤器
 * 
 * @date 2018年8月20日
 */
public class Filter0 implements Filter {
	private Logger logger = LoggerFactory.getLogger(Filter0.class);

	private List<String> origins = Arrays.asList(
			new String[] { "http://101.132.106.184", "http://localhost:8083", "http://192.168.1.102:8083", null });

	public Filter0() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String requestUri = req.getRequestURI();
		String originHeader = req.getHeader("Origin");
		if (origins.contains(originHeader)) {
			res.setHeader("Access-Control-Allow-Origin", originHeader);
			res.setHeader("Access-Control-Allow-Methods", "POST, GET");
			res.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
			res.setHeader("Access-Control-Allow-Credentials", "true");
			chain.doFilter(req, res);
		} else {
			logger.info("@Filter0 " + originHeader + " not allowed!");
			return;
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// System.out.println(this.str);
	}
}
