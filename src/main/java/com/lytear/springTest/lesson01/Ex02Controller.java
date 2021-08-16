package com.lytear.springTest.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//이제 View를 사용할 떄 responseBody 사용 안 하므로 Restcontroller 쓰면 안 됨
@Controller

public class Ex02Controller {
	// 이제부터는 jsp 를 막가져다 쓰지 않고 컨트롤러 를 통해서 만들거야
	// 요청 url : http://localhost:8080/lesson01/ex02/1
	@RequestMapping("/lesson01/ex02/1")
	public String view() {//jsp 경로 String으로 리턴해 준다. 그다음 jsp 경로 잡아준다 -> jsp 파일 만든다
		
		// 경로 잡아주기. /(slash) 붙이고 안 붙이고 중요함. 우리가 application.properties에서 뒤에 / 경로 붙여줘서 아래 / 안 붙임
		return "lesson01/ex02";// ex02.jsp인데 jsp는 suffix로 잡아놨기 때문에 그것까지 생략. 이걸 안 해 놨으면 모든 경로를 
		// 다 잡아줘야 하는 번거로움이 있음
		
		
		
		
	}
	
	
	
	
	
}
