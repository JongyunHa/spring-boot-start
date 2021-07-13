package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.MemoryMemberRepository;
import hello.hellospring.repository.MemberRepository;

public class MemberService {
    private final MemberRepository memberrepository = new MemoryMemberRepository();

    /**
     * Sign Up
     */
    public Long join(Member member) {
        memberrepository.save(member);
        return member.getId();
    }
}
