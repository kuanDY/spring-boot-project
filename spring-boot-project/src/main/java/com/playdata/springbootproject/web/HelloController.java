package com.playdata.springbootproject.web;

import com.playdata.springbootproject.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam(value = "name", defaultValue = "김용호")String name,
                                     @RequestParam(value = "amount", defaultValue = "2000") int amount){

        return new HelloResponseDto(name, amount);


    }
}
