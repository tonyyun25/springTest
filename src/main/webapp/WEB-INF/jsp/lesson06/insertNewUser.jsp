<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 목록</title>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 목록</h1>
		<table class="table">
			<thead>
				<th>No.</th>
				<th>이름</th>
				<th>주소</th>
			
			</thead>
			
			<c:forEach var="favorite" items="${favoriteBO.getFavoriteList() } " varStatus="status">
			<tbody>
				<tr>
					<td>${status.count }</td>
					<td>${favorite.name }</td>
					<td>${favorite.url }</td>
				</tr>
				
			
			
			</tbody>
			</c:forEach>
		
		</table>
	
	
	</div>
</body>
</html>