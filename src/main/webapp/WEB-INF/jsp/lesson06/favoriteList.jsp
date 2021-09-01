<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 목록</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<!--  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  


</head>
<body>
	<div class="container">
		<h1>즐겨찾기 목록</h1>
		
		<table class="table text-center">
			<thead>
				<th>No.</th>
				<th>이름</th>
				<th>주소</th>
				<th></th>
			</thead>
			
			
			<tbody>
				<!-- 기존에는 a tag 이용해 href 이용해 특정한 url, 파라미터 세팅해서 삭제. 
				ajax로는 a tag를 통한 진행에는 번거로움이 있어서 이번에는 버튼 이벤트로 진행.
				첫째 id로 버튼 만들면 반복문을 통해 똑같은 아이디로 버튼이 계속 만들어지면서 버튼은 정상 동작하지 않음.
				id의 속성이 이 페이지에서 유일하게 사용할 수 있는 것
				=> 여러 개를 사용 가능하도록 id가 아니라 class에다가 이름을 지정.
				 그런 다음 url 에다가 저장한 id, 그 특정 속성을 우리가 저장해야 함(data-favorite-id : jquery에서
				 tag에 값을 저장하도록 만들어놓은 특수한 형태의 속성)
				 
				 -->
				
				<c:forEach var="favorite" items="${favoriteList }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${favorite.name }</td>
					<td><a href="${favorite.url }">${favorite.url }</a></td>
					
					<!-- <td><a class="btn btn-danger" href="/lesson06/delete?id=${favorite.id }">삭제</a></td>-->
					
					  <td><button type="button" class="btn btn-danger btn-sm deleteBtn" data-favorite-id="${favorite.id }">삭제</button></td>
					 <!--  <td><button type="button" class="btn btn-danger btn-sm deleteBtn" favorite-id="${favorite.id }">삭제</button></td>-->
					<!-- 임의로 만든 속성으로도(favorite-id) 값을 가져와 쓸 수 있지만, 다른 곳에서 사용하고 있다면 꼬일 수 있으므로 좋은 방법은 아님 -->
					<!--  <td><a href="http://naver.com">http://naver.com</a></td>-->
					
				</tr>
				</c:forEach>
				<!-- 임시 값을 넣은 다음 /lesson06/favorite_list으로 사이트 출력되는지 체크해 본다 -->
			
			</tbody>
			
			<script>
				$(document).ready(function(){
					$(".deleteBtn").on("click",function(){//deleteBtn에 대한 이벤트. 
						alert("삭제 버튼");
						// 버튼 여러개지만 어떤 버튼을 클릭하든 다 이 이벤트로 잡힌다
						// 문제는 지금 클릭된 버튼이 뭔지 알아야 data-favorite-id 값을 가져올 수 있다
						// 지금 이벤트가 발생한 객체  = 클릭된 버튼 객체를 $(this)로 가져올 수 있다
						// 이렇게 버튼 객체를 가져오면 그 버튼 태그 안에 들어 있는 모든 내용을 가져올 수 있다. 모델의 정보에서 가져온 id 정보를
						// data-favorite-id에서 가져 옴
						// 처음에 임의로 만든 속성일 때 (favorite-id) 아래와 같이 attr 사용했고 data-에서는 data()와 같이 사용 
						//var favoriteId = $(this).attr("favorite-id");
						
						// data-로 시작하는 함수는 아래와 같이 data 로서 데이터 가져올 수 있다 
						var favoriteId = $(this).data("favorite-id");//data 메소드로 해당하는 속성 안에 들어오는 값을 꺼내 저장함
						
						//alert(favoriteId); // 값을 잘 꺼내왔는지 alert을 통해 확인
						// 버튼에서 data- 라고 표시하면(뒤에는 아무거나 붙어도 상관 없음) 여기서 data() 통해 값 꺼내올 수 있음
						
					
						$.ajax({
							
							type: "get",
							url: "/lesson06/favorite_delete",
							//data:{"id":favoriteId},
							data:{"favoriteId":favoriteId},// 뒤에 나온 건 값.
							// "id":favoriteId라고 해도 아뇨 전혀 문제 없습니다. 파라미터 이름만 일치 시키면 관계 없습니다

							success:function(data) {
								//alert(data);
								//alert("확인");
								if(data.result == "success") {
									//alert("성공");
									//location.href = "/lesson06/favorite_list";
									location.reload();
								}
								else {
									alert("삭제 실패했습니다.");
								}
								
							}
							
							, error:function(e) {
								alert("error");
							}
							
							
						});
					
					});
				});
			
			
			
			</script>
			
			
			
		</table>
	
	
	</div>
</body>
</html>