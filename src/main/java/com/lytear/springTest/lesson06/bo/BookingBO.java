package com.lytear.springTest.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.springTest.lesson06.dao.BookingDAO;
import com.lytear.springTest.lesson06.model.Booking;

@Service
public class BookingBO {

	
	@Autowired
	private BookingDAO bookingDAO;
	
	public List<Booking> getBookingList() { // 이 상태에서 칼럼 이름과 동일한 멤버 변수를 가지는 클래스를 만들어 준다
		
		return bookingDAO.selectBookingList();
	}
	

	public int deleteBooking(int bookListId) {
		return bookingDAO.deleteBooking(bookListId);
	}
	// 아래도 삭제 성공
//	public int removeList(int id) {
//		return bookingDAO.delete_list(id);
//	}
	// 아래도 삭제 성공
//		public int removeList(int sam) {
//			return bookingDAO.delete_list(sam);
//		}
	// 결론 : 어떤 이름이 와도 상관 없음. 앞의 int 명과 아래에 리턴할 파라미터의 명만 일치하면 됨
	
	
	public int addBooking(String name, String date, int day, int headcount, String phoneNumber, String state) {
		
		
		return bookingDAO.insertBooking(name, date, day, headcount, phoneNumber, "대기중");
	}
	
	
	
	
}
