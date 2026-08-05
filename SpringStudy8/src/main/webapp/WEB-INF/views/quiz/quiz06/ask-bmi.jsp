<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ask-bmi 페이지</h1>
	
	<h2>입력</h2>
	
	<form action="/quiz06/result-bmi4" method="post">
		이름 : <input type="text" name="name"><br>
		키 :  <input type="text" name="height"><br>
		몸무게 :  <input type="text" name="weight"><br>
		<button type="submit">확인하기</button>
	</form>
	
</body>
</html>