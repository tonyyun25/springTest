<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통나무 펜션</title>
	
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
        
        <section class="d-flex justify-content-center content">
        	
        	<div class="col-6">
	        	<h1 class="text-center">예약하기</h1>
	        	
		        	<label>이름</label>
		        	<input type="text" class="form-control" name="name" id="nameInput">
	        	
		        	<label>예약날짜</label>
		        	<input type="text" class="form-control" name="date" id="dateInput">
	        	
		        	<label>숙박일수</label>
		        	<input type="text" class="form-control" name="day" id="dayInput">
	        	
		        	<label>숙박인원</label>
		        	<input type="text" class="form-control" name="headcount" id="headcountInput">
	        	
		        	<label>전화번호</label>
		        	<input type="text" class="form-control" name="phoneNumber" id="phoneNumberInput">
	        	
	        	
	        	<button type="button" class="btn btn-warning form-control" id="reserveBtn">예약하기</button>
       		</div>
        
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
    <script>
    	$(document).ready(function(){
    		$("#reserveBtn").on("click",function(){
    			
    			var name = $("#nameInput").val();
    			var date = $("#dateInput").val();
    			var day = $("#dayInput").val();
    			var headcount = $("#headcountInput").val();
    			var phoneNumber = $("#phoneNumberInput").val();
    			
    			if(name == null || name == "") {
    				alert("이름을 입력하세요");
    				return;
    			}
    			if(date == null || date == "") {
    				alert("예약날짜를 입력하세요");
    				return;
    			}
    			if(day == null || day == "") {
    				alert("숙박일수를 입력하세요");
    				return;
    			}
    			if(headcount == null || headcount == "") {
    				alert("숙박인원을 입력하세요");
    				return;
    			}
    			if(phoneNumber == null || phoneNumber == "") {
    				alert("전화번호를 입력하세요");
    				return;
    			}
    			//alert("확인 완료")
    			$.ajax({
    				
    				type: "get",
    				url: "/lesson06/addToList",
    				data: {"name":name, "date":date,"day":day,"headcount":headcount,"phoneNumber":phoneNumber},
    				success: function(data) {
    					//alert("성공");
    					if(data.result == "success") {
    						//alert("추가 성공");
    						location.href="/lesson06/bookListByLine"
    					} else {
    						alert("실패");
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