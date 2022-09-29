package com.gora.irago.service.impl;

import com.gora.irago.domain.IdeaFNVO;
import com.gora.irago.domain.IdeaVO;
import com.gora.irago.mapper.IdeaMapper;
import com.gora.irago.service.IdeaService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IdeaServiceImpl implements IdeaService {

    @Setter(onMethod_ = {@Autowired})
    private IdeaMapper ideaMapper;

    @Override
    public void register(IdeaVO ideaVO) {

        log.info("idea service [register]....." + ideaVO);

        ideaMapper.insertIdea(ideaVO);
        ideaMapper.insertIdeaFN(ideaVO.getIdeaFNList());
    }
}
