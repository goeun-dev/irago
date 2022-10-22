package com.gora.irago.service;

import com.gora.irago.domain.IdeaVO;
import com.gora.irago.domain.PriorityVO;

import java.util.List;
import java.util.Map;

public interface IdeaService {

    void addIdea(IdeaVO ideaVO);

    List<IdeaVO> findIdeaList();

    IdeaVO findIdea(Integer kid);

    void removeIdea(Integer kid);

    void modifyIdea(IdeaVO ideaVO);
    
    // 우선순위 관련 메서드
    List<PriorityVO> findPriorityList(String division);
    void modifyPriority(Map<String, Object> obj);
}
