package com.gora.irago.mapper;

import com.gora.irago.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserVO> selectList();

    List<UserVO> selectAdminList();
    UserVO selectOne(UserVO userVO);
    int deleteOne(UserVO userVO);
    int insertOne(UserVO userVO);
}
