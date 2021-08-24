package com.lytear.springTest.Dlesson04.dao;

import org.springframework.stereotype.Repository;

import com.lytear.springTest.Dlesson04.model.DRealtor;
@Repository
public interface DRealtorDAO {

	

	public int insertRealtor(DRealtor realtor);
	
}
