package com.lytear.springTest.DDlesson02.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lytear.springTest.DDlesson02.model.Review;

@Repository
public interface ReviewDAO {

	
	public Review selectReview(@Param("id") int id);
	
	
	
}
