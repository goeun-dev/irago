package com.gora.irago.controller;

import com.gora.irago.domain.SRVO;
import com.gora.irago.service.SRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping("/detail.do")
    public String viewDetail(Model model, @ModelAttribute("SRVO") SRVO srVO){
        srVO = srService.selectOne(srVO);
        model.addAttribute("VO", srVO);
        return "/sr/srDetail.html";
    }

    @RequestMapping("/create.do")
    public String createOne(){
        return "/sr/srCreate.html";
    }

    @RequestMapping("/modify.do")
    public String modifyOne(Model model){
        List<SRVO> list = srService.selectList();
        model.addAttribute("list", list);
        return "/sr/srModify.html";
    }

    @RequestMapping("/delete.do")
    public String deleteOne(Model model, @ModelAttribute("SRVO") SRVO srVO){
        int result = srService.deleteOne(srVO);
        if (result >= 1) {
            List<SRVO> list = srService.selectList();
            model.addAttribute("list", list);
            return "/sr/srList.html";
        }
        return "/error.html";
    }
}
