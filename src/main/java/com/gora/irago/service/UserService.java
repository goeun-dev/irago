package com.gora.irago.service;

import com.gora.irago.domain.SRVO;
import com.gora.irago.domain.UserVO;

import java.util.List;

public interface UserService {
    List<UserVO> selectList();

    List<UserVO> selectAdminList();

    UserVO selectOne(UserVO userVO);

    int deleteOne(UserVO userVO);

    int insertOne(UserVO userVO);
}
