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
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String srList(Model model) {

        // 접속 사용자 정보 불러오기
        UserVO userVO = new UserVO();
        userVO.setKid(1);
        userVO = userService.findUser(userVO);

        // SR 목록 불러오기
        List<SRVO> list = srService.findSrList();

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
    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String srDetails(Model model, @ModelAttribute("SRVO") SRVO srVO) {
        srVO = srService.findSR(srVO);
        model.addAttribute("sr", srVO);
        return "/sr/srDetails.html";
    }

    /**
     * SR 작성
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String srAdd(Model model) {

        // 접속 사용자 정보 불러오기
        UserVO userVO = new UserVO();
        userVO.setKid(1);
        userVO = userService.findUser(userVO);

        // sr 객체 생성, register 정보 담기
        SRVO srVO = new SRVO();
        srVO.setRegKid(userVO.getKid());
        srVO.setRegId(userVO.getId());

        // charger 목록 불러오기
        List<UserVO> charList = userService.findUserList("admin");

        // model attribute 세팅
        model.addAttribute("sr", srVO);
        model.addAttribute("user", userVO);
        model.addAttribute("charList", charList);
        return "/sr/srAdd.html";
    }

    /**
     * SR 작성 처리
     *
     * @param model
     * @param srVO
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String srAddPost(Model model, @ModelAttribute("SRVO") SRVO srVO) {
        int result;
            result = srService.addSR(srVO);
        if (result >= 1) {
            return "redirect:./list";
        } else {
            return "/error.html";
        }
    }

    /**
     * SR 수정
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String srModify(Model model, @ModelAttribute("SRVO") SRVO srVO) {
        // 수정할 SR 정보 불러오기
        srVO = srService.findSR(srVO);

        // charger 목록 불러오기
        List<UserVO> charList = userService.findUserList("admin");

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
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String srModifyPost(Model model, @ModelAttribute("SRVO") SRVO srVO) {
        int result;
       result = srService.modifySR(srVO);
        if (result >= 1) {
            return "redirect:./list";
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
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteOne(Model model, @ModelAttribute("SRVO") SRVO srVO) {
        int result = srService.removeSR(srVO);
        if (result >= 1) {
            List<SRVO> list = srService.findSrList();
            model.addAttribute("list", list);
            return "/sr/srList.html";
        } else {
            return "/error.html";
        }
    }
}
