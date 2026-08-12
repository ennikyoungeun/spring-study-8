package com.app.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.room.Room;
import com.app.service.room.RoomService;

@Controller
public class AdminController {
	//관리자 접근 페이지 (전체 관리자) or (판매자측/ 호텔측 사용자)
	//				운영회사측 전체 관리자 -모든호텔 모든 관리자를 관리하는 //

	@Autowired
	RoomService roomService;
	
	@GetMapping("/admin/registerRoom")
	public String registerRoom() {
		return "/admin/registerRoom";
	}
	
	@PostMapping("/admin/registerRoom")
	public String registerRoomAction(@ModelAttribute Room room) {
		
		//화면으로 부터 입력한 값이 잘 넘어 왓는지 체크
		System.out.println(room);
		
		int result = roomService.saveRoom(room);
		
		//result 값 확인 -> 성공/실패 -> 진행
		
		return "/admin/registerRoom";
	}
}
