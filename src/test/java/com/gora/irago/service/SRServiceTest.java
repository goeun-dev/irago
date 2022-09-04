package com.gora.irago.service;

import com.gora.irago.domain.SRVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SRServiceTest {

    @Autowired
    SRService srService;

    @Test
    public void SR목록불러오기테스트(){
        List<SRVO> result = srService.selectList();
        System.out.println(result);
    }
}