package com.its.member.Service;

import com.its.member.Repository.MemberRepository;
import com.its.member.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
@Autowired
private MemberRepository memberRepository;

    public boolean save(MemberDTO memberDTO) {

        int result = memberRepository.save(memberDTO);
        if (result > 0){
            return true;
        } else {
            return false;
        }
    }
    public boolean login(MemberDTO memberDTO) {

        MemberDTO member1 =  memberRepository.login(memberDTO);
        if (member1 != null){
            return true;
        } else {
            return false;
        }

    }

    public List<MemberDTO> members() {
        return memberRepository.members();
    }

    public MemberDTO findByMember(Long memberId) {
        return memberRepository.findByMember(memberId);
    }


    public void deleteMember(Long memberId) {
        memberRepository.deleteMember(memberId);
    }


}
