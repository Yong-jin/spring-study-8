<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>BMI 결과!!</h1>
	
	<div>
		<p>이름 : ${name}</p>
		<p>키 : ${height}</p>
		<p>몸무게 : ${weight}</p>
		<p>bmi 지수 : ${bmi}</p>
	</div>
	
	<h2>객체</h2>
	<div>
		<p>이름 : ${personBmi.name}</p>
		<p>키 : ${personBmi.height}</p>
		<p>몸무게 : ${personBmi.weight}</p>
		<p>bmi 지수 : ${personBmi.bmi}</p>
	</div>
	
</body>
</html>