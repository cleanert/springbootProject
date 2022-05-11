package com.jeongmin.springbootProject.repository;
import com.jeongmin.springbootProject.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>{
}
