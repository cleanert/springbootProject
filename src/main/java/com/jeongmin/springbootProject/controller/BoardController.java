package com.jeongmin.springbootProject.controller;


import com.jeongmin.springbootProject.model.Board;
import com.jeongmin.springbootProject.repository.BoardRepository;
import com.jeongmin.springbootProject.validator.BoardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardValidator boardValidator;


//  게시판 리스트
    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/write")
    public String write(Model model) {
        model.addAttribute("board", new Board());
        return "board/write";
}

//    @GetMapping("/write")
//    public String write(Model model, @RequestParam(required = false) Long id) {
//        if(id == null) {
//            model.addAttribute("board", new Board());
//        } else {
//            Board board = boardRepository.findById(id).orElse(null);
//            model.addAttribute("board", board);
//        }
//        return "board/write";
//    }

    @PostMapping("/write")
    public String writeSubmit(@Valid Board board, BindingResult bindingResult){
        boardValidator.validate(board, bindingResult);
        if (bindingResult.hasErrors()) {
           return "board/write";
        }

        //  게시판 등록
        boardRepository.save(board);
        return "redirect:/board/list";
    }
}
