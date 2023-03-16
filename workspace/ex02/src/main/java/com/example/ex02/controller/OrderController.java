package com.example.ex02.controller;

import com.example.ex02.domain.dto.OrderDTO;
import com.example.ex02.domain.vo.OrderVO;
import com.example.ex02.domain.vo.ProductVO;
import com.example.ex02.mapper.OrderMapper;
import com.example.ex02.mapper.ProductMapper;
import com.example.ex02.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order/*")
@Slf4j
public class OrderController {
    private OrderService orderService;

//    주문
    @GetMapping("/")
    public void order(ProductVO productVO){;}

//    주문완료
    @PostMapping("/")
    @Transactional(rollbackFor = Exception.class)
    public RedirectView order(OrderVO orderVO) {
        orderService.order(orderVO);
        return new RedirectView("/order/list");
    }

//    주문내역
    @GetMapping("list")
    public void showList(Model model) {
        model.addAttribute("orders", orderService.getList());
    }

//    주문취소
    @PostMapping("cancel")
    @Transactional(rollbackFor = Exception.class)
    public RedirectView cancel(Long orderId) {
        orderService.cancel(orderId);
        return new RedirectView("/order/list");
    }
}
