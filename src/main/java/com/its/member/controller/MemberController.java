package com.its.member.controller;

import com.its.member.Service.MemberService;
import com.its.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/save")
    public String save(){
        return "memberSave";
    }

    @PostMapping("/save")
    public String memberSave(@ModelAttribute MemberDTO memberDTO, Model model){
        boolean result = memberService.save(memberDTO);
        model.addAttribute("result", result);
        if (result){
            return "memberLogin";
        } else{
            return "index";
        }
    }

    @GetMapping("/login")
    public String login(){
        return "memberLogin";
    }
    @PostMapping("/login")
    public String memberLogin(@ModelAttribute MemberDTO memberDTO, HttpSession session ,Model model){
        boolean loginResult = memberService.login(memberDTO);
        if (loginResult) {
            // 세션에 로그인한 사용자의 이메일을 저장
            session.setAttribute("loginEmail", memberDTO.getMemberEmail());
            model.addAttribute("modelEmail", memberDTO.getMemberEmail());
            return "memberMain";
        } else {
            return "memberLogin";
        }

    }

    @GetMapping("/members")
    public String findMember(Model model){
       List<MemberDTO> memberList = memberService.members();
       model.addAttribute("memberList", memberList);
       return "memberList";
    }

    @GetMapping("/member")
    public String findByMember(@RequestParam ("memberId") Long memberId, Model model){
        MemberDTO memberDTO = memberService.findByMember(memberId);
        model.addAttribute("member",memberDTO);
        return "memberDetail";
    }

}
