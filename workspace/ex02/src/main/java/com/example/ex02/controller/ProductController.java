package com.example.ex02.controller;

import com.example.ex02.domain.ProductVO;
import com.example.ex02.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product/*")
public class ProductController {
    private final ProductMapper productMapper;
    
//    등록
    @GetMapping("register")
    public void register(Model model){
        model.addAttribute(new ProductVO());
    }
    
//    등록 완료
    @PostMapping("register")
    public RedirectView register(ProductVO productVO) {
        productMapper.insert(productVO);
        return new RedirectView("/product/list");
    }

//    상세보기, 수정
    @GetMapping({"detail", "update"})
    public void get(Long productId, Model model){
        model.addAttribute(productMapper.select(productId));
    }
    
//    수정 완료
    @PostMapping("update")
    public RedirectView update(ProductVO productVO, RedirectAttributes redirectAttributes){
        productMapper.update(productVO);
        redirectAttributes.addAttribute("productId", productVO.getProductId());
        return new RedirectView("/product/detail");
    }

//    전체 목록
    @GetMapping("list")
    public void showList(Model model){
        model.addAttribute("products", productMapper.selectAll());
    }
}
