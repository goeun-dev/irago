package com.gora.irago.controller;

import com.gora.irago.domain.IdeaFNVO;
import com.gora.irago.domain.IdeaVO;
import com.gora.irago.service.IdeaService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/register")
    public ResponseEntity<IdeaVO> registerPOST(@RequestBody IdeaVO ideaVO) {

        log.info("register POST....." + ideaVO);

//        ideaService.register(ideaVO, ideaFNVO);
        return ResponseEntity.ok(ideaVO);

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
