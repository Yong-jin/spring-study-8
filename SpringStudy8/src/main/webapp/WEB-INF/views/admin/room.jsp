<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>관리자페이지</h1>
	<h2>room 객실 상세 페이지</h2>

	<h3>--------여기는 상세페이지입니다.------</h3>
	<p>
		${room.roomId} ${room.buildingName} ${room.roomNumber} ${room.floor}
		${room.maxGuestCount} ${room.viewType}

		<c:choose>
			<c:when test="${room.viewType == 'OCN'}">오션뷰</c:when>
			<c:when test="${room.viewType == 'CTY'}">시티뷰</c:when>
			<c:when test="${room.viewType == 'MOT'}">마운틴뷰</c:when>
		</c:choose>
	</p>
	
	<div>
		<button type="button" onclick=" location.href='/admin/rooms' ">객실목록보기</button>
	</div>
	
</body>
</html>