package com.lytear.springTest.Dlesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lytear.springTest.Dlesson02.Dmodel.RealEstate;
import com.lytear.springTest.Dlesson02.bo.RealEstateBO;

@Controller
public class RealEstateController {

	
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	// id로 select 하기
	@RequestMapping("/Dlesson02/Dtest01")
	@ResponseBody
	public RealEstate Dtest01(
			@RequestParam(value = "id", defaultValue="1") int id	
			) {
		
		return realEstateBO.getRealEstate(id);
	}
	
	
	// 월세 조건 select
	@RequestMapping("/Dlesson02/Dtest02")
	@ResponseBody
	public List<RealEstate> Dtest02 (
			@RequestParam(value="rentPrice", defaultValue="1") int rentPrice
			
			) {
		
		return realEstateBO.getRealEstateRentList(rentPrice);
			
	}
	
	
	// 복합조건 select
	@RequestMapping("/Dlesson02/Dtest03")
	@ResponseBody
	
	public List<RealEstate> Dtest03(
			@RequestParam(value="area", defaultValue="1") int area,
			@RequestParam(value="price", defaultValue="1") int price
			) {
		return realEstateBO.getRealEstateAreaList(area, price);
	}
	
	
	
	
}
