package MembershipManagement.MembershipManagement_TEST.service;

import MembershipManagement.MembershipManagement_TEST.Controller.MemberController;
import MembershipManagement.MembershipManagement_TEST.domain.Member;
import MembershipManagement.MembershipManagement_TEST.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service// 빈 자동생성 방법
public class MemberService {

    private final MemoryMemberRepository memoryMemberRepository;

    @Autowired
    public MemberService(MemoryMemberRepository memoryMemberRepository) {
        this.memoryMemberRepository = memoryMemberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member){

        validateDuplicateMember(member);
        memoryMemberRepository.save(member);
        return member.getId();
    }
        private void validateDuplicateMember(Member member){
            memoryMemberRepository.findByName(member.getName())
                    .ifPresent(member1 -> {
                        throw new IllegalStateException("이미 존재하는 회원입니다.");
                    });
        }


        public List<Member> findMembers(){
        return memoryMemberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memoryMemberRepository.findById(memberId);
    }
}
