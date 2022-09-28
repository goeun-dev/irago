package com.gora.irago.service;

import com.gora.irago.domain.SRVO;

import java.util.List;

public interface SRService {
    public List<SRVO> selectList();

    public SRVO selectOne(SRVO srVO);

    public int deleteOne(SRVO srVO);
}
