package com.lytear.springTest.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lytear.springTest.lesson04.bo.RealtorBO;
import com.lytear.springTest.lesson04.model.Realtor;

@Controller
@RequestMapping("/lesson04/")
public class RealtorController {

	
	@Autowired
	private RealtorBO realtorBO;
	
	@GetMapping("/test02/1")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	
	@GetMapping("test02/add_realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor //해당 객체로 파라미터 받을 수 있도록 세팅
			/*이제 xml을 통해 인서트하고 나서 id까지 채워진 상태*/ 
			, Model model 
			) {
		realtorBO.addRealtor(realtor);
		model.addAttribute("result", realtor);
		
		return "lesson04/realtorInfo";//디버깅 모드로 우선 확인
	}
	
	
	
}
