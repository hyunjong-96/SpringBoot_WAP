package org.sopt.seminar3.service.impl;

import org.sopt.seminar3.model.DefaultRes;
import org.sopt.seminar3.model.User;
import org.sopt.seminar3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final List<User> userList = new LinkedList<>();

    @Override
    public DefaultRes<List<User>> findAll() {
        if(userList.isEmpty()) return DefaultRes.res(HttpStatus.NOT_FOUND.value(),"리스트가 비었습니다.");
        return DefaultRes.res(HttpStatus.OK.value(),"리스트 조회 성공",userList);
    }

    @Override
    public DefaultRes<User> findByUserIdx(int userIdx) {
        return null;
    }

    @Override
    public DefaultRes save(User user) {
        return null;
    }

    @Override
    public DefaultRes<User> update(int userIdx, User user) {
        return null;
    }

    @Override
    public DefaultRes deleteByUserIdx(int userIdx) {
        return null;
    }
}
