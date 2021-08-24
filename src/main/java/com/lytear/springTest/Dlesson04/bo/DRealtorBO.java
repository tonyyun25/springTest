package com.lytear.springTest.Dlesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.springTest.Dlesson04.dao.DRealtorDAO;
import com.lytear.springTest.Dlesson04.model.DRealtor;

@Service
public class DRealtorBO {
	
	@Autowired
	private DRealtorDAO dRealtorDAO;
	
	public int add_realtor(DRealtor realtor) {
		return dRealtorDAO.insertRealtor(realtor);
	}
	
	
}
