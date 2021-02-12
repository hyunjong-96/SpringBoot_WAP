package org.sopt.seminar4.service;

import lombok.RequiredArgsConstructor;
import org.sopt.seminar4.dto.User;
import org.sopt.seminar4.mapper.UserMapper;
import org.sopt.seminar4.model.DefaultRes;
import org.sopt.seminar4.model.LoginReq;
import org.sopt.seminar4.utils.ResponseMessage;
import org.sopt.seminar4.utils.StatusCode;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserMapper userMapper;
    private final JwtService jwtService;

    public DefaultRes<JwtService.TokenRes> login(final LoginReq loginReq){
        final User user = userMapper.findByNameAndPassword(loginReq.getName(),loginReq.getPassword());
        if(user != null){
            //토큰 생성
            final JwtService.TokenRes tokenDto = new JwtService.TokenRes(jwtService.create(user.getUserIdx()));
            return DefaultRes.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS,tokenDto);
        }
        return DefaultRes.res(StatusCode.BAD_REQUEST,ResponseMessage.LOGIN_FAIL);
    }
}
