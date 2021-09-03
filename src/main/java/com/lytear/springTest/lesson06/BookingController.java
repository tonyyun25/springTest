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
	 * [url 검사에서 표시 에러]
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
	
	@GetMapping("/booking_list")
	public String bookingList(Model model) {
		
		List<Booking> bookingList = bookingBO.getBookingList(); 
		
		model.addAttribute("bookingList", bookingList );
		
		
		return "lesson06/test03/bookingList";
	}
	
	@GetMapping("/booking_delete")
	@ResponseBody
	public Map<String, String> delete(
				@RequestParam("id") int sam // 
				// data:{"bookingId":bookingId} 중 뒤의 이름이 여기 @RequestParam 안에 들어가면 된다
			) {
		int count = bookingBO.deleteBooking(sam);
/* 아래도 삭제 성공
		public Map<String, String> delete_list(
				@RequestParam("bookListId") int bookListId
			) {
		int count = bookingBO.removeList(bookListId);
*/
/* 아래도 삭제 성공
 * 	public Map<String, String> delete_list(
				@RequestParam("bookListId") int id
			) {
		int count = bookingBO.removeList(id);
 * */		
//	결론 : 위의 RequestParam("bookListId") 뒤의 변수는 값을 저장하는 것으로 어떤 이름이 와도 가능하고 
//		뒤의 int count와 같은 변수 이름만 들어가면 된다
//  단, RequestParam 뒤에는 bookingList.jsp에서 받은 각각의 id를 지정하는 변수 이름을 정확히 넣어야 한다	
		Map<String, String> result = new HashMap<>();
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		return result;
	}
	
	@GetMapping("/add_booking_view")
	public String addBooking() {
		return "lesson06/test03/addBooking";
		
	}
	
	@GetMapping("/add_booking")
	@ResponseBody
	public Map<String, String> addBooking(
			@RequestParam("name") String name
			,@RequestParam("date") String date
			,@RequestParam("day") int day
			,@RequestParam("headcount") int headcount
			,@RequestParam("phoneNumber") String phoneNumber
			) {
		
		int count = bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, String> result = new HashMap<>();
		if(count == 1) {
			result.put("result","success");
		} else {
			result.put("result","fail");
		}
		return result;
	}
	
	@GetMapping("/main_page") 
	public String mainPage() {
		
		return "lesson06/test03/checkReservation";
	}
	
	@RequestMapping("/confirmed_person")
	@ResponseBody
	//public Booking confirmedPerson(
	public Map<String, Booking> confirmedPerson(
							
			@RequestParam("name") String name
			,@RequestParam("phoneNumber") String phoneNumber
			) {
		
		//return bookingBO.getSchedule(name, phoneNumber);//여기까지 ok
		//Booking result = bookingBO.getSchedule(name, phoneNumber);
		
		Booking books = bookingBO.getSchedule(name, phoneNumber);
		
		
		
		
		Map<String, Booking> result = new HashMap<>();
		
		result.put("result",books);
		
		
		return result;
		
	}
	

	/*
	 * Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception 
	 * [Request processing failed; nested exception is org.mybatis.spring.MyBatisSystemException: 
	 * nested exception is org.apache.ibatis.type.TypeException: Could not set parameters for 
	 * mapping: ParameterMapping{property='name', mode=IN, javaType=class java.lang.Integer, 
	 * jdbcType=null, numericScale=null, resultMapId='null', jdbcTypeName='null', expression='null'}. 
	 * */
	
	
	
}
