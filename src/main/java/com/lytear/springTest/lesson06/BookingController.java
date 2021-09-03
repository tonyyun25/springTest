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
	
	@GetMapping("/booking_main") 
	public String bookingMain() {
		
		return "lesson06/test03/main";
	}
	
	// 정답 1
	/*
	@GetMapping("/booking_lookup")// 이름, 전화번호 정도라 get
	@ResponseBody // 데이터를 (맵) 돌려주는 api 형태로 만들기 때문에 사용
	public Booking bookingLookup(
	//public Map<String, Booking> confirmedPerson( // 내가 쓴 방식
	//public Map<String, Object> bookingLookup( // 문제:booking이 select된 결과가 없으면 null이 된다 						
			@RequestParam("name") String name // name이라는 이름(앞)으로 전달받아서 name이라는 변수(뒤)로 저장
			,@RequestParam("phoneNumber") String phoneNumber
			) {
		// 여기까지 하고 BO 작성
		// Mybatis에서 쿼리 수행 결과로 아래 만들어 줌
		Booking booking = bookingBO.getBookingListByNamePhoneNumber(name, phoneNumber);
		
//		Map<String, Booking> result = new HashMap<>();// 내가 쓴 방식	
//		result.put("result",booking);// 내가 쓴 방식	
//		return result;// 내가 쓴 방식
		
		return booking;
	}
	*/
	
	// 정답 1.1. select 된 결과가 없을 때 보여줄 수 있는 방식
	@GetMapping("/booking_lookup")
	@ResponseBody 
	
	public Map<String, Object> bookingLookup( // 문제:booking이 select된 결과가 없으면 null이 된다 						
			@RequestParam("name") String name 
			,@RequestParam("phoneNumber") String phoneNumber
			) {
		// booking이 select 된 결과가 없으면 null 이 된다. booking이 null 인 경우에 map에 어떤 값을 넣고 null이 아닌 경우에 어떤 값 넣고
		Booking booking = bookingBO.getBookingListByNamePhoneNumber(name, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		
		if(booking == null) {
			result.put("result","fail");
		} else {
			result.put("result",booking);
		}
		
		
		return result;
		
	}
	

	
}
