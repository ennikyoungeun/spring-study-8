<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <h1> 관리자 페이지 </h1>
   <h2>rooms 객실 목록</h2>
   
      <form action="${pageContext.request.contextPath}/admin/rooms" method="get">
         <h3>객실 필터 검색</h3>
         
         <label for="buildingName">건물명: </label>
         <input type="text" id="buildingName" name="buildingName" value="${roomSearchCondition.buildingName}" placeholder="예: a,q">
         
        <br>
         
         <label for="viewType">뷰 선택: </label>
         <select id="viewType" name="viewType">
         
         	<option value="">--선택--</option>
            <option value="OCN" <c:if test="${roomSearchCondition.viewType == 'OCN'}">selected</c:if>>오션뷰</option>
            <option value="CTY" <c:if test="${roomSearchCondition.viewType == 'CTY'}">selected</c:if>>시티뷰</option>
            <option value="MOT" <c:if test="${roomSearchCondition.viewType == 'MOT'}">selected</c:if>>마운틴뷰</option>
         </select>  
         <button type="submit">검색</button>
      </form>
   </div>
   <hr> 
   <hr>
   
   <div>
      <button id="btn_registerRoom">객실 추가하기</button>
   </div>

   <c:forEach var="room" items="${roomList}">
   
      <p>
      <a href="/admin/room/${room.roomId}">
         ${room.roomId} ${room.buildingName} ${room.roomNumber} ${room.floor} ${room.maxGuestCount} 
   
         <c:choose>
            <c:when test="${room.viewType == 'OCN'}">오션뷰</c:when>
            <c:when test="${room.viewType == 'CTY'}">시티뷰</c:when>
            <c:when test="${room.viewType == 'MOT'}">마운틴뷰</c:when>
            <c:otherwise>${room.viewType}</c:otherwise>
         </c:choose>
      </a>
      
      <button type="button" onclick=" removeRoom(${room.roomId}) ">삭제하기</button>
      <button type="button" onclick=" modifyRoom(${room.roomId}) ">수정하기</button>
      
      </p>
   
   </c:forEach>
   
   <script>
      document.getElementById('btn_registerRoom').addEventListener('click', ()=>{
         location.href = "/admin/registerRoom";
      })
      
      function removeRoom( roomId ){
         if (confirm("정말 삭제하시겠습니까?")){
            location.href = '/admin/removeRoom?roomId=' + roomId;
         }
      }
      
      function modifyRoom( roomId ){
         location.href = '/admin/modifyRoom?roomId=' + roomId;
      }
   </script>

</body>
</html>