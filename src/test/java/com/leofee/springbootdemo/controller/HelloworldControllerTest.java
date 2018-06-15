package com.leofee.springbootdemo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author lxf
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloworldControllerTest {

    private MockMvc mockMvc ;

    private static final Logger logger = LoggerFactory.getLogger(HelloworldControllerTest.class) ;

    @Before
    public void init(){
        logger.info("time:[{}]初始化mockMvc",System.currentTimeMillis());
        // 初始化mockMvc
        this.mockMvc = MockMvcBuilders.standaloneSetup(new HelloworldController()).build() ;
    }

    @Test
    public void sayHelloworld() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect((status().isOk())).andExpect(content().string(equalTo("Hello spring Boot")));
    }
}
