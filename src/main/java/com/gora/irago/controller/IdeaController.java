package com.gora.irago.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.gora.irago.domain.IdeaVO;
import com.gora.irago.domain.PriorityVO;
import com.gora.irago.service.IdeaService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/idea")
@Controller
public class IdeaController {

    @Autowired
    private IdeaService ideaService;

    @GetMapping("/add")
    public void ideaAdd() {

        log.info("register GET......");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> ideaAddPost(@RequestBody IdeaVO ideaVO) {

        log.info("register POST....." + ideaVO);

        ideaService.addIdea(ideaVO);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/details")
    public void ideaDetails(Integer kid, Model model) {

        model.addAttribute("idea", ideaService.findIdea(kid));
    }

    @GetMapping("/list")
    public void ideaList(Model model) {

        model.addAttribute("ideaList", ideaService.findIdeaList()
        );
    }

    @GetMapping("/modify")
    public void ideaModify(Integer kid, Model model) {
        model.addAttribute("idea", ideaService.findIdea(kid));
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResponseEntity<String> ideaModifyPost(@RequestBody IdeaVO ideaVO) {

        log.info("modify POST....." + ideaVO);

        ideaService.modifyIdea(ideaVO);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/remove")
    public ResponseEntity<String> ideaRemovePost(Integer kid) {
        ideaService.removeIdea(kid);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }


}
