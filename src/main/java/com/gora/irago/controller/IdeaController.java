package com.gora.irago.controller;

import com.gora.irago.domain.IdeaFNVO;
import com.gora.irago.domain.IdeaVO;
import com.gora.irago.service.IdeaService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> registerPOST(@RequestBody IdeaVO ideaVO) {

        log.info("register POST....." + ideaVO);

        ideaService.register(ideaVO);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/read")
    public void readGET(Integer kid, Model model) {
        model.addAttribute("idea", ideaService.read(kid));
    }

    @GetMapping("/list")
    public void listGET(Model model) {
        model.addAttribute("ideaList", ideaService.getList());
    }

    @GetMapping("/modify")
    public void modifyGET(Integer kid, Model model) {
        model.addAttribute("idea", ideaService.read(kid));
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResponseEntity<String> modifyPOST(@RequestBody IdeaVO ideaVO) {

        log.info("modify POST....." + ideaVO);

        ideaService.modify(ideaVO);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deletePOST(Integer kid) {
        ideaService.remove(kid);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
