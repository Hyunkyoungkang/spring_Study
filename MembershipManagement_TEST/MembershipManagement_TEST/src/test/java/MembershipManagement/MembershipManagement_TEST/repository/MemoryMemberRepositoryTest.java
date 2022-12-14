package MembershipManagement.MembershipManagement_TEST.repository;

import MembershipManagement.MembershipManagement_TEST.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

     MemoryMemberRepository repository = new MemoryMemberRepository();

     @Test
     public void save(){
          Member member = new Member();
          member.setName("spring");

          repository.save(member);

          Member result = repository.findById(member.getId()).get();
          Assertions.assertEquals(member, result);
     }

     @Test
     public void findByName(){
          Member member1 =new Member();
          member1.setName("spring1");
          repository.save(member1);

          Member member2 =new Member();
          member1.setName("spring2");
          repository.save(member2);

          Member result = repository.findByName("spring1").get();

          assertThat(result).isEqualTo(member1);
     }
}
