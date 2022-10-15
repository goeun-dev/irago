package com.gora.irago.mapper;

import com.gora.irago.domain.SRVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SRMapper {
    List<SRVO> selectSRList();

    SRVO selectSR(SRVO srVO);

    int insertSR(SRVO srVO);

    int updateSR(SRVO srVO);

    int deleteSR(SRVO srVO);
}
