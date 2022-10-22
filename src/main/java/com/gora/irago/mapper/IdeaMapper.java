package com.gora.irago.mapper;

import com.gora.irago.domain.IdeaFNVO;
import com.gora.irago.domain.IdeaVO;
import com.gora.irago.domain.PriorityVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IdeaMapper {

    void insertIdea(IdeaVO ideaVO);

    void insertIdeaFN(List<IdeaFNVO> ideaFNVOList);

    List<IdeaVO> selectIdeaList();

    IdeaVO selectIdea(Integer kid);

    List<IdeaFNVO> selectIdeaFNList(Integer ideaKid);

    void deleteIdea(Integer kid);

    void updateIdea(IdeaVO ideaVO);

    void updateIdeaFN(IdeaFNVO ideaFNVO);

    // 우선순위 관련 메서드
    List<PriorityVO> selectPriority(String division);

    void updatePriority(PriorityVO prVO);

    List<Integer> selectDivisionByPriority(List<PriorityVO> prList);

    void updateDivisionPriority(Integer priority, Integer kid);
    
}
