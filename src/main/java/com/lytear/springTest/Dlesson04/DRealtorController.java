package com.lytear.springTest.Dlesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lytear.springTest.Dlesson04.bo.DRealtorBO;
import com.lytear.springTest.Dlesson04.model.DRealtor;

@Controller
@RequestMapping("/Dlesson04")
public class DRealtorController {
//	최초 접속 불능 원인 : xml이 namespace 정의 안 된 상태로 만들어졌음
//	두 번째 안 된 원인 : jsp에 url 주소를 lesson04로 씀
//	세 번째 안 된 원인 : DRealtor에서 변수이름 오타나 수정했는데 getAddresss 그대로 있음 
	
	@GetMapping("/test02/1")
	
	public String addRealtorView() {
		return "lesson04/DaddRealtor";
	}
	
	@Autowired
	private DRealtorBO dRealtorBO;
	@GetMapping("/test02/add_realtor")
	
	
	public String add_realtor(
			@ModelAttribute DRealtor realtor
			,Model model
			) {
		int count = dRealtorBO.add_realtor(realtor);
		model.addAttribute("result",realtor);
		
		return "lesson04/DrealtorInfo";
	}
//	
	
	
	
	
	
	
	
}
