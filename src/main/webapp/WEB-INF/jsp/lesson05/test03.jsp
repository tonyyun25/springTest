<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>득표</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<fmt:setLocal value="ko_KR" scope="session" />
	<%--만약 카드 영수증 원화 표시 안 나오면 위 한 줄 표시해야 함. en_US --%>
	<div class="container text-center">
	
		<table class="table">
			<thead>
				<th>기호</th>
				<th>득표수</th>
				<th>득표율</th>
			</thead>
			<tbody>
				<c:forEach var="candidate" items="${candidates }" varStatus="status" >
				<tr>
					<td>${status.count }</td>
					<td><fmt:formatNumber value="${candidate }"  /></td>
					<td><fmt:formatNumber value="${candidate / 1000000}" type="percent" /></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
		<h2>카드 영수증</h2>
		
		<table class="table">
			<thead>
				<tr>
					<th>사용처</th>
					<th>가격</th>
					<th>사용 날짜</th>
					<th>할부</th>
				</tr>
			</thead>
			<tbody>
				<!--  
				<c:forEach var="cardBill" items="${cardBills }" >
					<tr>
						<td>${cardBill.store }</td>					
						<td><fmt:formatNumber value="${cardBill.pay }" type="currency" /></td>
						<td>
							<fmt:parseDate value="${cardBill.date }" pattern="yyyy-mm-dd" var="then" />
							<fmt:formatDate value="${then }" pattern="yyyy년 m월 dd일" />
							
						</td>
						<td>${cardBill.installment }</td>
					</tr>	
					
				</c:forEach>	
				-->	
				<c:forEach var="cardBill" items="${cardBills }" >
					<fmt:parseDate value="${cardBill.date }" pattern="yyyy-MM-dd" var="date" />
				<tr>
					<td>${cardBill.store }</td> 					
					<td><fmt:formatNumber value="${cardBill.pay }" type="currency" /></td>
					<td>
						
						<fmt:formatDate value="${date }" pattern="yyyy년 M월 d일" />
						
					</td>
					<td>${cardBill.installment }</td>
				</tr>	
					
				</c:forEach>		
					
				
			</tbody>
		</table>
		
		
	</div>
</body>
</html>