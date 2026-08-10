package com.app.controller.study.quiz.quiz12;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Quiz12Controller {

	
	 @GetMapping("/quiz12/login")
	 public String login() {
		 return "quiz/quiz12/login";
	 }
	 
	 @PostMapping("/quiz12/login")
	 public String loginAction(HttpServletRequest request) {
		 
		 //로그인 창에서 입력한 id pw 가 post 요청으로 데이터가 잘 수신되었는가?
		 System.out.println(request.getParameter("id")); 
		 System.out.println(request.getParameter("pw"));
		 
		 // id pw 검증 
		 // DB 에 있는 사용자정보와 비교 -> 아이디 비번이 맞으면? -> 로그인 성공

		 // 성공했다고 간주!!
		 // 세션에 해당 ID를 로그인한 아이디로 저장하고~
		 
		 HttpSession session = request.getSession();
		 session.setAttribute("loginId", request.getParameter("id"));
		 session.setAttribute("count", 0);
		 
		 //return "quiz/quiz12/count";  //해당 view 자원으로 연결 X
		 return "redirect:/quiz12/count"; //연결할 주소
	 }
	 
	 
	 @GetMapping("/quiz12/count")
	 public String count(HttpSession session, Model model) {
		 
		 System.out.println( session.getAttribute("loginId") );
		 
		 //model.addAttribute("loginId", session.getAttribute("loginId"));
		 
		 //로그인한 사용자가 있다 -> count 증가
		 //로그인한 사용자가 없으면 -> count 처리 할게 없음
		 
		 // 로그인한 사용자가 있으면 count 값도 초기화or값이존재 
		 
		 if( session.getAttribute("loginId") != null ) {  //사용자가 있다
			 //count++
			 //count = count + 1;
			 session.setAttribute("count",  (Integer)(session.getAttribute("count")) + 1 );
			 
		 } else {  //사용자가 없음.
			 model.addAttribute("count", 0);
		 }
		 
		 
		 return "quiz/quiz12/count";  //해당 view 자원으로 연결
	 }
	 
	 
	 @GetMapping("/quiz12/logout")
	 public String logout(HttpSession session) {
		 //세션에 저장된 기록 삭제 -> 로그인 이력이 없도록 (+count도 삭제)
		 // /quiz12/count 페이지로 이동 시킨다
		 
		 //session.removeAttribute("loginId");
		 //session.removeAttribute("count");
		 session.invalidate(); // 세션 전체 속성 삭제 초기화
		 
		//return "quiz/quiz12/count";  //해당 view 자원으로 연결 X
		return "redirect:/quiz12/count"; //연결할 주소
	 }
}
//package com.app.controller.study.quiz.quiz12;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLDecoder;
//import java.net.URLEncoder;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.app.util.MyCookieUtil;
//
//@Controller
//public class Quiz12Controller {
//
//   // 경로 1) GET 방식 접속 : 로그인 입력 화면 열기
//   @GetMapping("/quiz12/login")
//   public String loginView() {
//      // 보내주신 return "cookie/saveCookie"; 형태와 동일한 뷰 리턴 방식
//      return "quiz/quiz12/login"; 
//   }
//   
//   // 경로 1) POST 방식 접속 : 입력한 ID/PW 확인 후 쿠키 생성 및 이동
//   @PostMapping("/quiz12/login")
//   public String loginDo(HttpServletResponse response, String id, String pw) {
//      
//      // ID와 PW가 정상적으로 입력된 경우
//      if(id != null && !id.trim().isEmpty() && pw != null && !pw.trim().isEmpty()) {
//         
//         try {
//            // [배운 방식] 쿠키 value에 한글이나 띄어쓰기가 있을 수 있으므로 인코딩 처리
//            String encodedId = URLEncoder.encode(id, "UTF-8");
//            
//            // 사용자 ID를 쿠키에 저장 (지정 수명은 12시간으로 세팅)
//            Cookie userIdCookie = new Cookie("userId", encodedId);
//            userIdCookie.setMaxAge(60 * 60 * 12);
//            response.addCookie(userIdCookie);
//            
//            // 접속 횟수(count) 쿠키 생성 (초기값 0, 수명 12시간)
//            Cookie countCookie = new Cookie("visitCount", "0");
//            countCookie.setMaxAge(60 * 60 * 12);
//            response.addCookie(countCookie);
//            
//         } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//         }
//         
//         // 로그인 성공 후 카운트 페이지로 리다이렉트 이동
//         return "redirect:/quiz12/count";
//      }
//      
//      // 실패 시 다시 로그인 화면으로
//      return "redirect:/quiz12/login";
//   }
//   
//   // 경로 2) /quiz12/count 접속 : 쿠키를 읽어서 화면에 표시하고 카운트 증가
//   @GetMapping("/quiz12/count")
//   public String countView(HttpServletRequest request, HttpServletResponse response) {
//      
//      // [배운 방식] request에서 모든 쿠키 배열 꺼내기
//      Cookie[] cookies = request.getCookies();
//      
//      String userId = null;
//      String visitCountStr = null;
//      int count = 0;
//      
//      if(cookies != null) {
//         // [배운 방식] for문을 돌며 내가 필요한 쿠키 찾기
//         for(Cookie ck : cookies) {
//            
//               // 1. userId 쿠키 찾기 및 디코딩
//               if(ck.getName().equals("userId")) {
//                  try {
//                     userId = URLDecoder.decode(ck.getValue(), "UTF-8");
//                  } catch (UnsupportedEncodingException e) {
//                     e.printStackTrace();
//                  }
//               }
//               
//               // 2. visitCount 쿠키 찾기
//               if(ck.getName().equals("visitCount")) {
//                  visitCountStr = ck.getValue();
//               }
//         }
//      }
//      
//      // 로그인을 통해 사용자가 로그인 했다는 이력이 있는 경우 (쿠키가 존재할 때)
//      if(userId != null) {
//         if(visitCountStr != null) {
//            count = Integer.parseInt(visitCountStr);
//         }
//         
//         // 접속할 때마다 해당 count가 증가한다 (+1)
//         count++;
//         
//         // 변경된 카운트 값을 다시 쿠키에 구워서 응답에 담아줌
//         Cookie updateCountCookie = new Cookie("visitCount", String.valueOf(count));
//         updateCountCookie.setMaxAge(60 * 60 * 12);
//         response.addCookie(updateCountCookie);
//         
//         // [배운 방식] JSP 화면에서 사용할 수 있도록 request.setAttribute로 바인딩
//         request.setAttribute("userId", userId);
//         request.setAttribute("visitCount", count);
//         
//      } else {
//         // 로그인을 통해 로그인 했다는 이력이 없는 경우에는 횟수는 0으로 표기
//         request.setAttribute("visitCount", 0);
//      }
//      
//      // Util 클래스를 활용해서 콘솔에 찍어보던 학습 방식도 그대로 응용 가능
//      // String testId = MyCookieUtil.getCookieValue(request, "userId");
//      // System.out.println("현재 로그인된 ID 확인: " + testId);
//      
//      return "quiz/quiz12/count"; 
//   }
//   
//   // 경로 3) /quiz12/logout 접속 : 쿠키 수명을 0으로 세팅하여 삭제 후 이동
//   @GetMapping("/quiz12/logout")
//   public String logoutDo(HttpServletResponse response) {
//      
//      // [배운 방식] 쿠키 삭제하기 -> 수명시간을 0으로 세팅 후 전달하여 삭제 기능 구현
//      // 제공해주신 MyCookieUtil의 삭제 메서드를 직접 활용합니다.
//      Cookie removeId = MyCookieUtil.createCookieForRemove("userId");
//      Cookie removeCount = MyCookieUtil.createCookieForRemove("visitCount");
//      
//      response.addCookie(removeId);
//      response.addCookie(removeCount);
//      
//      // 이후, /quiz12/count 페이지로 이동 시킨다.
//      return "redirect:/quiz12/count";
//   }
//}