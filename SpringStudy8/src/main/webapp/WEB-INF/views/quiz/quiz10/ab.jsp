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
	<p>${fromMsg}</p>
	<p>${orgMsg}</p>
	
	<c:if test="${A == 'A'}">
		<p>${fromB}</p>
	</c:if>
	
	<p>${requestScope.fromB}</p>
	
</body>
</html>