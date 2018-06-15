package com.leofee.springbootdemo.controller;

import com.leofee.springbootdemo.HelloworldPropertiesConfiguration;
import com.leofee.springbootdemo.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import static java.util.stream.Collectors.toList;

/**
 * @author lxf
 */
@RestController
public class HelloworldController {

    @Autowired
    private HelloworldPropertiesConfiguration propertiesConfiguration ;

    private static final Logger logger = LoggerFactory.getLogger(HelloworldController.class) ;

    @RequestMapping("/")
    public String sayHelloWorld(){
        List<Person> list = new ArrayList<>() ;
        Person person = new Person() ;
        list.add(person) ;
        Consumer<Person> consumer = p -> {p.setAge(20);p.setName("hello world");} ;
        list.forEach(consumer);
        list.forEach(p -> System.out.printf("name: %s , age: %d" , p.getName() , p.getAge()));
        Comparator<Person> comparator = (Person p1 ,Person p2) -> {
            if(p1.getAge() > p2.getAge()){
                return 1 ;
            }else if(p1.getAge().intValue() == p2.getAge().intValue()){
                return 0 ;
            }else{
                return -1 ;
            }
        } ;
        List<Person> sortedList = list.stream().sorted(comparator).collect(toList()) ;
        if(logger.isDebugEnabled()){
            logger.info("properties , name:[{}] , age:[{}]" ,propertiesConfiguration.getName() , propertiesConfiguration.getAge());
        }else{
            logger.info("logger level is not debug");
        }
        return "Hello spring boot" ;
    }
}
