package com.app.controller.study.quiz.quiz08;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/quiz08")
public class Quiz08Controller {
	
//	"/quiz08/member?auth=basic"
//	"/quiz08/member?auth=manager"
//	"/quiz08/member?auth=admin" 
	
	@GetMapping("/member")
	public String member(@RequestParam String auth, Model model) {
		
		//경로가 어떻게 들어왓는냐
		
		//basic manager admin
		
		if(!( auth.equals("basic")||auth.equals("manager")||auth.equals("admin"))) {
			
			//파라미터가 잘못된 값이 들어온 경우 페이지 필터링
			return " 잘못된 접근 입니다! 페이지경로"; //view 지원
		}
		//화면을 보여준다
		
		List<Member> memberList = new ArrayList<Member>();

		memberList.add(new Member("user1", "pass123", "홍길동", "basic"));
		memberList.add(new Member("user2", "pass456", "김철수", "manager"));
		memberList.add(new Member("user3", "pass789", "이영희", "basic"));
		memberList.add(new Member("user4", "passabc", "박민지", "manager"));
		memberList.add(new Member("user5", "passdef", "정재영", "basic"));
		memberList.add(new Member("user6", "passxyz", "최성민", "basic"));
		memberList.add(new Member("user7", "pass123", "서지원", "manager"));
		memberList.add(new Member("user8", "pass456", "장성호", "basic"));
		memberList.add(new Member("user9", "pass789", "신지수", "basic"));
		memberList.add(new Member("user10", "passabc", "한영희", "manager"));
		
		//1) 서버에서 데이터 분리 -> 화면에 전달 ->view 에서는 그냥 출력
		
		//basic ->basic
		//manager->manager
		//admin-> 전부
		List<Member> viewMemberList = new ArrayList<Member>();
		
		for(Member m : memberList) {
			if(m.getType().equals(auth) || auth.equals("admin"))
				viewMemberList.add(m);
		}
		
		
//		if(auth.equals("basic") || auth.equals("manager")) {
//			for(Member m : memberList) {
//				if(m.getType().equals(auth))
//					viewMemberList.add(m);
//			}
//		
//		}else {
//			viewMemberList = memberList;
//		}
		
//		if(auth.equals("basic")) {
//			for(Member m : memberList) {
//				if(m.getType().equals("basic"))
//					viewMemberList.add(m);
//			}
//		}else if (auth.equals("manager")) {
//			for(Member m : memberList) {
//				if(m.getType().equals("manager"))
//					viewMemberList.add(m);
//			}
//		
//		}else {
//			viewMemberList = memberList;
//		}
		
		model.addAttribute("viewMemberList",viewMemberList);
			
		
		
		//2) 서버가 준비된 데이터 전부 화면에 전달 -> view에서 동적으로 출력대상 선별
		
		
		model.addAttribute("memberList",memberList);
		model.addAttribute("auth",auth);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return "/quiz/quiz08/memberViews";
	
	
	
	
	}
}
	
	
	/*
	 ---------내가한거-----------
	@GetMapping("/member")
	public String showMembers(@RequestParam(value="auth",defaultValue = "admin")
								String auth, Model model) {
		List<Member> memberList = new ArrayList<Member>();

		memberList.add(new Member("user1", "pass123", "홍길동", "basic"));
		memberList.add(new Member("user2", "pass456", "김철수", "manager"));
		memberList.add(new Member("user3", "pass789", "이영희", "basic"));
		memberList.add(new Member("user4", "passabc", "박민지", "manager"));
		memberList.add(new Member("user5", "passdef", "정재영", "basic"));
		memberList.add(new Member("user6", "passxyz", "최성민", "basic"));
		memberList.add(new Member("user7", "pass123", "서지원", "manager"));
		memberList.add(new Member("user8", "pass456", "장성호", "basic"));
		memberList.add(new Member("user9", "pass789", "신지수", "basic"));
		memberList.add(new Member("user10", "passabc", "한영희", "manager"));
		
		List<Member> filteredList = new ArrayList<>();
		
		for(Member m : memberList) {
			if("admin".equals(auth)) {
				filteredList.add(m);
			}else if(m.getType().equals(auth)) {
				filteredList.add(m);
			}
		}
		
		model.addAttribute("list",filteredList);
		model.addAttribute("authType",auth);
		
		return "/quiz/quiz08/memberViews";
		
		
	}
}
	*/
	

