package com.lytear.springTest.lesson04.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lytear.springTest.lesson04.model.Seller;
@Repository
public interface SellerDAO {

	public int insert_seller(
			@Param("nickname") String nickname
			,@Param("profileImageUrl") String profileImageUrl 
			,@Param("temperature") double temperature 
			);
	
	public Seller selectLastSeller();
	
	public Seller selectSeller(@Param("id") int id);
	
	
}
