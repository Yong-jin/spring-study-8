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
	<h1>관리자페이지</h1>
	<h2>rooms 객실 목록</h2>
	
	<div>
		<button id="btn_registerRoom">객실 추가하기</button>
	</div>
	
	<c:forEach var="room" items="${roomList}">
			
		<p>
			<a href="/admin/room/${room.roomId}">
				${room.roomId} ${room.buildingName} ${room.roomNumber} ${room.floor} ${room.maxGuestCount} ${room.viewType}
				
				<c:choose>
					<c:when test="${room.viewType == 'OCN'}">오션뷰</c:when>
					<c:when test="${room.viewType == 'CTY'}">시티뷰</c:when>
					<c:when test="${room.viewType == 'MOT'}">마운틴뷰</c:when>
				</c:choose>
			</a>
			
<%-- 			<button type="button" onclick=" location.href= '/admin/removeRoom?roomId=${room.roomId}'">삭제하기</button> --%>
			<button type="button" onclick=" removeRoom(${room.roomId}) ">삭제하기</button>
			
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
		
		
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>