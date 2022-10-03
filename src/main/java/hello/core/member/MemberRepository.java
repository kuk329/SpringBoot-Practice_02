package hello.core.member;

public interface MemberRepository {

    void save(Member member); // 회원 저장. (회원 class 인스턴스를 받아서 )

    Member findById(Long memberId); // 아이디로 회원 찾기 ( 회원 아이디를 받음.)

}
