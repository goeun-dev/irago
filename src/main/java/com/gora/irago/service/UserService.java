package com.gora.irago.service;

import com.gora.irago.domain.SRVO;
import com.gora.irago.domain.UserVO;

import java.util.List;

public interface UserService {
    List<UserVO> findUserList();

    List<UserVO> findUserList(String auth);

    UserVO findUser(UserVO userVO);

    int removeUser(UserVO userVO);

    int addUser(UserVO userVO);
}
