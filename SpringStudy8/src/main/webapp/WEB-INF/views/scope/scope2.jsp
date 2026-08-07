<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>scope2</h1>
	
	<p>${requestMsg}</p>
	<p>${requestScope.requestMsg}</p>
	
	<p>${sessionMsg}</p>
	<p>${sessionScope.sessionMsg}</p>
	
	<p>${appMsg}</p>
	<p>${applicationScope.appMsg}</p>
	
	
</body>
</html>