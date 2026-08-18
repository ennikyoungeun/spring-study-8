<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
</head>
<body>

    <h1>비밀번호 변경</h1>
    
    <!-- 컨트롤러의 @PostMapping("/customer/modifyPw")로 데이터 전송 -->
    <form action="/customer/modifyPw" method="post">
        <p>
            <label for="newPassword">변경할 비밀번호 : </label>
     
            <input type="password" id="newPassword" name="pw" required placeholder="새 비밀번호 입력">
        </p>
        
        <p>
            <button type="submit">비밀번호 변경하기</button>
            <a href="/customer/mypage">마이페이지로 돌아가기</a>
        </p>
    </form>

</body>
</html>
