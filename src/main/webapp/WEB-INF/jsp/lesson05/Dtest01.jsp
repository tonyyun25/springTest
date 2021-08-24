<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test01</title>
</head>
<body>
	<!-- 1-->
	
  	<c:set var="number1">36</c:set>
	<h4> 첫번째 숫자 : ${number1 }</h4>
	
	<c:set var="number2" value="3" />
	<h4> 두번째 숫자 : ${number2 }</h4>


<%-- 2--%>
	<h4>더하기 : <c:out value="${number1+number2 }" /></h4>
	<h4>빼기 : <c:out value="${number1-number2 }"/></h4>
	<h4>곱하기 : <c:out value="${number1*number2 }"/></h4>
	<h4>나누기 : <c:out value="${number1/number2 }"/></h4>
<!-- 3-->
	<c:out value="<title>core out</title>" />




<!-- 4-->
	<c:set var="average" value="${(number1+number2)  / 2}" />
	
	<c:if test= "${ average >=10 }">
		<h1>${average }</h1>
	</c:if>

	<c:if test="${ average < 10 }">
		<h3>${average }</h3>
	</c:if>


<!-- 5-->
	<c:set var="multiply" value="${ number1 * number2}" />
	<c:if test="${multiply > 100 }" >
		<c:out value="<script>alert('너무 큰 수입니다')</script>" escapeXml="false"/>
		
	</c:if>
	
	



</body>
</html>