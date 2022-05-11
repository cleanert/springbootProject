package com.jeongmin.springbootProject.controller;

import com.jeongmin.springbootProject.model.Article;
import com.jeongmin.springbootProject.model.Board;
import com.jeongmin.springbootProject.repository.ArticleRepository;
import com.jeongmin.springbootProject.repository.BoardRepository;
import com.sun.xml.bind.v2.schemagen.xmlschema.Particle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "board/list";
    }
}
