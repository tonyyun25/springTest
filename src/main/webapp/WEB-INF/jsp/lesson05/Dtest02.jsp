<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 2</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>

	<div>
		<h1>Hot 5</h1>
		<table class="table text-center">
			<thead>
				<th>순위</th>
				<th>제목</th>
			</thead>
			<tbody>
				
				<c:forEach var="ranking" items="${musicRanking }" varStatus="status">
				<tr>
					
					<td>
						${status.count }
					
					</td>
					<td>
						${ranking }
					</td>
					
				</tr>
				</c:forEach>
				
			</tbody>
		
		
		</table>
		
		<table class="table text-center">
			<thead>
				<th>이름</th>
				<th>전화번호</th>
				<th>등급</th>
				<th>포인트</th>
			</thead>
			<tbody>
				
				<c:forEach var="member" items="${membership }" varStatus="status">
				<tr>
					<td>${member.name }</td>
					<td>${member.phoneNumber }</td>
					<td>
						<span 
						<c:if test="${ member.grade == 'VIP'}"> 
							class="text-danger"
						</c:if>
						<c:if test="${ member.grade == 'GOLD'}"> 
							class="text-warning"
						</c:if>
						
						
						>
						${member.grade }</span>
						
						
						
						
					</td>
					<td>
						<span
						<c:if test="${member.point  > 5000}">
							class="text-primary"
						</c:if>	
						>
								${member.point }
						</span>
							
						
						
							
					</td>
				
				</tr>
			
				</c:forEach>
			
			</tbody>
		
		</table>
		
		
		
	
	</div>


</body>
</html>