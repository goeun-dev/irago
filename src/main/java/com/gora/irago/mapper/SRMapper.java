package com.gora.irago.mapper;

import com.gora.irago.domain.SRVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SRMapper {
    public List<SRVO> selectList();
}
