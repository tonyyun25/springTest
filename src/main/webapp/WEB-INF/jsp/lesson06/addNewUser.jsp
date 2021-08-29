<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨 찾기 추가하기</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<!--  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 추가하기</h1>
	<!--  <form method="post" action="/lesson06/add_user" id="userForm">-->
		
			<label>제목</label>
			<input type="text" name="name" class="form-control" placeholder="다음" id="nameInput">
			<label>주소</label>
			<input type="text" name="url" class="form-control" placeholder="https://daum.net" id="urlInput">
		
			
			<input type="button" class="btn btn-secondary" id="addBtn" value="추가">
			<!--  <button type="button" class="btn btn-secondary" id="addBtn" >추가</button> -->
			
	<!--   	</form>-->
			
	</div>
	<script>
		
		$(document).ready(function(){
			
			
			//$("#userForm").on("submit",function(e){	
				//e.preventDefault();
			$("#addBtn").on("click", function(e){
				
				var name = $("#nameInput").val();
				var url = $("#urlInput").val();
				
				if(name == null || name == "") {
					alert("제목을 입력하세요")
					return;
				}

				if(url == null || url == "") {
					alert("주소를 입력하세요")
					return;
				} 
				
				if(!url.startsWith("http://") & !url.startsWith("https://")) {
					alert("다시 입력하세요")
					return;
				}	
			
				
				$.ajax({
					type: "post",
					url: "/lesson06/add_user",
					data: {"name":name,"url":url},
					success:function(data) {
						//alert(data);
						if(data.result == "success") {
							alert("추가 성공");
							location.href= "/lesson06/insert_user_view";
							
						} else {
							alert("추가 실패");
						}
					},
					error:function(e) {
						alert("error");
					}
				});
				
			});
		});	
	</script>	


</body>
</html>