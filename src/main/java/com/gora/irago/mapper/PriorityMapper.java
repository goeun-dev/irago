package com.gora.irago.mapper;

import com.gora.irago.domain.IdeaFNVO;
import com.gora.irago.domain.PriorityVO;
import com.gora.irago.domain.SRVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PriorityMapper {

    // 우선순위 관련 메서드
    List<PriorityVO> selectPriority(String division);

    void updatePriority(PriorityVO prVO);

    List<Integer> selectKidByPriority(String division, List<PriorityVO> prList);

    void updateDivisionByPriority(PriorityVO prVO);


}
