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
	<h1>quiz08 member</h1>
	
	<h2>서버에서 이미 필터링해서 보여줄 Member 데이터만 넘겨줬으니, 그대로 출력만 </h2>
		
	<c:forEach var="m" items="${viewMemberList}">
		<p>${m.id} ${m.pw} ${m.name} ${m.type} </p>
	</c:forEach>
	
	<h2>서버에서 전체 리스트 넘겨주고, view 에서 jstl 활용 구분해서 출력 </h2>
	
	<c:choose>
		<c:when test="${auth == 'basic' }">
			<c:forEach var="m" items="${memberList}">
				<c:if test="${m.type == 'basic'}">
					<p>${m.id} ${m.pw} ${m.name} ${m.type} </p>
				</c:if>
			</c:forEach>
		</c:when>
		<c:when test="${auth == 'manager' }">
			<c:forEach var="m" items="${memberList}">
				<c:if test="${m.type == 'manager'}">
					<p>${m.id} ${m.pw} ${m.name} ${m.type} </p>
				</c:if>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<c:forEach var="m" items="${memberList}">
				<p>${m.id} ${m.pw} ${m.name} ${m.type} </p>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	
	<h2>로직 개선 1</h2>
	
	<c:choose>
		<c:when test="${auth == 'basic' || auth == 'manager'}">
			<c:forEach var="m" items="${memberList}">
				<c:if test="${m.type == auth}">
					<p>${m.id} ${m.pw} ${m.name} ${m.type} </p>
				</c:if>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<c:forEach var="m" items="${memberList}">
				<p>${m.id} ${m.pw} ${m.name} ${m.type} </p>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	
	<h2>로직 개선 2</h2>
	
	
	<c:forEach var="m" items="${memberList}">
		<c:if test="${m.type == auth || auth == 'admin' }">
			<p>${m.id} ${m.pw} ${m.name} ${m.type} </p>
		</c:if>
	</c:forEach>
	
	
	
	
	
</body>
</html>