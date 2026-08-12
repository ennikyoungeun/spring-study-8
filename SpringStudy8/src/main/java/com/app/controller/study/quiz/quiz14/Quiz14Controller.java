package com.app.controller.study.quiz.quiz14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz14")
public class Quiz14Controller {

    @Autowired
    private CupBean cupBean;

    @Autowired
    private PlateBean plateBean;

  
    @GetMapping("/fullOrder")
    public String fullOrder() {
        System.out.println("컵에 담긴 음료의 이름 - " + cupBean.getCoffeeBean().getName());
        System.out.println("접시에 담긴 디저트의 이름 - " + plateBean.getDessertBean().getName());
        
        return "quiz/quiz14/CoffeeList"; 
    }

   
    @GetMapping("/orderCoffee")
    public String orderCoffee() {
        System.out.println("컵에 담긴 음료의 이름 - " + cupBean.getCoffeeBean().getName());
        
        return "quiz/quiz14/CoffeeList";
    }

   
    @GetMapping("/orderDessert")
    public String orderDessert() {
        System.out.println("접시에 담긴 디저트의 이름 - " + plateBean.getDessertBean().getName());
        
        return "quiz/quiz14/CoffeeList"; 
    }
}