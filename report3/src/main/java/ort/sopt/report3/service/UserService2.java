package ort.sopt.report3.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ort.sopt.report3.model.DefaultRes;
import ort.sopt.report3.model.User;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class UserService2 {
    private static final List<User> userList = new LinkedList<>();

    public DefaultRes<List<User>> findAll(){
        if(userList.isEmpty()) return DefaultRes.res(HttpStatus.NOT_FOUND.value(),"리스트가 비었습니다.");
        log.info("띵똥");
        return DefaultRes.res(HttpStatus.OK.value(),"리스트 조회 성공",userList);
    }
    public DefaultRes<User> findByName(final String name){
        for(User u : userList){
            if(u.getName().equals(name)){
                return DefaultRes.res(HttpStatus.OK.value(),"사용자 조회 성공",u);
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(),"사용자를 찾지 못했습니다.");
    }
    public DefaultRes<User> findByIdx(final int idx){
        for(User u : userList){
            if(u.getUser_idx()==idx){
                return DefaultRes.res(HttpStatus.OK.value(),"사용자 조회 성공",u);
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(),"사용자를 찾지 못했습니다.");
    }
    public DefaultRes<User> save(final User user){
        userList.add(user);
        return DefaultRes.res(HttpStatus.OK.value(),"User저장 성공");
    }
    public DefaultRes<User> update(final int idx,final User user){
        for(User u : userList){
            if(u.getUser_idx() == idx){
                userList.remove(u);
                userList.add(user);
                return DefaultRes.res(HttpStatus.OK.value(),"회원 정보 수정 성공");
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(),"회원을 찾을수 없습니다.");
    }
    public DefaultRes<User> delete(final int idx){
        for(User u : userList){
            if(u.getUser_idx()==idx){
                userList.remove(u);
                return DefaultRes.res(HttpStatus.OK.value(),"회원을 삭제했습니다.");
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(),"회원을 찾을수 없습니다.");
    }
}
