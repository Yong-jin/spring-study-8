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
	<h1>jstl2</h1>
	
	<p>${msg1}</p>
	<p>${msg2}</p>
	
	
	띄어쓰기                                      띄어쓰기
	띄어쓰기 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 띄어쓰기
	&lt; &gt;
	
<%-- 	<p>${msgXml}</p> --%>
	<p></p>
	
	<c:out value="${msgXml}" escapeXml="true" />
	
	<c:out value="${msg1}" escapeXml="true" />
	<c:out value="${msg2}" escapeXml="true" />
	
	<c:out value="${msg2}" escapeXml="false" />
	
	${msg2}
	
	
	<c:url var="jstl1Url" value="/jstl1" />
	
	<a href="/jstl1">jstl1 페이지 이동</a>
	<a href="/jstl1">jstl1 페이지 이동</a>
	<a href="/jstl1">jstl1 페이지 이동</a>
	
	<br>
	
	<a href="${jstl1Url}">jstl1 페이지 이동</a>
	<a href="${jstl1Url}">jstl1 페이지 이동</a>
	
	<button id="btn">jstl1 버튼</button>
	
<%-- 	<c:redirect url="https://www.naver.com" /> --%>
	
	<script>
	
		//location.href="https://www.naver.com";
	
		document.getElementById('btn').addEventListener('click', ()=>{
			location.href = "/jstl1";
		})
			
	</script>
	
	
	
</body>
</html>


