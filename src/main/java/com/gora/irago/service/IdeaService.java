package com.gora.irago.service;

import com.gora.irago.domain.IdeaVO;

import java.util.List;

public interface IdeaService {

    void addIdea(IdeaVO ideaVO);

    List<IdeaVO> findIdeaList();

    IdeaVO findIdea(Integer kid);

    void removeIdea(Integer kid);

    void modifyIdea(IdeaVO ideaVO);
}
