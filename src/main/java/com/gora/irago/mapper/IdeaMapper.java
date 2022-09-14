package com.gora.irago.mapper;

import com.gora.irago.domain.IdeaFNVO;
import com.gora.irago.domain.IdeaVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IdeaMapper {

    void insertIdea(IdeaVO ideaVO);

    void insertIdeaFN(IdeaFNVO ideaFNVO);
}
