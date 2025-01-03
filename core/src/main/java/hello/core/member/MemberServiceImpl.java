package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// ComponentScan 의 대상이 되도록 @Component 추가
@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    // 생성자를 통해 외부(AppConfig)에서 구현 객체가 들어올 수 있도록 설계
    // MemberServiceImpl 은 의존관계에 대한 정보는 AppConfig 에 맡기고 실행에만 집중
    // MemberServiceImpl 은 MemberRepository 인 추상에만 의존하면 됨
    @Autowired  // 의존관계를 자동으로 주입 ac.getBean(MemberRepository.class);
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
