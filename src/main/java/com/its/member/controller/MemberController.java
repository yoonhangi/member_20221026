package com.its.member.controller;

import com.its.member.Service.MemberService;
import com.its.member.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

//    회원가입 페이지 출력
    @GetMapping("/save")
    public String save(){
        return "memberSave";
    }

//   회원가입 처리
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

//   로그인 페이지 출력
    @GetMapping("/login")
    public String login(){
        return "memberLogin";
    }

//  로그인 처리
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

//  전체 회원 목록 출력
    @GetMapping("/members")
    public String findMember(Model model){
       List<MemberDTO> memberList = memberService.members();
       model.addAttribute("memberList", memberList);
       return "memberList";
    }

//  선택한 회원 상세 조회(번호 클릭하면 상세정보 출력)
    @GetMapping("/member")
    public String findByMember(@RequestParam ("memberId") Long memberId, Model model){
        MemberDTO memberDTO = memberService.findByMember(memberId);
        model.addAttribute("member",memberDTO);
        return "memberDetail";
    }

//   회원 삭제(관리자가 회원 삭제하는 것)
    @GetMapping("/delete")
    public String deleteMember(@RequestParam ("memberId") Long memberId, Model model){
        memberService.deleteMember(memberId);
//       1. 삭제 후 목록을 DB에서 가져오고 memberList.jsp로 간다
//      List<MemberDTO> memberDTOList = memberService.members();
//      model.addAttribute("memberList", memberDTOList);
//      2. redirect 방식을 이용하여 /members 주소 요청
        return "redirect:/members";
    }

//   회원 수정화면(정보 수정할 회원 정보 출력)
    @GetMapping("/update")
    public String updateForm(HttpSession session, Model model) {
        // session 값을 가져오기
        String memberEmail = (String) session.getAttribute("loginEmail");
        // memberEmail로 DB에서 해당 회원의 전체 정보 조회
        MemberDTO memberDTO = memberService.findByEmail(memberEmail);
        model.addAttribute("member", memberDTO);
        return "memberUpdate";
    }

    //    회원 정보 수정 처리
    @PostMapping("/update")
    public String update(@ModelAttribute MemberDTO memberDTO){
        boolean result = memberService.update(memberDTO);
        if (result) {
            //로그인 회원의 memberDetail.jsp
            return "redirect:member?memberId="+memberDTO.getMemberId();
        } else {
            return "index";
        }
    }

    //    로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session){
//        session.invalidate() = session정보 초기화
        session.invalidate();
        return "index";
    }

//   이메일 중복 체크
    @PostMapping("/duplicate-check")
    public @ResponseBody String emailDuplicateCheck(@RequestParam("inputEmail") String memberEmail) {
        System.out.println("memberEmail =" +memberEmail);
        String checkResult = memberService.emailDuplicateCheck(memberEmail);
        return checkResult;
    }

//   ajax로 회원상세정보 출력
    @GetMapping("/detail-ajax")
    public @ResponseBody MemberDTO detailAjax(@RequestParam("memberId") Long memberId) {
        MemberDTO memberDTO = memberService.findByMember(memberId);
        return  memberDTO;
    }


    @GetMapping("/ajax-ex")
    public String ajaxEx() {
        return "ajaxEx";
    }

    @GetMapping("/ajax1")
    public @ResponseBody String ajax1() {
        System.out.println("MemberController.ajax1");
        return "ok";
    }

    @PostMapping("/ajax2")
    public @ResponseBody String ajax2() {
        System.out.println("MemberController.ajax2");
        return "good";
    }

    @GetMapping("/ajax3")
    public @ResponseBody String ajax3(@RequestParam("value1") String value1,
                                      @RequestParam("value2") String value2) {
        System.out.println("MemberController.ajax3");
        System.out.println("value1 = " + value1 + ", value2 = " + value2);
        return "vvv";
    }

    @PostMapping("/ajax4")
    public @ResponseBody String ajax4(@RequestParam("value1") String value1,
                                      @RequestParam("value2") String value2) {
        System.out.println("MemberController.ajax4");
        System.out.println("value1 = " + value1 + ", value2 = " + value2);
        String value3 = "i am return";
        return value3;
    }

    @PostMapping("/ajax5")
    public @ResponseBody MemberDTO ajax5(@RequestParam("value1") String value1,
                                         @RequestParam("value2") String value2) {
        System.out.println("MemberController.ajax5");
        System.out.println("value1 = " + value1 + ", value2 = " + value2);
        String value3 = "i am return";
        MemberDTO memberDTO = memberService.findByMember(1L);
        return memberDTO;
    }

    @PostMapping("/ajax6")
    public @ResponseBody List<MemberDTO> ajax6(@RequestParam("value1") String value1,
                                               @RequestParam("value2") String value2) {
        System.out.println("MemberController.ajax6");
        System.out.println("value1 = " + value1 + ", value2 = " + value2);
        String value3 = "i am return";
        List<MemberDTO> memberDTOList = memberService.members();
        return memberDTOList;
    }





}
