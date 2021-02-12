package org.sopt.seminar4.service;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar4.dto.User;
import org.sopt.seminar4.mapper.UserMapper;
import org.sopt.seminar4.model.DefaultRes;
import org.sopt.seminar4.model.SignUpReq;
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
    private final S3FileUploadService s3FileUploadService;

    public UserService(UserMapper userMapper, S3FileUploadService s3FileUploadService) {
        this.userMapper = userMapper;
        this.s3FileUploadService = s3FileUploadService;
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
    public DefaultRes save(SignUpReq signUpReq){
        try{
            //파일이 있다면 파일을 S3에 저장 후 경로를 저장.
            if(signUpReq.getProfile() != null)
                log.info("확인getProfile null");
                signUpReq.setProfileUrl(s3FileUploadService.upload(signUpReq.getProfile()));
            log.info("확인getProfile notnull");
            userMapper.save(signUpReq);
            log.info("확인3");
            return DefaultRes.res(StatusCode.CREATED,ResponseMessage.CREATED_USER);
        }catch(Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR,ResponseMessage.DB_ERROR);
        }
    }

    @Transactional
    public DefaultRes update(final int userIdx,final SignUpReq signUpReq){
        try{
            if(signUpReq.getProfile() != null)
                signUpReq.setProfileUrl(s3FileUploadService.upload(signUpReq.getProfile()));
            userMapper.update(userIdx,signUpReq);
            return DefaultRes.res(StatusCode.OK,ResponseMessage.UPDATE_USER);
        }catch(Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR,ResponseMessage.DB_ERROR);
        }
    }

    @Transactional
    public DefaultRes deleteByUserIdx(final int userIdx){
        try{
            userMapper.delete(userIdx);
            return DefaultRes.res(StatusCode.OK,ResponseMessage.DELETE_USER);
        }catch(Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR,ResponseMessage.DB_ERROR);
        }
    }
}
