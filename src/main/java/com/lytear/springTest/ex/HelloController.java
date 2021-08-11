package com.lytear.springTest.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@ResponseBody // 메소드에서 전달하는 내용을 그대로 브라우저에 전달하겠다
	@RequestMapping("/hello")
	public String hello() {
		return "hello world";
	}
	
}
