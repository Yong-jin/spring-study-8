package com.app.util;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;

import com.app.controller.study.rs.APILogin;
import com.app.dto.user.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

//JWT 토큰 관련 처리 담당 클래스
public class JwtProvider {
	
	
	//비밀키 설정
	private static final String SECRET_KEY = "thisissecretkeyforjwtreactconnectwithspringserver123456123";
	
	// token 만료시간 설정
	private static final long ACCESS_TOKEN_EXPIRATION = 1000 * 60 * 30; //30분 
	private static final long REFRESH_TOKEN_EXPIRATION = 1000 * 60 * 60 * 24 * 7; // 7일
	
	
	//시크릿키 생성   (비밀키 변환 -> 인코딩 -> 키 생성) 
	private static SecretKey getSigningKey() {
		return Keys.hmacShaKeyFor( SECRET_KEY.getBytes(StandardCharsets.UTF_8) );
	}
	
	/*
	 * AccessToken 생성
	 * 현재 로그인 처리할 사용자의 아이디를 기준으로 추가해서 토큰 생성
	 */
	public static String createAccessToken(String userId) {
		
		Date now = new Date(System.currentTimeMillis());  //시간
		//발급시간
		
		// SecretKey binary 데이터
		// 문자열을 Base64 Encoding 변환
		
		// 토큰에 보관할 회원 ID 
		// 비공개 클레임
		Claims claims = Jwts.claims().add("userId", userId).build();  
		// AccessToken  긴 String 
		return Jwts.builder()
					.header()
					.add("typ", "JWT")
					.and()
					.subject("accessToken")
					.issuedAt(now) //발급시간
					.issuer("spring server")
					//.expiration( new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION) )
					.expiration( new Date( now.getTime()  + ACCESS_TOKEN_EXPIRATION ) )  //만료시간
					.claims(claims)
					.signWith(getSigningKey(), Jwts.SIG.HS256)
					.compact();  //token string
	}
	
	public static String createAccessToken(APILogin apiLogin) {
		return createAccessToken(apiLogin.getId());
	}
	
	public static String createAccessToken(User user) {
		return createAccessToken(user.getId());
	}
	
	
	
	
	// 토큰의 유효성 검증
	public static boolean isValidToken(String token) {
		
		// return  유효여부 (true/false) 
		// return 상태코드 -> 만료, 위변조, 유효X   
		// 			exception -> throw 
		
		// 인증된 (Authenticated)
		// 만료된 (Expired)
		// 유효하지않다 (Invalid)
		
		//------------------------
		try {
			Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token);
			return true;  //정상적인 토큰 인증 완료
		} catch (MalformedJwtException e) {
			System.out.println("유효하지 않은 토큰: " + e.getMessage());
		} catch (ExpiredJwtException e) {
			System.out.println("만료된 토큰: " + e.getMessage());
		} catch (UnsupportedJwtException e) {
			System.out.println("지원하지 않는 토큰: " + e.getMessage());
		} catch (SignatureException e) {
			System.out.println("서명 예외 토큰: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("토큰 검증 실패: " + e.getMessage());
		}
		
		return false;
	}
	
	
	// 토큰 해석 -> 토큰에 claims 에 담아둔 로그인한 사용자 id 를 추출 
	public static String getUserIdFromToken(String token) { 
		
		String userId = null;
		
		try {
			userId = Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token)
						.getPayload().get("userId", String.class);
		} catch (ExpiredJwtException e) {
			System.out.println("만료된 토큰: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("토큰 검증 실패: " + e.getMessage());
		}
		
		System.out.println("토큰 해석해서 추출한 userId : " + userId);
		
		return userId;
	}
	
	
	// request 에서 토큰값 추출
	public static String extractToken(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		// "Bearer 토큰값"
		System.out.println(bearerToken);
		
		if( bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		
		return null;
	}
	
	
}


















