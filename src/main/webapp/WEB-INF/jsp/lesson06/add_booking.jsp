<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통나무 펜션</title>
	
	<link rel="stylesheet" href="/lesson06/test01/css/style.css" type="text/html">
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
		        	<input type="text" class="form-control" name="days" id="daysInput">
	        	
		        	<label>숙박인원</label>
		        	<input type="text" class="form-control" name="person" id="personInput">
	        	
		        	<label>전화번호</label>
		        	<input type="text" class="form-control" name="phoneNumber" id="phoneNumberInput">
	        	
	        	
	        	<button type="button" class="btn btn-warning form-control" id="reserveBtn">예약하기</button>
       		</div>
        
        </section>
        
        <footer>
        
        </footer>
        
    </div>   
        
</body>
</html>