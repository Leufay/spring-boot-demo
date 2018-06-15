package com.leofee.springbootdemo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author lxf
 */
public class HelloworldFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(HelloworldFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init filter....... [{}]", logger.getName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest ;
        logger.info("doFilter , uri:[{}], url:[{}]", request.getRequestURI() , request.getRequestURL());
        filterChain.doFilter(servletRequest , servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("destroy filter.......  [{}]", logger.getName());
    }
}
