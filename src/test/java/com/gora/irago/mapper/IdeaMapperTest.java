package com.gora.irago.mapper;

import com.gora.irago.domain.IdeaVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IdeaMapperTest {

    @Autowired
    IdeaMapper mapper;

    @Test
    public void register() {

        IdeaVO idea = new IdeaVO();

        idea.setTitle("title...");
        idea.setContent("content...");

        mapper.insertIdea(idea);
    }
}
