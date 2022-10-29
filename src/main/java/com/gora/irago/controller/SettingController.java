package com.gora.irago.controller;

import com.gora.irago.domain.PriorityVO;
import com.gora.irago.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/setting")
@Controller
public class SettingController {

    @Autowired
    PriorityService priorityService;

    // 우선순위 관련 컨트롤러
    // 우선순위 설정 페이지
    @GetMapping("/priority")
    public void prioritySetting(@ModelAttribute("division") String division, Model model) {



        if (division == null || division.isEmpty()) {
            division = "idea";
        }

        List<PriorityVO> prList = priorityService.findPriorityList(division);

        model.addAttribute("prList", prList);
        model.addAttribute("division", division);
    }

    // 우선순위 설정
    @RequestMapping(value = "/priority", method = RequestMethod.POST)
    public ResponseEntity<String> prioritySetting(@RequestBody Map<String, Object> prList) {

        priorityService.modifyPriority(prList);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
