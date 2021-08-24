package com.lytear.springTest.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lytear.springTest.lesson03.Dmodel.RealEstate;

@Repository
public interface RealEstateDAO {

	public RealEstate selectRealEstate(@Param("id") int id);
	// @Param("id") : xml에 사용될 변수, int id : 호출하는 곳의 변수
	
	public List<RealEstate> selectRealEstateRentList(@Param("rentPrice") int rentPrice);
	 
	
	
	
	public List<RealEstate> selectRealEstateAreaList(
			@Param("area") int area
			, @Param("price") int price
			);
	
	
	public  int insertRealEstateAsObject (
				RealEstate realEstate
			);
	
	
	public int insertRealEstate (
			@Param("address") String address,
			@Param("realtorId") int realtorId,//
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") int rentPrice
			
			);

	
	public int updateRealEstateByid(
			@Param("id") int id,
			@Param("type") String type,
			@Param("price") int price
			
			);
	
	public int deleteByid(@Param("id") int id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
