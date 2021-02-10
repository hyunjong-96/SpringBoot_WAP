package org.sopt.seminar4.service;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar4.dto.User;
import org.sopt.seminar4.mapper.UserMapper;
import org.sopt.seminar4.model.DefaultRes;
import org.sopt.seminar4.utils.ResponseMessage;
import org.sopt.seminar4.utils.StatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Slf4j
@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public DefaultRes getAllUsers(){
        final List<User> userList = userMapper.findAll();
        if(userList.isEmpty())
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        return DefaultRes.res(StatusCode.OK,ResponseMessage.READ_USER,userList);
    }

    public DefaultRes findByName(final String name){
        final User user = userMapper.findByName(name);
        if(name == null)
            return DefaultRes.res(StatusCode.NOT_FOUND,ResponseMessage.NOT_FOUND_USER);
        return DefaultRes.res(StatusCode.OK,ResponseMessage.READ_USER,user);
    }

    @Transactional
    public DefaultRes save(final User user){
        try{
            userMapper.save(user);
            return DefaultRes.res(StatusCode.CREATED,ResponseMessage.CREATED_USER);
        }catch(Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR,ResponseMessage.DB_ERROR);
        }
    }
}
