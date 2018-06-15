package com.leofee.springbootdemo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author lxf
 */
@Component
@Setter
@Getter
public class HelloworldPropertiesConfiguration {

    @Value("${com.leofee.name}")
    private String name ;

    @Value("${com.leofee.age}")
    private Integer age ;
}
