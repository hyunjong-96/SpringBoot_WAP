package org.sopt.seminar4.api;

import lombok.extern.slf4j.Slf4j;
import static org.sopt.seminar4.model.DefaultRes.FAIL_DEFAULT_RES;

import org.sopt.seminar4.dto.User;
import org.sopt.seminar4.model.SignUpReq;
import org.sopt.seminar4.service.UserService;
import org.sopt.seminar4.utils.auth.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("users")
public class userController {
    private final UserService userService;

    public userController(final UserService userService) {
        this.userService = userService;
    }

    @Auth
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
    public ResponseEntity signup(SignUpReq signUpReq, @RequestPart(value = "profile",required = false)final MultipartFile profile){
        try{
            //파일을 signUpReq에 저장
            log.info("확인1:"+signUpReq.getName()+"비밀번호:"+signUpReq.getPassword());
            if(profile != null) signUpReq.setProfile(profile);
            log.info("확인2");
            return new ResponseEntity(userService.save(signUpReq),HttpStatus.OK);
        }catch(Exception e){
            log.error(e.getMessage());
            return new ResponseEntity(FAIL_DEFAULT_RES,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Auth
    @PutMapping("/{userIdx}")
    public ResponseEntity update(
            @PathVariable(value = "userIdx")final int userIdx,
            SignUpReq signUpReq,
            @RequestPart(value = "profile",required = false)final MultipartFile profile){
        try{
            if(profile != null) signUpReq.setProfile(profile);
            return new ResponseEntity(userService.update(userIdx,signUpReq),HttpStatus.OK);
        }catch(Exception e){
            log.error(e.getMessage());
            return new ResponseEntity(FAIL_DEFAULT_RES,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Auth
    @DeleteMapping("/{userIdx}")
    public ResponseEntity deleteUser(@PathVariable(value = "userIdx")final int userIdx){
        try{
            return new ResponseEntity(userService.deleteByUserIdx(userIdx),HttpStatus.OK);
        }catch(Exception e){
            log.error(e.getMessage());
            return new ResponseEntity(FAIL_DEFAULT_RES,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
