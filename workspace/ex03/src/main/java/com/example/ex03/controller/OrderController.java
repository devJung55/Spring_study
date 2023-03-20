package com.example.ex03.controller;

import com.example.ex03.domain.dto.OrderDTO;
import com.example.ex03.domain.vo.OrderVO;
import com.example.ex03.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders/*")
public class OrderController {
    private final OrderService orderService;

//    주문
    @PostMapping("order")
    public void order(@RequestBody OrderVO orderVO){
        orderService.order(orderVO);
    }

//    취소
    @GetMapping("cancel/{orderId}")
    public void cancel(@PathVariable("orderId") Long orderId){
        orderService.cancel(orderId);
    }

//    조회
    @GetMapping("{orderId}")
    public OrderDTO getOrder(@PathVariable("orderId") Long orderId) {
        return orderService.getOrder(orderId);
    }

//    전체 조회
    @GetMapping("list")
    public List<OrderDTO> showList() {
        return orderService.getList();
    }
}





















