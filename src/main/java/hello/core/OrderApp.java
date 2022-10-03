package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService= appConfig.memberService();
//        OrderService orderService = appConfig.orderService(); // ctrl + alt + v (왼쪽 자동 생성)
//        MemberService memberService = new MemberServiceImpl(null);
//        OrderService orderService = new OrderServiceImpl(null,null);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member=new Member(memberId, "memberA", Grade.VIP); // 멤버 생성
        memberService.join(member); // 멤버 회원가입 (메모리에 저장됨)

        Order order =orderService.createOrder(memberId,"itemA",20000); // 주문 생성

        System.out.println("order = "+ order.toString()); // 주문에 대한 정보 가져옴
        System.out.println("order.calculatePrice = "+ order.calculatePrice()); // 주문에 대한 정보 가져옴
    }
}
