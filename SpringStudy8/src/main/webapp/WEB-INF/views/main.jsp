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
	<h1>main</h1>
	
	<div>
	
		<c:if test="${loginUserId == null }">
			<button type="button" onclick=" location.href='/customer/signup' ">회원가입</button>
			<button type="button" onclick=" goSignup() ">회원가입</button>
			
			<br>
			<button type="button" onclick=" location.href='/customer/signin' ">로그인</button>
		</c:if>
	
		<c:if test="${loginUserId != null }">
			<p>${loginUserId} 님 환영합니다. </p>
			<button type="button" onclick=" location.href='/customer/mypage' ">마이페이지</button>
			<button type="button" onclick=" location.href='/customer/signout' ">로그아웃</button>
		</c:if>
		
		
	</div>
	
	<script>
		function goSignup(){
			location.href='/customer/signup';
		}
	</script>
</body>
</html>