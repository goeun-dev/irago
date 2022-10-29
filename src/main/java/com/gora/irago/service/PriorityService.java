package com.gora.irago.service;

import com.gora.irago.domain.PriorityVO;
import com.gora.irago.domain.SRVO;

import java.util.List;
import java.util.Map;

public interface PriorityService {

    // 우선순위 관련 메서드
    List<PriorityVO> findPriorityList(String division);
    void modifyPriority(Map<String, Object> obj);


}
