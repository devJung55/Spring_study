package com.example.ex02.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@Slf4j
public class ProductControllerTests {
    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void registerTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/product/register")).andReturn().getModelAndView().getModelMap().toString());
        mockMvc.perform(MockMvcRequestBuilders.post("/product/register")
                .param("productName", "감자")
                .param("productPrice", "1000")
                .param("productStock", "50")
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }

    @Test
    public void updateTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/product/update").param("productId", "2"))
                .andReturn().getModelAndView().getViewName());

        log.info(mockMvc.perform(MockMvcRequestBuilders.post("/product/update")
                .param("productId", "2")
                .param("productName", "옥수수")
                .param("productPrice", "2000")
                .param("productStock", "80")
        ).andReturn().getModelAndView().getModelMap().toString());
    }

    @Test
    public void showListTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/product/list")).andReturn().getModelAndView().getModelMap().toString());
    }
}
