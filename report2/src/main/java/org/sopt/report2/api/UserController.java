package org.sopt.report2.api;

import org.sopt.report2.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
public class UserController {

    private final static List<User> userList = new LinkedList<>();

    @GetMapping("")
    public String getNowTime(){
        return new Date().toString();
    }

    @GetMapping("/users")
    public String getUserList(
            @RequestParam(value = "name",required = false)final String name,
            @RequestParam(value = "part",required = false)final String part){
            if(name != null){
                System.out.println("name: "+name);
                for(User u : userList){
                    if(u.getName().equals(name)) return u.toString();
                }
                return "없습니다";
            }
            if(part != null){
                System.out.println("part: "+part);
                for(User u : userList){
                    if(u.getPart().equals(part)) return u.toString();
                }
                return "없습니다";
            }else{
                if(userList.isEmpty()) return "리스트가 비었습니다";
                else{
                    StringBuilder stringBuilder = new StringBuilder();
                    for(User u : userList){
                        stringBuilder.append(u.toString()).append("\n");
                    }
                    return stringBuilder.toString();
                }
            }
    }

    @GetMapping("/users/{user_idx}")
    public String getUser(@PathVariable(value = "user_idx")final int user_idx){
        for(User u : userList){
            if(u.getUser_idx() == user_idx){
                return u.toString();
            }
        }
        return "없습니다.";
    }

    @PostMapping("/users")
    public String saveUser(@RequestBody final User user){
        userList.add(user);
        return "Success Save user";
    }

    @PutMapping("/users/{user_idx}")
    public String updateUser(
            @PathVariable(value = "user_idx")final int user_idx,
            @RequestBody final User user){
        for(User u : userList) {
            if (u.getUser_idx() == user_idx) {
                userList.remove(u);
                userList.add(user);
                return "Success Update User";
            }
        }
        return "Fail Update User";
    }

    @DeleteMapping("/users/{user_idx}")
    public String deleteUser(@PathVariable(value = "user_idx")final int user_idx){
        for(User u : userList){
            if(u.getUser_idx() == user_idx){
                userList.remove(u);
                return "Success Remove User";
            }
        }
        return "Fail Delete User";
    }
}
