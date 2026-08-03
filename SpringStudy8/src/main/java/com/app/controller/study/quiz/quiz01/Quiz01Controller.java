package com.app.controller.study.quiz.quiz01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz01")
public class Quiz01Controller {

	@RequestMapping("/main")
	public String main() {
		return "quiz/quiz01/main";
	}
	@RequestMapping("/product/mouse") //controller
	public String mypage() {
		return "quiz/quiz01/product/mouse"; //viwes
	}
	@RequestMapping("/product/keyboard")
	public String product() {
		return "quiz/quiz01/product/keyboard";
	}
}
