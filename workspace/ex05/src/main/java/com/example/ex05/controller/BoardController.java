package com.example.ex05.controller;

import com.example.ex05.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boards/*")
public class BoardController {
    private final BoardService boardService;

//    게시글 조회
    @GetMapping("read")
    public void getBoard(Long boardId, Model model){
           model.addAttribute("board", boardService.getBoard(boardId));
    }

    @GetMapping("write")
    public void write(){

    }
}
