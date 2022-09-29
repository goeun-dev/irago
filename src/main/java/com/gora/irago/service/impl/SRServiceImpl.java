package com.gora.irago.service.impl;

import com.gora.irago.domain.SRVO;
import com.gora.irago.mapper.SRMapper;
import com.gora.irago.service.SRService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SRServiceImpl implements SRService {

    @Setter(onMethod_ = {@Autowired})
    SRMapper srMapper;

    @Override
    public List<SRVO> selectList() {
        return srMapper.selectList();
    }

    @Override
    public SRVO selectOne(SRVO srVO) {
        return srMapper.selectOne(srVO);
    }

    @Override
    public int deleteOne(SRVO srVO) {
        return srMapper.deleteOne(srVO);
    }

    @Override
    public int insertOne(SRVO srVO) {
        return srMapper.insertOne(srVO);
    }
}
