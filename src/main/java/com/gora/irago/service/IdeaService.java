package com.gora.irago.service;

import com.gora.irago.domain.IdeaVO;

import java.util.List;

public interface IdeaService {

    void register(IdeaVO ideaVO);

    List<IdeaVO> getList();

    IdeaVO read(Integer kid);

    void remove(Integer kid);

    void modify(IdeaVO ideaVO);
}
