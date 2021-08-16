package com.lytear.springTest.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lesson01/test01")

public class Test01Controller {

// http://localhost:8080/lesson01/test01/1
	@RequestMapping("/1")
	@ResponseBody
	public String printString() {
		return "<h1>테스트 프로젝트 완성</h1> <h3>해당프로젝트를 통해서 문제를 진행합니다.</h3>";
		// String 으로 리턴했을 때 리턴되는 타입은 text / plain이야 (html 아님). html 메시지 타입이
		// 리턴 타입을 잡아서 넘겨줌. 나는 브라우저야 어차피 전달된 거는 html으로 전달할거야 해서 화면에 출력됨
		
	}
	
	// 리턴 타입 잘 정하는 게 중요. 문자열 : 숫자. 리턴할 맵을 만들어 져야 함
//  http://localhost:8080/lesson01/test01/2	
	@RequestMapping("/2")
	@ResponseBody// 이걸 해야 map이 json으로 변경됨
	public Map<String, Integer> printMap() {
		Map<String, Integer> scoreMap = new HashMap<>();
	
		scoreMap.put("국어", 80);
		scoreMap.put("수학", 90);
		scoreMap.put("영어", 85);
		return scoreMap;
	}
	
	
}
