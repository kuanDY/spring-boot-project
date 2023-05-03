package com.playdata.springbootproject.domain.posts;


import com.playdata.springbootproject.domain.AuditingEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 기본 생성자
@Entity// 기본 생성자가 기본으로 있어야한다.
public class Posts extends AuditingEntity {
    @Id     //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;    //big int
    @Column(length = 500, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;      //안달려있어도 맵핑은 되어있다.

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }


    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
