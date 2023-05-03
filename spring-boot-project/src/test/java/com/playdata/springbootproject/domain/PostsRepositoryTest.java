package com.playdata.springbootproject.domain;

import com.playdata.springbootproject.domain.posts.Posts;
import com.playdata.springbootproject.domain.posts.PostsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public  void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void saveAndLoad(){
        //give
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "playdata";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());


        //when
        Posts posts = postsRepository.findAll().get(0);

        //then
        assertEquals(posts.getTitle(), title);
        assertEquals(posts.getContent(), content);
        assertEquals(posts.getAuthor(),author);
    }

    @Test
    public  void auitingEntity(){
        //given
        String title = "title";
        String content = "content";
        String author = "author";
        LocalDateTime now = LocalDateTime.now();

        postsRepository.save(Posts.builder()
                        .title(title)
                        .content(content)
                        .author(author)
                .build());

        //when
        Posts posts = postsRepository.findAll().get(0);

        //then
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
