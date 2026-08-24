<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.error-msg {
		color:red;
	}
</style>

</head>
<body>
	
	<h1>signup 회원가입 페이지</h1>

<!-- 	모든 값을 입력받는 경우 -->
	<form action="" method="post">
		사용자아이디 : <input type="text" name="id" id="inputId" value="${user.id}"><br>
		
		
		<spring:hasBindErrors name="user">
			<c:if test="${errors.hasFieldErrors('id') }">
				<p class="error-msg">아이디 필수 입력!!</p>
				<p class="error-msg">${errors.getFieldError('id').defaultMessage } </p>
			</c:if>
		</spring:hasBindErrors>
		
		<c:if test="${userValidError.id != null}">
			<p class="error-msg">${userValidError.id}</p>
		</c:if>
		
		
		<button type="button" id="btn_checkDupId">중복체크</button>
		<button type="button" id="btn_checkDupIdJson">중복체크Json</button>
		<p id="checkDupIdMsg"></p>
		
		사용자 이름 : <input type="text" name="name" value="${user.name}"> <br>
		
		<c:if test="${userValidError.name != null}">
			<p class="error-msg">${userValidError.name}</p>
		</c:if>
		
		
		
		
		사용자 비번 : <input type="password" name="pw" value="${user.pw}"><br>
		
		<spring:hasBindErrors name="user">
			<c:if test="${errors.hasFieldErrors('pw') }">
				<p class="error-msg">비밀번호 길이확인!!!!</p>
				<p class="error-msg">${errors.getFieldError('pw').defaultMessage } </p>
			</c:if>
		</spring:hasBindErrors>
		
		
		<c:if test="${userValidError.pw != null}">
			<p class="error-msg">${userValidError.pw}</p>
		</c:if>
		
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
		
		
		
		//2) Json 포맷으로 송수신
		
		const btn_checkDupIdJson = document.getElementById("btn_checkDupIdJson");
		
		btn_checkDupIdJson.addEventListener("click", ()=>{
			//중복체크 누르면
			
			let inputId = document.getElementById('inputId').value;
			console.log(inputId);
			
			//2) json 포맷으로 데이터 준비
			
			// 요청할 데이터 javascript object 타입으로 준비
			
			// js obj -> JSON format text	  JSON.stringify
			// JSON format text -> js obj     JSON.parse
			let obj = {
					"id":inputId,
					"type":"CUS"
			};
			
			let jsonText = JSON.stringify(obj); //서버에 보낼 json text
			
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/customer/checkDupIdJson",
				headers : {
					"Content-type":"application/json"
				},
				data: jsonText,         //서버에 보낼 데이터 (파라미터로 전달할 값)
 				dataType: "json",       //서버에서 응답으로 보내는 포맷도 json 으로 작업
//				dataType: "text",       //서버에서 응답으로 보내는 포맷도 json 으로 작업
				success: function(result){
					console.log('ajax sucess');
					console.log(result);  //  "Y"  "N"
					
					//dataType:text -> text 로 인식 (json format 되어있는) 
					//dataType:json -> 응답이 json 인지 -> (javascript object 변환) -> result 주입
					
					//dataType:text result 들어있는건? json format으로 맞게 작성되어있는 텍스트(문자열)
					//텍스트 -> json 변환 (파싱)
					//let jsObj = JSON.parse(result);
					
					
					//dataType:json  result 들어있는건?  이미 텍스트를 json 파싱해서 javascript object 변환해서 주입
					let jsObj = result;
					console.log(jsObj.header.resultCode);
					console.log(jsObj.header.resultMessage);
					console.log(jsObj.body);
					
					if(jsObj.body == 'Y'){
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
















