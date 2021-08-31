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
			<input type="text" name="name" class="form-control" placeholder="다음" id="titleInput">
			<label>주소</label>
			<div class="d-flex">
				<input type="text" name="url" class="form-control" placeholder="https://daum.net" id="urlInput">
				<button type="button" class="btn btn-primary" id="isDuplicateCheck">중복확인</button>
			</div>
			<div class="text-danger d-none" id="duplicateCheck"><small>중복된 url입니다</small></div>
			<div class="text-success d-none" id="noneDuplicateCheck"><small>사용가능한 url입니다</small></div>
			
			<!-- <input type="button" class="btn btn-secondary" id="addBtn" value="추가"> -->
			 <button type="button" class="btn btn-secondary form-control" id="addFavorite" >추가</button> 
			
	<!--   	</form>-->
			
	</div>
	<script>
		
		$(document).ready(function(){
			
			
			//$("#userForm").on("submit",function(e){	
				//e.preventDefault();
				
			var isChecked = false;	
			var isDuplicate = true;	
				
			$("#addFavorite").on("click", function(){
				
				var title = $("#titleInput").val();
				var url = $("#urlInput").val();
				
				if(title == null || title == "") {
					alert("제목을 입력하세요")
					return;
				}

				if(url == null || url == "") {
					alert("주소를 입력하세요")
					return;
				} 
				
				// http:// 또는 https://가 아니면 잘못된 url. &가 아니라 && 이다.
				
				//if(!url.startsWith("http://") && !url.startsWith("https://")) {
				if(!(url.startsWith("http://") || url.startsWith("https://"))) {
					alert("잘못된 주소 형식입니다.")
					return;
				}	
			
				
				if(isChecked == false) {
					alert("중복체크를 진행해 주세요");
					return;
				}
				
				if(isDuplicate == true) {
					alert("중복된 url은 입력할 수 없습니다");	
					return;
				
				}
				
				$.ajax({
					type: "post",//주소 정보가 넘어가야 하는데 주소 뒤에 주소가 있으면 보기 안 좋아 post로 함
					url: "/lesson06/add_favorite",
					data: {"name":title,"url":url},
					success:function(data) {
						//alert(data);
						// 성공 했을때 {"result" : "success"}
						// 실패 했을때 {"result" : "fail"}
						if(data.result == "success") {
							//alert("삽입 성공");// 처음 성공 확인 하고 redirect 넣을 때 삭제 했음
							location.href= "/lesson06/favorite_list";
						}	
						else {
							alert("삽입 실패");
						}
						
					},
					error:function(e) {
						alert("error");
					}
				});
				
			});
			
			$("#isDuplicateCheck").on("click",function(){
				
				
				var url = $("#urlInput").val();
				if(url == null || url == "") {
					alert("url을 입력해 주세요")	
					return;
				
				}
				
				$.ajax({
					type: "get", 
					url: "/lesson06/duplicate_Check",
					
					data: {"url":url},
					
					success:function(data){
						
						isChecked = true;
						if(data.checkDuplicate) {
							//alert("중복입니다");
							isDuplicate = true;
							$("#duplicateCheck").removeClass("d-none");
							$("#noneDuplicateCheck").addClass("d-none");
						} else {
							//alert("사용할 수 있는 주소입니다");
							isDuplicate = false;
							$("#noneDuplicateCheck").removeClass("d-none");
							$("#duplicateCheck").addClass("d-none");
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