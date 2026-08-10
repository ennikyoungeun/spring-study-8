package com.app.controller.study.quiz.quiz11;

import javax.servlet.http.HttpServletRequest;
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
    public String first(Model model) {

        model.addAttribute("accessUrl", "/first");
        //model.addAttribute("redirectUrl", "/firsthide3");
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
	

	@GetMapping("/firsthide3")
    public String firstHide3(HttpServletRequest request,RedirectAttributes ra) {
		ra.addFlashAttribute("redirectUrl", "hide3");
        return "redirect:/quiz11/first"; 
        
        //session 기록 유지 ,redirect 일회성 전달용
        
    }
}