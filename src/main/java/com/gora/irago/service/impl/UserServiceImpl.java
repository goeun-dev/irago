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
    public List<UserVO> selectList() {
        return userMapper.selectList();
    }

    @Override
    public List<UserVO> selectAdminList() {
        return userMapper.selectAdminList();
    }

    @Override
    public UserVO selectOne(UserVO userVO) {
        return userMapper.selectOne(userVO);
    }

    @Override
    public int deleteOne(UserVO userVO) {
        return userMapper.deleteOne(userVO);
    }

    @Override
    public int insertOne(UserVO userVO) {
        return userMapper.insertOne(userVO);
    }
}
