<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
</head>
<body>

    <h1>사용자 비밀번호 변경</h1>

	<form action="" method="post">
		<input type="hidden" name="id" value="${user.id}"><br>
		${user.name}<br>
<%-- 		사용자 이름 : <input type="text" name="name" value="${user.name}" disabled><br> --%>
		사용자 이름 : <input type="text" name="name" value="${user.name}" readonly><br> 
		<input type="hidden" name="userType" value="${user.userType}">
		
		변경할 비밀번호 : <input type="password" name="pw"><br> <br>
		
		<button type="submit">비밀번호 변경하기</button>
	</form>
    
    <!-- 컨트롤러의 @PostMapping("/customer/modifyPw")로 데이터 전송 -->
  <!--   <form action="/customer/modifyPw" method="post">
        <p>
            <label for="newPassword">변경할 비밀번호 : </label>
     
            <input type="password" id="newPassword" name="pw" required placeholder="새 비밀번호 입력">
        </p>
        
        <p>
            <button type="submit">비밀번호 변경하기</button>
            <a href="/customer/mypage">마이페이지로 돌아가기</a>
        </p>
    </form> -->

</body>
</html>
