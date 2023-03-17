package com.example.ex03.controller;

import com.example.ex03.domain.vo.OrderVO;
import com.example.ex03.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;

//    주문 완료
    @PostMapping("/register/orders")
    @Transactional(rollbackFor = Exception.class)
    public void register(OrderVO orderVO) {
        log.info(orderVO.toString());
        orderService.order(orderVO);
    }

//    주문 내역
    @GetMapping("/list/orders")
    public void list() {
        log.info(orderService.getList().toString());
    }

//    주문 취소
    @DeleteMapping("/cancel/orders/{orderId}")
    @Transactional(rollbackFor = Exception.class)
    public void cancel(@PathVariable Long orderId) {
        log.info(orderId + "");
        orderService.cancel(orderId);
    }
}
