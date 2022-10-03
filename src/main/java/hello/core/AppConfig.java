package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig { // 실제 동작에 필요한 구현 객체를 생성한다.
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    private MemberRepository memberRepository() { // 사용자 정보 저장 db 결정
        return new MemoryMemberRepository(); // 여기서 구현체 넘겨줌.
    }
    public DiscountPolicy discountPolicy(){ // 할인 정책 결정
        return new FixDiscountPolicy(); // 여기서 구현체 넘겨줌.
    }

}
