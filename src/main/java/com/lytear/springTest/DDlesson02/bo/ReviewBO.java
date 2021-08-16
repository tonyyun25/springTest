package com.lytear.springTest.DDlesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.springTest.DDlesson02.dao.ReviewDAO;
import com.lytear.springTest.DDlesson02.model.Review;

@Service
public class ReviewBO {

	
	@Autowired
	private ReviewDAO reviewDAO;
	
//	public Review getReview() {
	public Review getReview(int id) {
				
				
		return reviewDAO.selectReview(id);
	}
	
	
	
	
}
