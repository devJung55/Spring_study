package com.example.ex02.controller;

import com.example.ex02.mapper.ProductMapper;
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
public class OrderControllerTests {
    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

//    주문
//    주문완료
    @Test
    public void orderTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/order/")
                .param("productId", "3")
                .param("productName", "감자")
                .param("productPrice", "1000")
                .param("productStock", "50")
        ).andReturn().getModelAndView().getModelMap().toString());
        mockMvc.perform(MockMvcRequestBuilders.post("/order/")
                .param("productId", "3")
                .param("productCount", "20")
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }

//    주문내역
    @Test
    public void showListTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/order/list")).andReturn().getModelAndView().getModelMap().toString());
    }

//    취소
    @Test
    public void cancelTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/order/cancel")
            .param("orderId", "3")
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }
}
