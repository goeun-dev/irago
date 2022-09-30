package com.gora.irago.mapper;

import com.gora.irago.domain.IdeaFNVO;
import com.gora.irago.domain.IdeaVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IdeaMapper {

    void insertIdea(IdeaVO ideaVO);

    void insertIdeaFN(List<IdeaFNVO> ideaFNVOList);

    List<IdeaVO> selectList();

    IdeaVO selectIdea(Integer kid);

    List<IdeaFNVO> selectIdeaFN(Integer ideaKid);

    void delete(Integer kid);
}
