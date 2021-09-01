package com.lytear.springTest.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lytear.springTest.lesson06.model.Booking;
@Repository
public interface BookingDAO {

	public int insertBookList(
			@Param("name") String name
			,@Param("date") String date 
			,@Param("day") int day 
			,@Param("headcount") int headcount 
			,@Param("phoneNumber") String phoneNumber 
			);
	
	
	public List<Booking> selectBookList();
	
	public int delete_list(
			@Param("id") int id
			);
	
	
}
