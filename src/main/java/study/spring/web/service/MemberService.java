package study.spring.web.service;

import study.spring.web.domain.Member;

public interface MemberService {
    /**
     * 회원을 등록한다.
     *
     * @param member 등록될 회원 정보
     * @return 등록된 회원 정보
     */
    public Member register(Member member);
}