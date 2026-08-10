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
	<h1>quiz12 count 페이지</h1>
	
<!-- 	익명인지 -->
<!-- 	어떤아이디를가진 사용자 -->
<%-- 	<p>${requestScope.loginId}</p> --%>
<%-- 	<p>${sessionScope.loginId}</p> --%>
	
	
	
	<c:choose>
<%-- 		<c:when test="${loginId == '' || loginId == null }"> --%>
		<c:when test="${ empty loginId }">
			<p>익명의 사용자 접속중</p>
			<p>로그인 해주세요</p>
		</c:when>
		<c:otherwise>
			<p>${loginId} 님 환영합니다.</p>
		</c:otherwise>
	</c:choose>
	
	
	<p>접속횟수 : ${count}</p>
	
	
	<br><br>
	
	<c:choose>
		<c:when test="${ empty loginId }">
			<a href="/quiz12/login">로그인</a>
		</c:when>
		<c:otherwise>
			<a href="/quiz12/logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
	
	
	<br><br>
	
	
	
</body>
</html>