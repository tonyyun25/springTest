package com.lytear.springTest.Dlesson042.dao;

import org.springframework.stereotype.Repository;

import com.lytear.springTest.Dlesson042.model.DDRealtor;

@Repository
public interface DDRealtorDAO {

	public int insertRealtor(DDRealtor ddRealtor);
}
