package MembershipManagement.MembershipManagement_TEST.Controller;


import MembershipManagement.MembershipManagement_TEST.DTO.MemberForm;
import MembershipManagement.MembershipManagement_TEST.domain.Member;
import MembershipManagement.MembershipManagement_TEST.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService ;

/**
    * 필드로 빈 생성

    @Autowired private final MemberService memberService ;


     * seter로 빈 생성방법

    @Autowired
    public void MemberService setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
     */

    @Autowired //생성자로 빈생성
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/members/new") // GET 요청시 여기로
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("members/new")   // POST 요청시 여기로
    public String create(MemberForm form){ //화면에서 넘기는 속성값과 이름 똑같이 맞춰줘야됨. 아니면 null값 뜸

        Member member = new Member();
        member.setName(form.getName());
        System.out.println("이름 = "+form.getName());
        memberService.join(member);

        return "redirect:/";
    }
    @GetMapping("/members")  // 회원조회
    public String list(Model model){ // model 객체는 html화면에 데이터를 보여줄때 사용
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
