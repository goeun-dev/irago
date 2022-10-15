package com.gora.irago.mapper;

import com.gora.irago.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserVO> selectUserList(String auth);

    UserVO selectUser(UserVO userVO);
    int deleteUser(UserVO userVO);
    int insertUser(UserVO userVO);
}
