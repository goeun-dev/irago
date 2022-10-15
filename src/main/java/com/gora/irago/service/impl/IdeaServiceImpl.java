package com.gora.irago.service.impl;

import com.gora.irago.domain.IdeaFNVO;
import com.gora.irago.domain.IdeaVO;
import com.gora.irago.mapper.IdeaMapper;
import com.gora.irago.service.IdeaService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class IdeaServiceImpl implements IdeaService {

    @Setter(onMethod_ = {@Autowired})
    private IdeaMapper ideaMapper;

    @Override
    public void addIdea(IdeaVO ideaVO) {

        log.info("idea service [register]....." + ideaVO);

        ideaMapper.insertIdea(ideaVO);
        ideaMapper.insertIdeaFN(ideaVO.getIdeaFNList());
    }

    @Override
    public List<IdeaVO> findIdeaList() {

        return ideaMapper.selectIdeaList();
    }

    @Override
    public IdeaVO findIdea(Integer kid) {

        IdeaVO idea = ideaMapper.selectIdea(kid);

        List<IdeaFNVO> ideaFNList = ideaMapper.selectIdeaFNList(kid);

        idea.setIdeaFNList(ideaFNList);

        return idea;
    }

    @Override
    public void removeIdea(Integer kid) {
        ideaMapper.deleteIdea(kid);
    }

    @Transactional
    @Override
    public void modifyIdea(IdeaVO ideaVO) {
        ideaMapper.updateIdea(ideaVO);

        for (IdeaFNVO fn : ideaVO.getIdeaFNList()) {
            ideaMapper.updateIdeaFN(fn);
        }
    }
}
