//package com.app.controller.study.quiz.quiz02;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping("/quiz02")
//public class Quiz02Controller {
//
//	@RequestMapping("/req1")
//	public String req1() {
//		System.out.println("/quiz02/req1 GET 요청");
//		return "quiz/quiz02/req1";
//	}
//	
//	@PostMapping("/req2")
//	public String req2(HttpServletRequest request) {
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("name"));
//		System.out.println(request.getParameter("price"));
//		
//		System.out.println("/quiz02/req2 POST 요청");
//		return "quiz/quiz02/req2";
//	}
//	
//	@RequestMapping("/req3") //get,post 모두
//	public String req3(@RequestParam String p1,
//						 @RequestParam(required = false, defaultValue = "p2Default") String p2) {
//
//		//localhost:8080/quiz02/req3?p1=10&p2=40
//		System.out.println("/quiz02/req3 요청");
//	
//		
//		return "quiz/quiz02/req3";
//	}
//
//	
//}
//	
