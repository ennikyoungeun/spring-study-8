<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>quiz12 login page</h1>
	
	<form action="/quiz12/login" method="post">
		id : <input type="text" name="id"> <br>
		pw : <input type="password" name="pw"> <br>
		<button type="submit">로그인</button>
	</form>
</body>
</html>

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	 <h1>로그인 화면</h1>
   
   <form action="${pageContext.request.contextPath}/quiz12/login" method="post">
      ID: <input type="text" name="id"><br>
      PW: <input type="password" name="pw"><br>
      <input type="submit" value="로그인">
   </form>
   
</body>

</body>
</html> --%>