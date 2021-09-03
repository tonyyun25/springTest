<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
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
                    /*
                    jsp에서 하는 건 클라이언트(ajax도 포함)에요
                    이름, 전화번호를 서버로 전송함
                    일치하는 정보를 서버에서 받아옴 (자판기)
                    클라이언트는 서버와는 완전히 구분되어 있어 파라미터로 연결
                    
                    
                    */
                    
                    
                    
                    /* 이 위치 alert 정상 작동
                    alert(
                    "이름 : " + name  + "\n" +
                    "전화번호 : " + phoneNumber + "\n"
                    );
                    */
                    
                    // 중복체크시 count 쓴 건은 다른 데이터 필요 없었기 때문. 지금 상황은 데이터 그냥 가져와서 보여줘
                    // ajax는 html 포함한 view 내용은 전혀 없고 data만 주고받음 (api) => json 형태 만드는 게 중요
                    
                   
                    $.ajax({
                    	type: "get",	
                    	url: "/lesson06/booking_lookup",
                    	// 앞: 키, 뒤: 파라미터 이름으로 전달될 변수(값, 변수이름은 키와 달라도 되고 이름은 중요하지 않음)
                    	data:{"name":name, "phoneNumber":phoneNumber},//자판기에 동전 넣듯이 필요한 정보만 전달함(클라이언트는 돌려받기 전이라 지금 정보 두 개 밖에 없음)
                    	//data:{"name":샵{bookingList.name}}, // 주석처리해도 샵 기호 때문에 에러 발생해 버림
                    	success:function(data){//음료수(쿼리를 수행하고 나온 데이터)가 이 괄호 안에 있는 data
                    		//alert("확인");
                    		// 출력해야 하므로 문자열로 바꿔 준다	
                    		
                    		// ============= 방법 1. Booking 객체로만 가져올 때 ==============
                    		/*
                    		if(data.id == null) {
                    			alert("조회된 결과가 없습니다")
                    		} else {
	                    		var resultString = "이름 : " + data.name + "\n"
						           + "날짜 : " + data.date.slice(0,10) + "\n"
						           + "일수 : " + data.day;
						        //true, false는 eq 안 먹힘
						        	java 에서는 Date 객체이지만
									리턴하는 순간 얜 json 이라고 하는 형태의 문자열로 변환됩니다
									ajax에서 쓰는 객체는 json을 다시 객체화 시킨것으로 java객체와는 전혀 연관성이 없습니다
									date는 문자열로 바로 인지하고 처리하시면 됩니다
									
	                    		// ★★ data 는 response 값이기 때문에 response 자체가 null 일 수는 없음 (data == null은 잘못). 
	                    		// 값을 하나 꺼내 처리
	                    		alert(	
	                   					resultString*/
	                   					//  내가 쓴 방식
	                   					/*
	                   					"이름 : " + data.resultname + "\n"
	                   					+ "날짜 : " + 
	                   						data.result.date.substring(0,10)
	                   						+ "\n"
	                   					+ "일수 : " + data.result.day + "\n"
	                   					+ "인원 : " + data.result.headcount + "\n"
	                   					+ "상태 : " + data.result.state
	                   			);
                    		}
                    		*/
                    		// =============== 방법 1.1. Select 된 객체가 null인 경우도 표시해 줄 때
                    		if(data.result == "fail") {
                    			alert("select 된 객체가 null 입니다")
                    		} else {
	                    		if(data.result.id == null) {
	                    			alert("조회된 결과가 없습니다")
	                    		} else {
                    			
                    			var resultString = "이름 : " + data.result.name + "\n"
						           + "날짜 : " + data.result.date.slice(0,10) + "\n"
						           + "일수 : " + data.result.day;
						     
	                    		alert(	
	                   					resultString
	                   					
	                   			);
	                    		}
                    		}
                    		
                    	},
                    	error:function(e){
                    		alert("에러");
                    	}
                    	//${fn:substring(data.result.date, 2, 3) } => ajax에서 jstl tag 사용 불가
   						/*
   						요게 참 어려운 부분인데요
						ajax 와 jstl은 완전 다른 차원 이라고 생각하는게 좋아요
						멀티 버스 느낌? ㅎㅎㅎㅎ
						jstl 은 서버에서 처리 되는 부분입니다.
						컨트롤러를 통해서 모델에 저장된 정보를 꺼내서 html 을 완성시키는대 사용되는 문법입니다.
						ajax 부분은 이미 html 이 다 만들어진 상태에서 이미 브라우저로 전달되어진 거고요
						사용자의 브라우저에서 수행되는 과정이에요
						ajax를 쓴다는 이야기는 이미 jstl 에서 처리될 부분이 다 끝난 상황이라고 보면 됩니다
						중국가서 한국말하는 느낌? 이랑도 비슷할수 있겠습니다
   						*/
                    
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