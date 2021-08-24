package com.lytear.springTest.Dlesson05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/Dlesson05")
@Controller
public class DLesson05Controller {

	
	@GetMapping("/Dtest01")
	public String test01() {
		
		return "lesson05/Dtest01";
	}
	
	
}

