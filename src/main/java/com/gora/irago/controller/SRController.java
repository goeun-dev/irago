package com.gora.irago.controller;

import com.gora.irago.domain.SRVO;
import com.gora.irago.domain.UserVO;
import com.gora.irago.service.SRService;
import com.gora.irago.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * SR 게시판 조회, 작성 및 수정, 삭제 Controller
 *
 * @author EGG
 * @version 1.0.0
 * 작성일 2022-09-29
 * @see
 **/
@RequestMapping("/sr")
@Controller
public class SRController {

    @Autowired
    SRService srService;

    @Autowired
    UserService userService;

    /**
     * SR 목록 조회
     *
     * @param model
     * @return
     */
    @RequestMapping("/list.do")
    public String viewList(Model model) {

        // 접속 사용자 정보 불러오기
        UserVO userVO = new UserVO();
        userVO.setKid(1);
        userVO = userService.selectOne(userVO);

        // SR 목록 불러오기
        List<SRVO> list = srService.selectList();

        // model attribute 세팅
        model.addAttribute("list", list);
        model.addAttribute("user", userVO);
        return "/sr/srList.html";
    }

    /**
     * SR 상세 조회
     *
     * @param model
     * @param srVO
     * @return
     */
    @RequestMapping("/detail.do")
    public String viewDetail(Model model, @ModelAttribute("SRVO") SRVO srVO) {
        srVO = srService.selectOne(srVO);
        model.addAttribute("sr", srVO);
        return "/sr/srDetail.html";
    }

    /**
     * SR 작성
     *
     * @param model
     * @return
     */
    @RequestMapping("/create.do")
    public String createOne(Model model) {

        // 접속 사용자 정보 불러오기
        UserVO userVO = new UserVO();
        userVO.setKid(1);
        userVO = userService.selectOne(userVO);

        // sr 객체 생성, register 정보 담기
        SRVO srVO = new SRVO();
        srVO.setRegKid(userVO.getKid());
        srVO.setRegId(userVO.getId());

        // charger 목록 불러오기
        List<UserVO> charList = userService.selectAdminList();

        // model attribute 세팅
        model.addAttribute("sr", srVO);
        model.addAttribute("user", userVO);
        model.addAttribute("charList", charList);
        return "/sr/srCreate.html";
    }

    /**
     * SR 수정
     *
     * @param model
     * @return
     */
    @RequestMapping("/modify.do")
    public String modifyOne(Model model, @ModelAttribute("SRVO") SRVO srVO) {
        // 수정할 SR 정보 불러오기
        srVO = srService.selectOne(srVO);

        // charger 목록 불러오기
        List<UserVO> charList = userService.selectAdminList();

        // model attribute 세팅
        model.addAttribute("sr", srVO);
        model.addAttribute("charList", charList);
        return "/sr/srModify.html";
    }

    /**
     * SR 작성 및 수정 처리
     *
     * @param model
     * @param srVO
     * @return
     */
    @RequestMapping("/confirm.do")
    public String confirmOne(Model model, @ModelAttribute("SRVO") SRVO srVO) {
        int result;
        if (srVO.getKid() == 0) {
            result = srService.insertOne(srVO);
        } else {
            result = srService.updateOne(srVO);
        }
        if (result >= 1) {
            return "redirect:./list.do";
        } else {
            return "/error.html";
        }
    }

    /**
     * SR 삭제
     *
     * @param model
     * @param srVO
     * @return
     */
    @RequestMapping("/delete.do")
    public String deleteOne(Model model, @ModelAttribute("SRVO") SRVO srVO) {
        int result = srService.deleteOne(srVO);
        if (result >= 1) {
            List<SRVO> list = srService.selectList();
            model.addAttribute("list", list);
            return "/sr/srList.html";
        } else {
            return "/error.html";
        }
    }
}
