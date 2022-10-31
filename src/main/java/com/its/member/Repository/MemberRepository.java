package com.its.member.Repository;

import com.its.member.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public int save(MemberDTO memberDTO) {
        return sql.insert("Member.save",memberDTO);
    }


    public MemberDTO login(MemberDTO memberDTO) {
        return sql.selectOne("Member.login",memberDTO);
    }

    public List<MemberDTO> members() {
        return sql.selectList("Member.members");
    }

    public MemberDTO findByMember(Long memberId) {
        return sql.selectOne("Member.findByMember",memberId);
    }


    public void deleteMember(Long memberId) {
        sql.delete("Member.deleteMember", memberId);
    }

    public MemberDTO findByEmail(String memberEmail) {
        return sql.selectOne("Member.findByEmail", memberEmail);
    }

    public int update(MemberDTO memberDTO) {
        return  sql.update("Member.update", memberDTO);
    }

    public String emailDuplicateCheck(String memberEmail) { return  sql.selectOne("Member.duplicateCheck", memberEmail);
    }

}
