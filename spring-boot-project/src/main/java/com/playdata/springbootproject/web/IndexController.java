package com.playdata.springbootproject.web;

import com.playdata.springbootproject.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final PostsService postsService;
    @GetMapping("/")
    public String index(Model model){
        //model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
        model.addAttribute("posts",postsService.findAllDesc() );
        return "index";  //     /src/main/resources/templates/ + "index" + mustacahe
    }

    @GetMapping("/posts/save")
    public String savePost(){
        return "posts-save"; //     /src/main/resources/templates/ + "posts-save" + mustacahe
    }

    @GetMapping("/posts/{id}")
    public String updatePost(Model model, @PathVariable Long id){
        model.addAttribute("post",postsService.findById(id));
        return "posts-update";
    }

}
