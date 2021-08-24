package com.lytear.springTest.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.springTest.lesson04.dao.RealtorDAO;
import com.lytear.springTest.lesson04.model.Realtor;

@Service
public class RealtorBO {

	
	@Autowired
	private RealtorDAO realtorDAO;
	
	public int addRealtor(Realtor realtor) {
		return realtorDAO.insertRealtor(realtor);
	}
}
