package org.sopt.seminar3.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar3.model.DefaultRes;
import org.sopt.seminar3.model.User;
import org.sopt.seminar3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity getAllUsers(){
        log.info("get All Users");
        User user = new User(1,"이현종","서버");
        //DefaultRes<User> defaultRes = new DefaultRes<User>(HttpStatus.OK.value(),"Success Find User",user);
        DefaultRes defaultRes = new DefaultRes(HttpStatus.OK.value(), "Success Find User",user);
        return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);
    }
}
