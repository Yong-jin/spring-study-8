<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>관리자 페이지</h1>
	<h2>사용자(User) 추가</h2>
	
<!-- 	모든 값을 입력받는 경우 -->
<!-- 	<form action="" method="post"> -->
<!-- 		사용자아이디 : <input type="text" name="id"><br> -->
<!-- 		사용자 이름 : <input type="text" name="name"><br> -->
<!-- 		사용자 비번 : <input type="password" name="pw"><br> -->
<!-- 		<select name="userType"> -->
<!-- 			<option value="ADM">관리자</option> -->
<!-- 			<option value="CUS">사용자</option> -->
<!-- 		</select> <br> -->
<!-- 		<button type="submit">등록하기</button> -->
<!-- 	</form> -->
	
	
<!-- 	관리자가 필요한 값만 사용자로 임시 등록 -->
	<form action="" method="post" id="form_add">
		사용자아이디 : <input type="text" name="id" id="input_id"><br>
		사용자 이름 : <input type="text" name="name" required="required"><br>
		<button type="submit">등록하기</button>
	</form>
	
	
	<script>
			
		const form_add = document.getElementById('form_add');
		
		form_add.addEventListener('submit', (event)=>{
			
			// 기본 진행 submit 중지
			event.preventDefault();
			
			// 유효성 검증 
			let id = document.getElementById('input_id').value;
			id = id.trim(); //공백제거
			
			if( id == '' ){
				alert('id 공백임 필수입력');
				return;
			}
			
			// id 길이제한 3~15 자리
			if( id.length < 3  ||  id.length > 15){
				alert('id 길이를 확인해주세요(3~15 자리 가능)');
				return ;
			}
			
			// 정상 통과인경우 -> submit 수행
			form_add.submit();
		})
		
	</script>
	
</body>
</html>


























