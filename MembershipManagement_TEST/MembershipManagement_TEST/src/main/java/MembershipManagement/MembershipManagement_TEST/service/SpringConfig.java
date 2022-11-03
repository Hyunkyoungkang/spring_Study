package MembershipManagement.MembershipManagement_TEST.service;

import MembershipManagement.MembershipManagement_TEST.repository.MemberRepository;
import MembershipManagement.MembershipManagement_TEST.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 스프링 빈 수동생성방법
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memoryMemberRepository());
    }

    @Bean
    public MemoryMemberRepository memoryMemberRepository(){
        return new MemoryMemberRepository();
    }
}
 */