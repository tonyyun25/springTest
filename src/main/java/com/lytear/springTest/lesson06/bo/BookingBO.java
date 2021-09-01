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
	public int add_toList(String name, String date, int day, int headcount, String phoneNumber) {
		
		
		return bookingDAO.insertBookList(name, date, day, headcount, phoneNumber);
	}
	
	public List<Booking> getBookList() {
		
		return bookingDAO.selectBookList();
	}
	
	public int removeList(int id) {
		return bookingDAO.delete_list(id);
	}
	
	
	
}
