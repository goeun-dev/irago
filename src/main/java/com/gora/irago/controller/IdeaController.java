package com.gora.irago.controller;

import com.gora.irago.domain.IdeaFNVO;
import com.gora.irago.domain.IdeaVO;
import com.gora.irago.service.IdeaService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/idea")
@Controller
public class IdeaController {

    @Setter(onMethod_ = {@Autowired})
    private IdeaService ideaService;

    @GetMapping("/register")
    public void registerGET() {

        log.info("register GET......");
    }

    @PostMapping("/register")
    public void registerPOST(IdeaVO ideaVO, IdeaFNVO ideaFNVO) {

        log.info("register POST......" + ideaVO);

        ideaService.register(ideaVO, ideaFNVO);
    }

    @GetMapping("/read")
    public void readGET() {

    }

    @GetMapping("/list")
    public void listGET() {

    }

    @GetMapping("/modify")
    public void modifyGET() {

    }

    @GetMapping("/delete")
    public void deleteGET() {

    }
}
