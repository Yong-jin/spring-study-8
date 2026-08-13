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
	
	<c:forEach var="room" items="${roomList}">
			
		<p>
			${room.roomId} ${room.buildingName} ${room.roomNumber} ${room.floor} ${room.maxGuestCount} ${room.viewType}
			
			<c:choose>
				<c:when test="${room.viewType == 'OCN'}">오션뷰</c:when>
				<c:when test="${room.viewType == 'CTY'}">시티뷰</c:when>
				<c:when test="${room.viewType == 'MOT'}">마운틴뷰</c:when>
			</c:choose>
		</p>
		
	</c:forEach>
</body>
</html>