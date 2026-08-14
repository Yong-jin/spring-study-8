<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>signup 회원가입 페이지</h1>

<!-- 	모든 값을 입력받는 경우 -->
	<form action="" method="post">
		사용자아이디 : <input type="text" name="id"><br>
		사용자 이름 : <input type="text" name="name"><br>
		사용자 비번 : <input type="password" name="pw"><br>
		 <br>
		 <!-- "사용자"회원가입 userType -> 서버에서 CUS로 세팅  -->
<!-- 		 <input type="hidden" name="userType" value="CUS"> -->
		<button type="submit">등록하기</button>
	</form>
</body>
</html>