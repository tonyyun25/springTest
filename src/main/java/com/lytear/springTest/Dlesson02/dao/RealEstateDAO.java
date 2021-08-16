package com.lytear.springTest.Dlesson02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lytear.springTest.Dlesson02.Dmodel.RealEstate;

@Repository
public interface RealEstateDAO {

	public RealEstate selectRealEstate(@Param("id") int id);
	
	public List<RealEstate> selectRealEstateRentList(@Param("rentPrice") int rentPrice);
	 
	
	
	
	public List<RealEstate> selectRealEstateAreaList(@Param("area") int area, @Param("price") int price);
	
}
