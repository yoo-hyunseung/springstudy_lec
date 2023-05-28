package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 스프링에서 찾을 수 있게 등며
public class MemberService {


    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    // 회원가입

    public Long join(Member member) {
        // 같은 이름이 있는 중복회원 안됨
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> { // ifPresent -> 이미 값이 있으면 Optional내부에 값이 있으면
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        vaildateDuplicatedMember(member); // 중복회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void vaildateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * */
    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
