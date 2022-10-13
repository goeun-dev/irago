package com.gora.irago.service.impl;

import com.gora.irago.domain.SRVO;
import com.gora.irago.domain.UserVO;
import com.gora.irago.mapper.UserMapper;
import com.gora.irago.service.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Setter(onMethod_ = {@Autowired})
    UserMapper userMapper;

    @Override
    public List<UserVO> findUserList() {
        return userMapper.selectUserList("");
    }

    @Override
    public List<UserVO> findUserList(String auth) {
        return userMapper.selectUserList(auth);
    }

    @Override
    public UserVO findUser(UserVO userVO) {
        return userMapper.selectUser(userVO);
    }

    @Override
    public int removeUser(UserVO userVO) {
        return userMapper.deleteUser(userVO);
    }

    @Override
    public int addUser(UserVO userVO) {
        return userMapper.insertUser(userVO);
    }
}
