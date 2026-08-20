<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>signup 회원가입 페이지</h1>

<!-- 	모든 값을 입력받는 경우 -->
	<form action="" method="post">
		사용자아이디 : <input type="text" name="id" id="inputId"><br>
		<button type="button" id="btn_checkDupId">중복체크</button>
		<p id="checkDupIdMsg"></p>
		
		사용자 이름 : <input type="text" name="name"><br>
		사용자 비번 : <input type="password" name="pw"><br>
		 <br>
		 <!-- "사용자"회원가입 userType -> 서버에서 CUS로 세팅  -->
<!-- 		 <input type="hidden" name="userType" value="CUS"> -->
		<button type="submit">등록하기</button>
	</form>
	
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/4.0.0/jquery.min.js" integrity="sha512-8LENNbXmzI/Gbj+OwXmqR6V4QaUAw0/porPzy1+dQoJqC0JPHedWoe0DDOTL2uHA5XXJyIsPtiMHH86pVlay6A==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script>
		
		//중복체크 버튼을 클릭 -> input태그에 입력한 아이디 값 확인 -> 서버로 ajax 요청 (아이디) -> 서버 중복체크 확인
		// -> 중복체크 결과 클라이언트에 응답 -> (클라이언트) 응답 값 확인 -> 화면에 표시
		
		const btn_checkDupId = document.getElementById("btn_checkDupId");
		const p_checkDupIdMsg =  document.getElementById("checkDupIdMsg");
		
		
		btn_checkDupId.addEventListener("click", ()=>{
			//중복체크 누르면
			
			let inputId = document.getElementById('inputId').value;
			console.log(inputId);
			
			
			
			// 1) 단순 텍스트로 id 요청 -> 응답 단순 텍스트 Y/N
			
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/customer/checkDupId",
				headers : {
					"Content-type":"application/json"
				},
				data: inputId,         //서버에 보낼 데이터 (파라미터로 전달할 값)
				dataType: "text",
				success: function(result){
					console.log('ajax sucess');
					console.log(result);  //  "Y"  "N"
					
					if(result == 'Y'){
						p_checkDupIdMsg.textContent = "중복된 아이디입니다.";
						p_checkDupIdMsg.style.color = "red";
					} else {
						p_checkDupIdMsg.textContent = "사용 가능한 아이디입니다.";
						p_checkDupIdMsg.style.color = "green";
					}
					
				},
				error: function(error){
					console.log(error);
				}
			})
			
		})
		
		
		
		
		
	
	</script>
	
</body>
</html>
















