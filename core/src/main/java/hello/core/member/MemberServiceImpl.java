package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    // 생성자를 통해 외부(AppConfig)에서 구현 객체가 들어올 수 있도록 설계
    // MemberServiceImpl 은 의존관계에 대한 정보는 AppConfig 에 맡기고 실행에만 집중
    // MemberServiceImpl 은 MemberRepository 인 추상에만 의존하면 됨
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
