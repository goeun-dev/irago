package com.gora.irago.mapper;

import com.gora.irago.domain.IdeaVO;
import com.gora.irago.domain.PriorityVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class IdeaMapperTest {

    @Autowired
    IdeaMapper ideaMapper;

    @Test
    public void register() {

        IdeaVO idea = new IdeaVO();

//        idea.setTitle("title...");
//        idea.setContent("content...");

        ideaMapper.insertIdea(idea);
    }

    @Test
    public void findDivisionByPriority() {
        List<PriorityVO> prList = ideaMapper.selectPriority("idea");
        log.info("" + ideaMapper.selectDivisionByPriority(prList));
    }
}
