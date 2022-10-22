package com.gora.irago.service.impl;

import com.gora.irago.domain.IdeaFNVO;
import com.gora.irago.domain.IdeaVO;
import com.gora.irago.domain.PriorityVO;
import com.gora.irago.mapper.IdeaMapper;
import com.gora.irago.service.IdeaService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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

    
    // 우선순위 관련 메서드
    @Override
    public List<PriorityVO> findPriorityList(String division) {
        return ideaMapper.selectPriority(division);
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

            ideaMapper.updatePriority(vo);
        });
        
        // 우선순위 설정 값에 맞춰서 각 division(테이블) priority 값 업데이트
        // 1. select 로 값 조회하기
        List<Integer> list = findDivisionByPriority(division);
        // 2. 조회한 값 순서대로 priority 값 업데이트
        modifyIdeaPriority(list);
    }

    public List<Integer> findDivisionByPriority(String division) {
        List<PriorityVO> prList = findPriorityList(division);

        return ideaMapper.selectDivisionByPriority(prList);
    }

    public void modifyIdeaPriority(List<Integer> kidList) {

        AtomicInteger i = new AtomicInteger();
        i.set(1);

        kidList.forEach(k -> {

            Integer priority = Integer.valueOf(i.get());
            Integer kid = k;
//            log.info("priority: " + priority + ", kid: " + kid);
            ideaMapper.updateDivisionPriority(priority, kid);

            i.getAndIncrement();
        });

    }
}
