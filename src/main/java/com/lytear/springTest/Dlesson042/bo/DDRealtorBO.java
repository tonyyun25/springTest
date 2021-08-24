package com.lytear.springTest.Dlesson042.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.springTest.Dlesson042.dao.DDRealtorDAO;
import com.lytear.springTest.Dlesson042.model.DDRealtor;

@Service
public class DDRealtorBO {

	@Autowired
	private DDRealtorDAO ddRealtorDAO;
	
	public int addRealtor(DDRealtor ddRealtor) {
		return ddRealtorDAO.insertRealtor(ddRealtor);
		
	}
	
	
	
	
}
