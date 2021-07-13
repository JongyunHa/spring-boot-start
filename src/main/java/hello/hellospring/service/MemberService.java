package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.MemoryMemberRepository;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberrepository = new MemoryMemberRepository();

    /**
     * Sign Up
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복회원 X
        validateDuplicateMember(member);
        memberrepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberrepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberrepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberrepository.findById(memberId);
    }
}
