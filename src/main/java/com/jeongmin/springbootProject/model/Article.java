package com.jeongmin.springbootProject.model;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reg_Date;
    private String update_Date;
    private int member_Id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;
}