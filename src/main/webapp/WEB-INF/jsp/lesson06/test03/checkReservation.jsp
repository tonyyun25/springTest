<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
    
    
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>제이쿼리2:change이벤트</title>
        

<!-- 이 문제 혼자서 풀 수 있을 정도 되면 웬만한 backend 개발자보다 frontend 더 잘함 -->
<!-- jquery: 이게 있어야 jquery ui(datepicker) 문법이 먹힘 -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
           
<!-- bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script> -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

		<Link rel="stylesheet" href="/lesson06/css/style.css" type="text/css">
    </head>
    <body>
        <div class="" id="wrap">
            <header class="mt-4 ">
                <div class="text-center display-4">통나무 펜션</div>
            
                <nav class="mt-4 ">
                    <ul class="nav nav-fill">
                        <li class="nav-item"><a class="nav-link " href="#">펜션소개</a></li>
                        <li class="nav-item"><a class="nav-link " href="#">객실보기</a></li>
                        <li class="nav-item"><a class="nav-link"  href="/lesson06/add_booking_view">예약하기</a></li>
                        <li class="nav-item"><a class="nav-link " href="/lesson06/booking_list">예약목록</a></li>
                    </ul>
                </nav>

            </header>

            <section class="banner ">
                <!-- <div class="div-box"> -->
                
                    <!-- <button id="prevBtn">이전</button> -->
                    <img alt="사진" id="bannerImage"  src="images/test06_banner1.jpg">
                   
                    
                    <!-- <button id="nextBtn">다음</button> -->
            </section>



            <section class="d-flex " >
                
                <article class="reservation d-flex align-items-center justify-content-center">
                    <div class=" display-4">
                        실시간 <br> 
                        예약하기
                    </div>
                </article>


                <article class="reservation-confirm ">
                    <div class="m-4">
                        <div class=" d-flex align-items-end"> <!-- 여기 div 추가-->
                            <h3 class="mr-4">예약 확인</h3>
                        </div>   
                         
                        <div  class="no-member-input mt-3 " id="nonMember"> <!--no-member-input d-none 추가 -->
                            <div class="input-group form-inline">
                                <label  class="input-label">이름 </label>
                                <input type="text" id="name" class="form-control text-input">
                            </div>
                            <div class="input-group form-inline mt-3">
                                <label  class="input-label">전화번호 </label>
                                <input type="text" id="phoneNumber" class="form-control text-input">
                            </div>
                           
                        </div>

                        <div class = "d-flex justify-content-end"><!--button을 div 안에 넣는다-->
                            <button id="lookupBtn" class="btn btn-success mt-3 mr-5">조회하기</button>
                        </div>
    
                    </div>
                </article>


                <article class="reservation-call d-flex justify-content-center align-items-center">
                    <div>
                        <h3>예약문의</h3>
                        <h1>010-</h1>
                        <h1>000-1111</h1>
                    </div>
                </article>
                    
                
                <!-- </div> -->
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
            
            $(document).ready(function() {
            // $(document).ready(function(){    
                $("#lookupBtn").on("click",function(){
                   
                    var name = $("#name").val().trim();
                    var phoneNumber = $("#phoneNumber").val().trim();
                  
                    if(name == null || name == "") {
                        alert("이름을 입력해 주세요");
                        return;
                    }
                    if(phoneNumber == null || phoneNumber == "") {
                        alert("전화번호를 입력해 주세요");
                        return;
                    }
                    // 010으로 시작하지 않는 경우
                    
                    if(!phoneNumber.startsWith("010")) {
                        alert("010으로 시작하는 번호만 입력해 주세요");
                        return;
                    }
                    /* 이 위치 alert 정상 작동
                    alert(
                    "이름 : " + name  + "\n" +
                    "전화번호 : " + phoneNumber + "\n"
                    );
                    */
                    
                    // 중복 확인과 같은 방식으로 ajax 이용하여 접근
                    
                    $.ajax({
                    	type: "get",	
                    	url: "/lesson06/confirmed_person",
                    	
                    	data:{"name":name, "phoneNumber":phoneNumber},
                    	//data:{"name":샵{bookingList.name}}, // 주석처리해도 샵 기호 때문에 에러 발생해 버림
                    	success:function(data){
                    		//alert("확인");
                    		if(data.result == null){//true, false는 eq 안 먹힘
                    			alert("조회 결과가 없습니다");
                    			
                    		} else {
                    			// 이름, 날짜, 일수, 인원, 상태
                    			//alert("이름 : " + name + "\n" + "날짜 : ")
                    			alert(data.result);
                    		}
                    	},
                    	error:function(e){
                    		alert("에러");
                    	}
                    
                    
                    });
                    
                });
                // var imageList = [
                //     "image/chicks-6357339__340.webp",
                //     "image/shiba-6292660__340.webp",
                //     "image/squirrel-6365603__340.webp"
                // ];

                var imageList = [                        
                        "images/test06_banner1.jpg",
                        "images/test06_banner2.jpg",
                        "images/test06_banner3.jpg",
                        "images/test06_banner4.jpg"

                ];
                

                var index = 0;

                setInterval(function(){
                    // 뭘 수행할 지 먼지 정의(function) 후 순환할 시간 입력 (3,000 milisecond: 1000분의 1초)
                    index++;
                    if(index > imageList.length - 1) {
                        index = 0;
                    }    
                    
                    $("#bannerImage").attr("src", imageList[index]);
                }, 3000);


                // var currentIndex = 0;
                // $("#nextBtn").on("click",function(){                   
                //     currentIndex++;        
                //     if(currentIndex == imageList.length) {
                //         currentIndex = 0;
                //     }    
                //     $("#bannerImage").attr("src", imageList[currentIndex]);
                // });
              
                // $("#prevBtn").on("click",function(){
                  
                //     currentIndex--;
                   
                //     if(currentIndex == - 1) {
                //         currentIndex = imageList.length - 1;
                        
                //     }    
                //     $("#bannerImage").attr("src", imageList[currentIndex]);
                // });


            });


        </script>
    </body>
</html>