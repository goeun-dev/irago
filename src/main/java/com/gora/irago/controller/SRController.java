package com.gora.irago.controller;

import com.gora.irago.domain.SRVO;
import com.gora.irago.service.SRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/sr")
@Controller
public class SRController {

    @Autowired
    SRService srService;

    @RequestMapping("/list.do")
    public String viewList(Model model){
        List<SRVO> list = srService.selectList();
        model.addAttribute("list", list);
        return "/sr/srList.html";
    }
}
