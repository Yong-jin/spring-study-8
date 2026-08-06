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
	<h1>str</h1>
	
	<!-- 고정된 하드코딩 10줄 --> 
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<br>
	
	<!-- 고정텍스트 반복처리 -->
	<c:forEach var="i" begin="1" end="10" step="1">
		<p>스트링 리스트입니다.</p>
	</c:forEach>
	<br>
	
	<!-- 전달된 msg 값을 반복처리 -->
	<c:forEach var="i" begin="1" end="10" step="1">
		<p>${msg}</p>
	</c:forEach>
	<br>
	
	<!-- 넘어온 list를 그대로 반복 출력 -->
	<c:forEach var="str" items="${strList}">
		<p>${str}</p>
	</c:forEach>
	<br>
	
</body>
</html>















