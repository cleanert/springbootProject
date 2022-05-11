package com.jeongmin.springbootProject.repository;

import com.jeongmin.springbootProject.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
