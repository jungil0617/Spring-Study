package hello.hello_spring.controller;

import hello.hello_spring.aop.TimeTraceAop;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }

    /*
     @Bean
     public MemberRepository memberRepository() {
     return new MemoryMemberRepository();
     return new JdbcMemberRepository(dataSource);
     return new JdbcTemplateMemberRepository(dataSource);
     return new JpaMemberRepository(em);
     }
    */

}