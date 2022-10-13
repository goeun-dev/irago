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
    public List<SRVO> findSrList() {
        return srMapper.selectSRList();
    }

    @Override
    public SRVO findSR(SRVO srVO) {
        return srMapper.selectSR(srVO);
    }

    @Override
    public int addSR(SRVO srVO) {
        return srMapper.insertSR(srVO);
    }

    @Override
    public int modifySR(SRVO srVO) {
        return srMapper.updateSR(srVO);
    }

    @Override
    public int removeSR(SRVO srVO) {
        return srMapper.deleteSR(srVO);
    }
}
