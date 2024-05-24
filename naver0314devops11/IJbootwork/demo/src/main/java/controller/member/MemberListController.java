package controller.member;

import data.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Controller
public class MemberListController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping({"/member/list"})
	public String memberList(Model model) {
		int totalCount = memberService.getTotalCount();
		model.addAttribute("totalCount",totalCount);
		
		return "member/memberlist";
	}
	
}
