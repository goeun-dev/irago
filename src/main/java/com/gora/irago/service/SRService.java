package com.gora.irago.service;

import com.gora.irago.domain.SRVO;

import java.util.List;

public interface SRService {
    List<SRVO> selectList();

    SRVO selectOne(SRVO srVO);

    int deleteOne(SRVO srVO);

    int insertOne(SRVO srVO);

    int updateOne(SRVO srVO);
}
