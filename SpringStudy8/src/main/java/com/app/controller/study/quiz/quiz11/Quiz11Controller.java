package com.app.controller.study.quiz.quiz11;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/quiz11")
public class Quiz11Controller {
	
	@GetMapping("/first")
    public String first(Model model,HttpSession session) {
		
		//session 에 hide3에 들렸다가 왓다? -> /firsthide3 출력
		//안갔다왔다? -> /first
		
		if(session.getAttribute("accessUrl")==null) {
			//안들렸다가 왔구나 그냥 바로 /first 로 접속했구나.
			model.addAttribute("accessUrl", "/first");
		}else {
			//firsthide3들렸다가 왓구나
			//model.addAttribute("accessUrl","firsthide3");
			model.addAttribute("accessUrl", session.getAttribute("accessUrl"));
			
			//session 영역 인식하는데 사용완료->삭제
			//session.invalidate(); //클리어 초기화
			session.removeAttribute("accessUrl"); //("... 세션에서 값 삭제
		}
        return "quiz/quiz11/targetPage";
    }
	
	@GetMapping("/firsthide1")
    public String firstHide1(Model model) {
        model.addAttribute("accessUrl", "/firsthide1");
        return "quiz/quiz11/targetPage"; 
    }
	
	@GetMapping("/firsthide2")
    public String firstHide2(Model model) {
        model.addAttribute("accessUrl", "/first");
        return "redirect:/quiz11/first"; 
    }
	
// ------------------------응용문제--------------------------//
//	********
//	//위 문제에 대한 응용버전 추가
//
//	localhost:8080/quiz11/firsthide3 로 접근했을때, 위 화면이 나타나도록 하세요.
//	accessUrl 은 "/firsthide3" 로 지정하세요.
//	*단, 주소창에 url은 /first 로 변경
//
//	**기존에 /first 로 바로 접속시에 화면에 /first 로 나오는 부분은 유지!!!
	//-> 접속경로가 hide3를 갔다가 온것으로 처리 할수있게...
	
//	@GetMapping("/firsthide3")
//    public String firstHide3(HttpServletRequest request,RedirectAttributes ra) {
//		ra.addFlashAttribute("redirectUrl", "hide3");
//        return "redirect:/quiz11/first"; }
        
        //session 기록 유지 ,redirect 일회성 전달용
        
	@GetMapping("/firsthide3")
    public String firstHide3(Model model,HttpSession session,
    						RedirectAttributes ra) {
		
		//model.addAttribute("accessUrl", "/firsthide3"); 
		
		//session 영역에 저장. 나 firsthide3 에 접속했다가 /first 경로로 왔다.
		session.setAttribute("accessUrl", "/firsthide3");
		  //           -> ("/first")경로 수정 추가
		ra.addFlashAttribute("fromhide3","/firsthide3");
		return "redirect:/quiz11/first";
	}        
    
}