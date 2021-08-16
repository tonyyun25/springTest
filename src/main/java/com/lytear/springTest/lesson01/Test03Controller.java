package com.lytear.springTest.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // jsp 연동하므로 RestController 와 ResponseBody 둘 다 사용 안 함
public class Test03Controller {

	@RequestMapping("/lesson01/test03")// 문제 하나 밖이라 /1 없음
	
	public String view() { // 경로를 돌려주기 때문에 리턴 타입은 무조건 String
		
		
		return "lesson01/test03"; // 내가 만든 jsp 파일의 경로 (url 매핑). RequestMapping 과는 아무 관련이 없음
	}
	/*
	 * Handler 맵핑 통해  Controller가 이어짐
	 * Controller가 responseBody가 아니라 (내용을 그대로 X, 경로만 O) 문자열 해당 부분 그대로 돌려줌
	 * View Resolver가 해당하는 이런 jsp 있나 그 결과만 확인하고 dispatcher 
	 * servlet에 전달 -> 브라우저에 전달
	 * 
	 * 
	 * Spring 내부가 db 연동까지 감안해 구조 짜여져 있어 db 연동 감안해 전체 흐름 파악할 거야
	 * 
	 * MVC 패턴은 흔히 디자인 패턴(예. mqsql 시 싱글턴패턴)이라 함
	 * MVC 패턴은 어떤 부분에도 적용될 수 있을 만큼 제일 기본이 됨
	 * view = 화면, controller = 로직, 모델 = 데이터
	 * 
	 * MVC : 각각의 역할에 맞게 파일 쪼개 화면 view는 화면 보여주는 역할만. 전달된 데이터를 자연스럽게 보여주는 걸로 끝
	 * Controller: DB에서 전달된 데이터를 화면에 전달. 쿼리 작성해서 전달해 말도 함
	 * 화면에서 어떤 자료 필요해 라고 데이터(쿼리)에 바로 말하지 않고 controller 밖에 모르는 순수한 친구
	 * controller가 데이터(쿼리)에 요청함
	 * 화면은 깔끔해, 데이터가 이상해 Controller만 조지면 돼. Controller도 문제 없으면 Model만 조지면 됨 (역할 분담)
	 * 수정할 때도 Controller 수정하면 View, Model 영향 미치지 않도록 수정 관리. 독립된 형태 
	 * => 좀더 안정적 상태로 코드를 디자인, 관리 가능
	 * 전에 배웠던 이클립스 IDE에서는 하나의 파일에 관리. 서로가 기대는 형태 => 굉장히 안 좋은 구조
	 * Spring 외 여러가지 형태의 MVC 구조가 있지만 Spring을 통해 명확히 개념 잡아야 이해가 편함
	 * 
	 * Spring 은 이런 형태를 조금 다르게 나누어 놓았음. controller, view를 묶어
	 * presentation layer 로 통침 (화면, layer의 중간자 역할) : 화면
	 * service(business layer)는 데이터를 조작, 건드리고, 필요에 따라 다른 데이터 가져옴 : 로직
	 * repository (persistence layer)는 쿼리만 사용하고 결과만 돌려줌 : 데이터
	 * 
	 * entity는 DB와 1:1 매칭이 되는 클래스를 의미
	 * DTD는 entity 자체가 될 수도 있고 좀 더 추가되거나 빠진 형태의 entity가 될 수 있다
	 * 	 * 
	 * '21.08.13일
	 * Servlet에서 MysqlService를 썼던 것을 Model 정도로 생각하면 됨
	 * 
	 * Repository 를 통해 DB 쪽에 쿼리를 날리고 그 결과를 Service (로직) 쪽에 전달함
	 * 데이터를 전달하는 매개체를 DTD라고 하고 일반적으로 클래스를 기반으로 한 객체를 전달함 (가장 흔한 게 entity 형태)
	 * Entity는 DB 칼럼과 똑같은 멤버 변수를 가지는 클래스 객체를 의미
	 * 
	 * 일반적으로 Entity가 DTD에 포함된 형태이며 Entity가 DTD의 한 종류
	 * 일반적으로 예제를 진행할 때는 Entity를 가지고 많이 진행할 거야
	 * 
	 * 
	 * 
	 * */
	
	
	
}
