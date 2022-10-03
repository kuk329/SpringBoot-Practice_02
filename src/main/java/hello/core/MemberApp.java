package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService=appConfig.memberService();
      //  MemberService memberService = new MemberServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member=new Member(1L,"memberA", Grade.VIP); // 멤버 객체 하나 생성.
        memberService.join(member); // 위에서 생성한 멤버 객체를 hashmap 객체에 저장.

        Member findMember =memberService.findMember(1L);

        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
