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
	<h1>관리자페이지 객실 정보 수정</h1>
	<h2>객실수정</h2>
	
	<form action="" method="post">
		<input type="hidden" name="roomId" value="${room.roomId}">
	
		<label>건물/동 이름<input type="text" name="buildingName" value="${room.buildingName}"></label><br>
		<label>호실번호<input type="text" name="roomNumber" value="${room.roomNumber}"></label><br>
		<label>층수<input type="text" name="floor"  value="${room.floor}"></label><br> 
		<label>최대숙박인원<input type="text" name="maxGuestCount"  value="${room.maxGuestCount}"></label><br>

		<h4>뷰타입</h4>
		<select name="viewType">
			<option value="OCN" <c:if test="${room.viewType == 'OCN'}">selected</c:if>   >오션뷰</option>
			<option value="CTY" <c:if test="${room.viewType == 'CTY'}">selected</c:if>   >시티뷰</option>
			<option value="MOT" <c:if test="${room.viewType == 'MOT'}">selected</c:if>   >마운틴뷰</option>
		</select> <br>
		<button type="submit">수정</button>
	</form>

	<div>
		<button type="button" onclick=" location.href='/admin/rooms' ">객실목록보기</button>
	</div>
	
</body>
</html>