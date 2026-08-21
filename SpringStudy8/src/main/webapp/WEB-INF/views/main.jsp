<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		/*css 코드 */
/* 		h1 { color:red;	} */
	</style>
	
<!-- 	<link href="./main.css" rel="stylesheet"/> -->
<!-- 	<link href="../../resources/main.css" rel="stylesheet"/> -->
	<link href="/css/main.css" rel="stylesheet">
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
	
	<div>
		<img src="/images/ocean.jpg">
	</div>
	<div>
		<img src="https://images.unsplash.com/photo-1786101638791-d183c2e9fad0?q=80&w=684&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D">
	</div>
	
	<script src="/js/main.js"></script>
	<script>
		function goSignup(){
			location.href='/customer/signup';
		}
		
		//javascript 
	</script>
</body>
</html>