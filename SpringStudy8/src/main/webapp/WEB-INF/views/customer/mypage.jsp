<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>사용자 마이페이지</h1>
	
	<p>아이디 : ${user.id}</p>
	<p>이름 : ${user.name}</p>
	<p>
		<a href="/main">메인페이지로 이동</a>
	</p>
	
	<button id="btn_modifyPw">비밀번호 변경</button>
	
	
	<div>
		<h2>프로필 이미지</h2>
		
<!-- 		<form action="/customer/profile" method="post" enctype="multipart/form-data"> -->
		<form action="/customer/profiledto" method="post" enctype="multipart/form-data">
			<input type="hidden" name="id" value="${user.id}">
			<input type="hidden" name="name" value="${user.name}">
			<input type="file" name="profileImage">
			<button type="submit">등록하기</button>
		</form>
		
	</div>
	
	
	
	
	<script>
		document.getElementById('btn_modifyPw').addEventListener('click',()=>{
			location.href = "/customer/modifyPw";
		})
	</script>
	
</body>
</html>