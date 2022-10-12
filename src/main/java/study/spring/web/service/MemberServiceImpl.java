package study.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.spring.web.domain.Member;
import study.spring.web.Entity.MemberEntity;
import study.spring.web.repository.MemberRepository;

import java.util.Date;

@Service(value = "memberService")
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member register(Member member) {
        System.out.println("회원 등록 기능 호출됨");
        MemberEntity entity = new MemberEntity();
        entity.setId(member.getId());
        entity.setName(member.getName());
        entity.setCity(member.getCity());
        entity.setRegisterTime(new Date());

        memberRepository.save(entity);

        return member;
    }
}