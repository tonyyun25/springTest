package com.lytear.springTest.Dlesson041.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lytear.springTest.Dlesson041.model.DSeller;

@Repository
public interface DSellerDAO {

	public int insertSeller(
			@Param("nickname") String nickname
			,@Param("profileImageUrl") String profileImageUrl
			,@Param("temperature") double temperature
			
			);
	
	
	public DSeller selectLastUser();
	
	public DSeller selectUser(
			@Param("id") int id
			);
	
}
