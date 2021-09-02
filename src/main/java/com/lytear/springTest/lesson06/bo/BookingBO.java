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
	
	
	public int addBooking(String name, String date, int day, int headcount, String phoneNumber) {
	/*
	 * 1. 컨트롤러에서 bo로 전달해줄 데이터에는 state 가 없습니다. 근데 bo에서는 state를 받고 있기 때문에 이것이 일치 되지 않아서 나는 에러에요 bo에서는 state 값을 받지 않기 때문에 해당 파라미터를 지우고요
	 DAO 부터 그값을 쓰기 때문에 bo 메소드 내부에서 특정 값을 지금 처럼 지정해주면 됩니다
	즉 지금 상태에서 bo 메소드에서 state 파라미터를 빼주면 됩니다.
	bo에서 만든 메소드를 컨트롤러에서 쓰는거기 때문에 컨트롤러에서 bo의 메소드를 호출할때 해당 파라미터 가 일치해야 합니다 그것을 잘 정리하면 이해 되실거에요

	 * 
	 * */	
		
		return bookingDAO.insertBooking(name, date, day, headcount, phoneNumber, "대기중");
	}
	
	public boolean isDuplicate(String name , String phoneNumber) {
		
		int count = bookingDAO.selectCountMember(name, phoneNumber);
		if(count >= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getSchedule(String name, String phoneNumber) {
		return bookingDAO.selectSchedule(name, phoneNumber);
	}
	
	
}
