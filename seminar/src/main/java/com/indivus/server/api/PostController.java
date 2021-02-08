package com.indivus.server.api;

import com.indivus.server.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")//method는 {}, 초기url설정은 /post로 시작함.
public class PostController {
    @PostMapping("")
    public String postUser(@RequestBody final User user){
        return user.getName();
    }
}
