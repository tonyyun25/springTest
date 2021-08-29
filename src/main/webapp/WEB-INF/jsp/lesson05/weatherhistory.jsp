<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 정보</title>
	<link rel="stylesheet" href="/lesson05/test05/css/style.css" type="text/html">
	
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
</head>
<body>
	<div id="wrap" class="mt-5 ">
		
		
		<div class="d-flex justify-content-center ">
	
			<jsp:include page="menu.jsp" />
		
			<section class="content">
				<h1>과거 날씨</h1>
				<table class="table  text-center">
					<thead>
						<th>날짜</th>
						<th>날씨</th>
						<th>기온</th>
						<th>강수량</th>
						<th>미세먼지</th>
						<th>풍속</th>
					</thead>
					<tbody>
						<c:forEach var="weather" items="${weatherHistory }">
						<tr>
							<td>
								<fmt:formatDate value="${weather.date }" pattern="yyyy년M월d일" />
							</td>
							<td>
							<c:choose>
								<c:when test="${weather.weather eq '맑음'}">
									 <img src="images/sunny.jpg">
								</c:when>
								<c:when test="${weather.weather eq '비'}">
									 <img src="images/rainy.jpg">
								</c:when>
								<c:when test="${weather.weather eq '흐림'}">
									 <img src="images/cloudy.jpg">
								</c:when>
								<c:when test="${weather.weather eq '구름조금'}">
									 <img src="images/partlyCloudy.jpg">
								</c:when>
								<c:otherwise>
									${weather.weather }
								</c:otherwise>
							
							</c:choose>
							</td>
							<td>${weather.temperatures}ºC</td>
							<td>${weather.precipitation}mm</td>
							<td>${weather.microDust}</td>	
							<td>${weather.windSpeed}km/h</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<hr>
			</section>
			
			
				
		</div>
		
		<jsp:include page="footer.jsp" />
			
		

		
	</div>

	

</body>
</html>	