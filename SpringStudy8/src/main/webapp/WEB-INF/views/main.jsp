<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>main</h1>
	
	<div>
		<button type="button" onclick=" location.href='/customer/signup' ">회원가입</button>
		<button type="button" onclick=" goSignup() ">회원가입</button>
	</div>
	
	<script>
		function goSignup(){
			location.href='/customer/signup';
		}
	</script>
</body>
</html>