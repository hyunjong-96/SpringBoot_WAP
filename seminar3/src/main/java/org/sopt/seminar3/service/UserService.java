package org.sopt.seminar3.service;

import org.sopt.seminar3.model.DefaultRes;
import org.sopt.seminar3.model.User;

import java.util.List;

public interface UserService {
    //전체 User조회
    DefaultRes<List<User>> findAll();
    //userIdx로 User조회
    DefaultRes<User> findByUserIdx(final int userIdx);
    //User저장
    DefaultRes save(final User user);
    //User수정
    DefaultRes<User> update (final int userIdx,final User user);
    //userIdx로 User삭제
    DefaultRes deleteByUserIdx (final int userIdx);
}
