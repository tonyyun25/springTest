package com.lytear.springTest.lesson06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lytear.springTest.lesson06.bo.BookingBO;
import com.lytear.springTest.lesson06.model.Booking;

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
	
	/*
	 * 
	 * [url 표시 에러]
	Failed to load resource: the server responded with a status of 500 ()
	[spring 표시 에러]
	### Error updating database.  Cause: java.sql.SQLException: Field 'state' doesn't have a default value
	### SQL: INSERT INTO `booking`    (     `name`     ,`headcount`     ,`day`     ,`date`     ,`phoneNumber`     ,`createdAt`     ,`updatedAt`             )        VALUES    (     ?     ,?     ,?     ,?     ,?     ,now()     ,now()        )
	### Cause: java.sql.SQLException: Field 'state' doesn't have a default value
	; Field 'state' doesn't have a default value; nested exception is java.sql.SQLException: Field 'state' doesn't have a default value] with root cause
	 * 
	 * 결과 : mapper에 default 값을 '대기중' 으로 잡아 주니 해결. model에 state 변수가 없어도 정상적으로 실행 잘 됨 
	 * */
	
	
	
	@Autowired
	private BookingBO bookingBO;
	
	@RequestMapping("/addBooking")
	public String addBooking() {
		return "lesson06/add_booking";
		
	}
	
	@GetMapping("/addToList")
	@ResponseBody
	public Map<String, String> addList(
			@RequestParam("name") String name
			,@RequestParam("date") String date
			,@RequestParam("day") int day
			,@RequestParam("headcount") int headcount
			,@RequestParam("phoneNumber") String phoneNumber
			) {
		
		int count = bookingBO.add_toList(name, date, day, headcount, phoneNumber);
		
		Map<String, String> result = new HashMap<>();
		
		
		if(count == 1) {
			result.put("result","success");
		} else {
			result.put("result","fail");
		}
		return result;
		
	}
	
	
	
	@GetMapping("/bookListByLine")
	public String bookListbyLine(Model model) {
		
		List<Booking> bookListbyLine = bookingBO.getBookList(); 
		
		model.addAttribute("bookListbyLine", bookListbyLine );
		
		
		return "lesson06/bookingList";
	}
	
	
	
	@GetMapping("/deleteList")
	@ResponseBody
	public Map<String, String> delete_list(
//				@RequestParam("bookListId") int id
				@RequestParam("bookListId") int bookListId
			) {
		
//		int count = bookingBO.removeList(id);
		int count = bookingBO.removeList(bookListId);
		
				
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	
	
	
	
}
