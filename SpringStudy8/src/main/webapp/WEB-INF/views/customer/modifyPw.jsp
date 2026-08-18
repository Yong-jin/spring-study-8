<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사용자 비밀번호 변경</h1>

	<form action="" method="post">
		<input type="hidden" name="id" value="${user.id}"><br>
		${user.name}<br>
<%-- 		사용자 이름 : <input type="text" name="name" value="${user.name}" disabled><br> --%>
		사용자 이름 : <input type="text" name="name" value="${user.name}" readonly><br> 
		<input type="hidden" name="userType" value="${user.userType}">
		
		변경할 비밀번호 : <input type="password" name="pw"><br> <br>
		
		<button type="submit">비밀번호 변경하기</button>
	</form>
	
	
	<br>
	<button type="button" onclick=" location.href='/customer/mypage' ">마이페이지로 돌아가기</button>
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>