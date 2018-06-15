package com.leofee.springbootdemo.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author lxf
 */
@Setter
@Getter
public class Person implements Serializable{

    private String name ;

    private Integer age ;
}
