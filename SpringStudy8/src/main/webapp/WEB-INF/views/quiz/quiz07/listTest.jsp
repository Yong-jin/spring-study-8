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
	<h1>listTest</h1>


	<c:choose>
		<c:when test="${type == 'str'}">
		</c:when>
		<c:when test="${type == 'member'}">
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>


	<!-- 전달된 msg 값을 반복처리 -->

	<c:if test="${type == 'str'}">
		<c:forEach var="i" begin="1" end="10" step="1">
			<p>${msg}</p>
		</c:forEach>
	</c:if>
	<br>

	<c:if test="${type == 'member'}">
		<c:forEach var="member" items="${memberList}">
			<p>${member.id} ${member.pw} ${member.name}</p>
		</c:forEach>
	</c:if>
</body>
</html>