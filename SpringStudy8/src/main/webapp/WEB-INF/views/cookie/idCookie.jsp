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
	<h1>id cookie</h1>
	
	<!-- 	<form action="/idCookie" method="post"></form> -->
	<form action="" method="post">
		아이디 : <input type="text" name="id" value="${remember}"><br>
		비번 : <input type="password" name="pw"><br>
		아이디기억 
		<input type="checkbox" name="remember" value="true" <c:if test="${remember != null}">checked</c:if> > <br>
		<button type="submit">로그인</button>
	</form>
</body>
</html>