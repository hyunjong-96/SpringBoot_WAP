package org.sopt.seminar4.api;

import lombok.extern.slf4j.Slf4j;
import static org.sopt.seminar4.model.DefaultRes.FAIL_DEFAULT_RES;

import org.sopt.seminar4.dto.User;
import org.sopt.seminar4.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("users")
public class userController {
    private final UserService userService;

    public userController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity getUser(@RequestParam("name") Optional<String> name){
        try{
            if(name.isPresent()) return new ResponseEntity(userService.findByName(name.get()),HttpStatus.OK);
            return new ResponseEntity(userService.getAllUsers(),HttpStatus.OK);
        }catch(Exception e){
            log.error(e.getMessage());
            return new ResponseEntity(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity signup(@RequestBody final User user){
        try{
            return new ResponseEntity(userService.save(user),HttpStatus.OK);
        }catch(Exception e){
            log.error(e.getMessage());
            return new ResponseEntity(FAIL_DEFAULT_RES,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{userIdx}")
    public ResponseEntity signup(
            @PathVariable(value = "userIdx")final int userIdx,
            @RequestBody final User user){
        try{
            return null;
        }catch(Exception e){
            log.error(e.getMessage());
            return new ResponseEntity(FAIL_DEFAULT_RES,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{userIdx}")
    public ResponseEntity deleteUser(@PathVariable(value = "userIdx")final int userIdx){
        try{
            return null;
        }catch(Exception e){
            log.error(e.getMessage());
            return new ResponseEntity(FAIL_DEFAULT_RES,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
