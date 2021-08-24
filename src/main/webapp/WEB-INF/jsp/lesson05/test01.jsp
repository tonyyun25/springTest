<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core 라이브러리</title>
</head>
<body>

	<h3>1. JSTL core 변수</h3>
	<!-- c땡땡 문법에 주석 처리하면 JSP에서 퍼센트 이퀄처럼 에러 발생 -->


	<c:set var="number1" value="36" />
	<c:set var="number2">12 </c:set>
	<h4>첫번째 숫자 : ${number1 }</h4>
	<h4>두번째 숫자 : ${number2 }</h4>

	<hr>
	
	<h3>2. JSTL core 연산</h3>
	<h4>더하기 : ${number1 + number2 }</h4>
	<h4>빼기 : ${number1 - number2 } </h4>
	<h4>곱하기 : ${number1 * number2 }</h4>
	<h4>나누기 : ${number1 / number2 }</h4>
	
	
	<hr>
	
	
	<h3>3. JSTL core out</h3>
	
	<c:out value="<title>core out</title>" /><!-- "/>와 같이 /앞에 공백 안 주면 -->

	<hr>

	<h3>4. JSTL core if</h3>
	
	<c:set var="average" value="${(number1 + number2) / 2 }" />
 	
	<!--<c 콜론 이프 test="${(number1 + number2) / 2 >= 10 }">
	반복되는 것은 위에서 변수 만들어 처리해 부하 줄여준다-->
	
	<c:if test="${average >= 10 }" >
		<h1>${average }</h1>
	
	</c:if>
	
	<c:if test="${average < 10 }" >
		<h3>${average }</h3>
	
	</c:if>
	
	
	
	
	<h3>5. JSTL core if</h3>
	<!--<c 콜론 이프 test="false">공백을 주는 순간 true 또는 false 뒤에 공백이 붙어 참, 거짓으로 판단 안 됨-->
	
	<c:if test="${number1 * number2 > 100 }">
		<!--  <script>alert(너무 큰 수입니다.);</script>
		따옴표 안에 따옴표는 자바 따옴표로 바꿔야 함 -->
		<c:out value="<script>alert('너무 큰 수입니다.');</script>" escapeXml="false" />
	
	</c:if>


</body>
</html>