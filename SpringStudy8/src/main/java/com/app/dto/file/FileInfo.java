package com.app.dto.file;

import lombok.Data;

@Data
public class FileInfo {
	
	String fileName; //실제 저장된 파일 이름 (유니크한 값) PK 
	String originalFileName; // 사용자가 업로드 당시에 사용하던 원래 파일명 erd.png
	String filePath; //파일이 저장된 경로
	String urlFilePath;// 화면에 파일정보접근해서 표시할때,image url 경로로 접근할때 사용할 값
	
	//확장자 
	//파일사이즈
	//업로드 날짜
	//콘텐츠 타입
	//..

}
