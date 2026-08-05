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
	<h1>jstl1</h1>
	
	<p>${msg}</p>
	
	<p><c:out value="${msg}"/></p>
	
	
	<p>${product.id}</p>
	<p>${product.name}</p>
	<p>${product.price}</p>
	
	
	<p>${productList[0].id} ${productList[0].name} ${productList[0].price}</p>
	<p>${productList[1].id} ${productList[1].name} ${productList[1].price}</p>
	<p>${productList[2].id} ${productList[2].name} ${productList[2].price}</p>
	
	
<!-- 	arr.map( ()=>{ })        for(int i=1; i<=5; i++) -->
	
	<c:forEach var="i" begin="1" end="5" step="1">
		<p>forEach 반복문 내부 ${i} </p>
		<p> ${productList[i-1].id} </p>
	</c:forEach>
	
	
<!-- 	for(Product p : productList) -->
	<c:forEach var="p" items="${productList}">
		<p>${p.id} ${p.name} ${p.price}</p>
	</c:forEach>
	
	<c:choose>
		<c:when test="${drinkType == 'coffee'}">
			<p>커피를 선택함</p>		
		</c:when>
		<c:when test="${drinkType == 'tea'}">
			<p>차를 선택함</p>		
		</c:when>
		<c:otherwise>
			<p>그외에 다른 음료</p>
		</c:otherwise>
	</c:choose>
	
	
<!-- 	or ||  -->
	<c:choose>
		<c:when test="${score >= 300 && score < 500 }">
			<p>점수 중하</p>
		</c:when>
		<c:when test="${score >= 500 and score < 1000 }">
			<p>점수 중상</p>
		</c:when>
		<c:otherwise>
			<p>점수 범위 몇점</p>
		</c:otherwise>
	</c:choose>
	
	<c:if test="${userType == 'admin'}">
		<p>관리자만 볼수있는 메뉴</p>
	</c:if>
	
	<c:if test="${isLogin == true }" >
		<button>로그아웃 버튼</button>
	</c:if>
	
	<c:if test="${isLogin == false }" >
		<button>로그인 버튼</button>
	</c:if>
	
	
</body>
</html>







