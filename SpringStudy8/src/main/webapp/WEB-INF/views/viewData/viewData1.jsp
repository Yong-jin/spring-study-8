<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>viewData1 페이지</h1>
	
	<%=request.getAttribute("store")%>
	<%=request.getAttribute("menu")%>
	
	<div>
		<p>${store}</p>
		<p>${menu}</p>
	</div>
	
	
	
	
	
	
</body>
</html>