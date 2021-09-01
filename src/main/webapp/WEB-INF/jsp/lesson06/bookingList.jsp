<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>예약 목록 보기</title>
		<link rel="stylesheet" href="/lesson06/test01/css/style.css" type="text/css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
		
		<!--  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	</head>
	<body>
		<div class="" id="wrap">
	    	<header class="mt-4 ">
	           <div class="text-center display-4">통나무 펜션</div>
	       
	           <nav class="mt-4 ">
	               <ul class="nav nav-fill">
	                   <li class="nav-item"><a class="nav-link " href="#">펜션소개</a></li>
	                   <li class="nav-item"><a class="nav-link " href="#">객실보기</a></li>
	                   <li class="nav-item"><a class="nav-link"  href="#">예약안내</a></li>
	                   <li class="nav-item"><a class="nav-link " href="#">커뮤니티</a></li>
	               </ul>
	           </nav>
	
	        </header>
	        
	        <section class=" content">
	        	
	        	
		        	<h2 class="text-center">예약 목록 보기</h2>
		        	
		        	<table class="table mt-3 text-center">
		        		<thead>
		        			<th>이름</th>
			        		<th>예약날짜</th>
			        		<th>숙박일수</th>
			        		<th>숙박인원</th>
			        		<th>전화번호</th>
			        		<th>예약상태</th>
			        		<th></th>
			        	</thead>
		        	
		        		<tbody>
		        			<c:forEach var="bookList" items="${bookListbyLine }">
		        			<tr class="font-weight-bold">
		        				<td>${bookList.name }</td>
		        				
		        				<td>
		        					<fmt:formatDate value="${bookList.date }" pattern="yyyy년M월d일" />
		        				</td>
		        				
		        				<td>${bookList.day }</td>
		        				<td>${bookList.headcount }</td>
		        				<td>${bookList.phoneNumber }</td>
		        				<td>
		        					<c:choose>
		        						<c:when test="${bookList.state == '대기중'}">
		        							<span class="text-info">${bookList.state }</span>
		        						</c:when>
		        						<c:when test="${bookList.state eq '확정'}">
		        							<span class="text-success">${bookList.state }</span>
		        						</c:when>
		        						<c:otherwise>
		        							${bookList.state }
		        						</c:otherwise>
		        					
		        					</c:choose>
		        				</td>
		        				<td><button type="button" class="btn btn-sm btn-danger deleteBtn" data-bookList-id="${bookList.id }">삭제</button></td>
		        			</tr>
		        			</c:forEach>
		        		</tbody>
		        		
		        		<script>
		        			$(document).ready(function(){
		        				$(".deleteBtn").on("click",function(){
		        					//alert("OK");
		        					var bookListId = $(this).data("bookList-id");
		        					// 값을 잘 꺼내왔는지 alert을 통해 확인
		        					alert(bookListId);
		        					
		        					
		        					//var bookListId = $(this).attr("bookList-id");
		        					
		        					$.ajax({
		        						type:"get",
		        						url:"/lesson06/deleteList",
		        						data:{"bookListId":bookListId},
		        						
		        						success:function(data) {
		        							
		        							if(data.result == "success") {
		        								alert("삭제 성공");
		        							} else {
		        								alert("삭제 실패");
		        							}
		        							
		        							
		        						}
		        						,error:function(e) {
		        							alert("error");
		        						}
		        						
		        						
		        					});
		        					
		        					
		        				});
		        				
		        				
		        				
		        			});
		        		
		        		
		        		</script>
		        		
		        		
		        		
		        		
		        		
		        		
		        	
		        	</table>
		        
	        
	        </section>
	        
	        <footer class="mt-3 ml-4 " >
	            <!--d-flex align-items-center는 내가 반영시킴-->
	            <address>
	                
	                제주특별자치도 제주시 애월읍 <br>
	                사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목 <br>
	                Copyright 2025 tongnamu All rights reserved
	                
	            </address>
	        </footer>
	        
	    </div>   
	</body>
	
	
	
</html>