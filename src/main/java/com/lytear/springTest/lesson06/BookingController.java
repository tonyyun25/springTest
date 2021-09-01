package com.lytear.springTest.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson06")
public class BookingController {

	/*
	해당 html 위치에 가서 그 파일 더블클릭해도되고요
	비쥬얼 스튜디오에서 해당 파일 오른 클릭해서 라이브프리ㅠㅂ 선택해서 봐도 됩니다
	혹시 지금 프로젝트로 이동해서 확인하고 싶으신거면
	jsp 만들고 거기에 html 코드 넣고
	컨트롤러에서 jsp 경로 리턴하는 그방식 그대로 확인하시면 되요
	 */
	
	@RequestMapping("/addBooking")
	public String addBooking() {
		
		

		
		return "lesson06/add_booking";
		
	}
	
	
}
