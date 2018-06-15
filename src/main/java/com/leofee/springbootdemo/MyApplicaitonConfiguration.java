package com.leofee.springbootdemo;

import com.leofee.springbootdemo.filter.HelloworldFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lxf
 */
@Configuration
public class MyApplicaitonConfiguration {

    /**
     * 注册自定义的filter到过滤器链
     */
    @Bean
    public FilterRegistrationBean  addHelloworldFilter(){
        FilterRegistrationBean<HelloworldFilter>  filterRegister = new FilterRegistrationBean<> () ;
        filterRegister.setFilter(new HelloworldFilter());
        filterRegister.setOrder(1);
        filterRegister.addUrlPatterns("/*");
        filterRegister.addInitParameter("parameterName" , "hello my filter");
        filterRegister.setName("filterRegister") ;
        return filterRegister ;
    }
}
