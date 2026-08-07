//package com.app.controller.study.quiz.quiz10;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/quiz10")
//public class Quiz10Controller {
//
//	 @GetMapping("/A")
//	    public String accessA(HttpSession session, Model model) {
//
//	        List<String> history = new ArrayList<>();
//
//	        history.add("FromA");
//	        history.add("OriginalA");
//
//	        // 이전에 B를 방문했는지 확인
//	        if (session.getAttribute("visitB") != null) {
//	            history.add("FromB");
//	        }
//
//	        model.addAttribute("history", history);
//	        return "quiz/quiz10/a";
//	    }
//
//	    @GetMapping("/B")
//	    public String accessB(HttpSession session, Model model) {
//
//	        // B 방문 여부만 세션에 저장
//	        session.setAttribute("visitB", true);
//
//	        List<String> history = new ArrayList<>();
//	        history.add("FromB");
//	        history.add("OriginalB");
//
//	        model.addAttribute("history", history);
//	        return "quiz/quiz10/b";
//	    }
//	}

package com.app.controller.study.quiz.quiz10;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Quiz10Controller {

	
	@GetMapping("/quiz10/A")
	public String a() {
		
		return "quiz/quiz10/a";
	}
	
	@GetMapping("/quiz10/B")
	public String b(HttpSession session, Model model) {
		
		//session scope 에 fromB 에 다녀온것을 저장
		session.setAttribute("fromB", "FromB");
		
		model.addAttribute("fromB", "OriginalFromB");
		
		//request 현재 독립된 request 요청별
		//session 브라우저(사용자) 별로 구분 사용
		
		return "quiz/quiz10/b";
	}
	
	
	@GetMapping("/quiz10/A2")
	public String a2(Model model, HttpSession session) {
		
		model.addAttribute("fromMsg", "FromA");
		model.addAttribute("orgMsg", "OriginalA");
		
		model.addAttribute("A", "A");
		
		//session scope 확인 -> request scope 주입  
		model.addAttribute("fromB", session.getAttribute("fromB"));
		
		
		return "quiz/quiz10/ab";
	}
	
	@GetMapping("/quiz10/B2")
	public String b2(Model model, HttpSession session) {
		
		model.addAttribute("fromMsg", "FromB");
		model.addAttribute("orgMsg", "OriginalB");
		
		session.setAttribute("fromB", "FromB");
		
		return "quiz/quiz10/ab";
	}
	
	/*
	아래와 같이 접근하는 경로들이 있다.
	1. localhost:8080/quiz10/A
	2. localhost:8080/quiz10/B
	
	아래 케이스에 맞게 나타나도록 서버 및 화면 코드를 작성하세요.
	
	1) /A 경로로 접근 시의 화면 출력 결과
	
	FromA
	OriginalA
	
	2) /B 경로로 접근 시의 화면 출력 결과
	
	FromB
	OriginalB
	
	3) /B 경로로 접근 한 이후, /A경로로 접근 시 화면 출력 결과
	
	FromA
	OriginalA
	FromB
	*/
	
}