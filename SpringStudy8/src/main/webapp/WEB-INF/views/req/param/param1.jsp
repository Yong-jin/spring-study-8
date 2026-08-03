<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>param1</h1>
	
	<div>
		<form action="/request03/param2" method="post">
			name : <input type="text" name="name" ><br>
			count : <input type="text" name="count" ><br>
			<button type="submit">전송</button>
		</form>
			
	</div>
	
	<div>
		<a href="/request03/param2?name=abc&count=123">param2 경로로 get 요청</a>
		
		http://localhost:8080/request03/param2?name=abc&count=123
		<br>
		/request03/param2?name=abc&count=123
		
	</div>
	
</body>
</html>