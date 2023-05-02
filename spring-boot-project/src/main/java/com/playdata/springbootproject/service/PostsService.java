package com.playdata.springbootproject.service;

import com.playdata.springbootproject.domain.Posts;
import com.playdata.springbootproject.domain.PostsRepository;
import com.playdata.springbootproject.web.dto.PostsResponseDto;
import com.playdata.springbootproject.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsSaveRequestDto requestDto) {
       Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException( "해당 게시물을 찾을 수 없습니다. id =" + id ));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException( "해당 게시물을 찾을 수 없습니다. id =" + id ));
       return new PostsResponseDto(posts);
    }
}
