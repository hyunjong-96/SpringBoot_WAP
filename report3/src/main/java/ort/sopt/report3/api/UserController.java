package ort.sopt.report3.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ort.sopt.report3.model.User;
import ort.sopt.report3.service.UserService2;

import java.util.Date;

@Slf4j
@RestController
public class UserController {
//    private final UserServiceImpl;
    private final UserService2 userService2;

    public UserController(UserService2 userService2) {
        this.userService2 = userService2;
    }

    @GetMapping("")
    public String getTime(){
        String nowDate = new Date().toString();
        log.info("현재 시간 반환: "+nowDate);
        return nowDate;
    }

    @GetMapping("/users")
    public ResponseEntity getAllUsers(
            @RequestParam(value = "name",required = false)final String name,
            @RequestParam(value = "part",required = false)final String part
    ){
        try{
            if(name != null){
                log.info("name: "+name);
                return new ResponseEntity<>(userService2.findByName(name),HttpStatus.OK);
            } else return new ResponseEntity<>(userService2.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{user_idx}")
    public ResponseEntity findById(@PathVariable(value = "user_idx")final int idx){
        try{
            log.info("findById메소드");
            return new ResponseEntity(userService2.findByIdx(idx),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users")
    public ResponseEntity save(@RequestBody final User user){
        try{
            log.info("save메소드");
            return new ResponseEntity(userService2.save(user),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{user_idx}")
    public ResponseEntity update(@PathVariable(value = "user_idx")final int idx,
                                 @RequestBody final User user){
        try{
            log.info("update메소드");
            return new ResponseEntity(userService2.update(idx,user),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/{user_idx}")
    public ResponseEntity delete(@PathVariable(value = "user_idx")final int idx){
        try{
            log.info("delete메소드");
            return new ResponseEntity(userService2.delete(idx),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
