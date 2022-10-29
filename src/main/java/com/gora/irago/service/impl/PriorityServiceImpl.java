package com.gora.irago.service.impl;

import com.gora.irago.domain.IdeaFNVO;
import com.gora.irago.domain.PriorityVO;
import com.gora.irago.domain.SRVO;
import com.gora.irago.mapper.PriorityMapper;
import com.gora.irago.mapper.SRMapper;
import com.gora.irago.service.PriorityService;
import com.gora.irago.service.SRService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
public class PriorityServiceImpl implements PriorityService {

    @Autowired
    PriorityMapper priorityMapper;

    // 우선순위 관련 메서드
    @Override
    public List<PriorityVO> findPriorityList(String division) {
        return priorityMapper.selectPriority(division);
    }

    @Override
    public void modifyPriority(Map<String, Object> obj) {

        Map<String, Object> object = (Map<String, Object>)obj.get("prList");

        String division = (String)object.get("division");

        List<Map<String, Object>> prList = (List<Map<String, Object>>)object.get("priority");

        prList.forEach(i -> {
            log.info("" + i);

            PriorityVO vo = new PriorityVO();

            vo.setDivision(division);
            vo.setType((String)i.get("type"));
            vo.setPriority(Integer.parseInt((String)i.get("priority")));
            vo.setOrder((String)i.get("order"));

            priorityMapper.updatePriority(vo);
        });

        // 우선순위 설정 값에 맞춰서 각 division(테이블) priority 값 업데이트
        // 1. select 로 값 조회하기
        List<Integer> list = findKidByPriority(division);
        // 2. 조회한 값 순서대로 priority 값 업데이트
        modifyDivisionPriority(division, list);
    }

    public List<Integer> findKidByPriority(String division) {
        List<PriorityVO> prList = findPriorityList(division);

        return priorityMapper.selectKidByPriority(division, prList);
    }

    public void modifyDivisionPriority(String division, List<Integer> kidList) {

        AtomicInteger i = new AtomicInteger();
        i.set(1);

        kidList.forEach(k -> {

            PriorityVO prVO = new PriorityVO();



            Integer priority = Integer.valueOf(i.get());
            Integer kid = k;

            prVO.setPriority(priority);
            prVO.setDivision(division);
            prVO.setKid(kid);

//            log.info("priority: " + priority + ", kid: " + kid);
            priorityMapper.updateDivisionByPriority(prVO);

            i.getAndIncrement();
        });

    }
}
