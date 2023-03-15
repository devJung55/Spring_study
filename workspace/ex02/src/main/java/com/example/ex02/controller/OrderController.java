package com.example.ex02.controller;

import com.example.ex02.domain.OrderDTO;
import com.example.ex02.domain.OrderVO;
import com.example.ex02.domain.ProductVO;
import com.example.ex02.mapper.OrderMapper;
import com.example.ex02.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order/*")
@Slf4j
public class OrderController {
    private final ProductMapper productMapper;
    private final OrderMapper orderMapper;

//    주문
    @GetMapping("/")
    public void order(ProductVO productVO){;}

//    주문완료
    @PostMapping("/")
    @Transactional(rollbackFor = Exception.class)
    public RedirectView order(OrderVO orderVO) {
        ProductVO productVO = productMapper.select(orderVO.getProductId());
        productVO.setProductStock(productVO.getProductStock() - orderVO.getProductCount());
        orderMapper.insert(orderVO);
        productMapper.update(productVO);
        return new RedirectView("/order/list");
    }

//    주문내역
    @GetMapping("list")
    public void showList(Model model) {
        model.addAttribute("orders", orderMapper.selectAll());
    }

//    주문취소
    @PostMapping("cancel")
    @Transactional(rollbackFor = Exception.class)
    public RedirectView cancel(Long orderId) {
        OrderDTO orderDTO = orderMapper.select(orderId);
        ProductVO productVO = productMapper.select(orderDTO.getProductId());
        productVO.setProductStock(productVO.getProductStock() + orderDTO.getProductCount());
        orderMapper.delete(orderId);
        productMapper.update(productVO);
        return new RedirectView("/order/list");
    }
}
