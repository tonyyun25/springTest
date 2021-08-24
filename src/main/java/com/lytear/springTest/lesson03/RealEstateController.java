package com.lytear.springTest.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lytear.springTest.lesson03.Dmodel.RealEstate;
import com.lytear.springTest.lesson03.bo.RealEstateBO;

@RequestMapping("/lesson02")
@Controller
public class RealEstateController {

	
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	// id로 select 하기
	@RequestMapping("/test01/1")
	@ResponseBody
	public RealEstate test01(
//			@RequestParam(value = "id", defaultValue="1") int id	
			@RequestParam("id") int id
			) {
		
		return realEstateBO.getRealEstate(id);
	}
	
	
	// 월세 조건 select
	@RequestMapping("/test01/2")
	@ResponseBody
	public List<RealEstate> test02 (
//			@RequestParam(value="rentPrice", defaultValue="1") int rentPrice
			
			@RequestParam("rentPrice") int rentPrice
			) {
		
		return realEstateBO.getRealEstateRentList(rentPrice);
			
	}
	
	
	// 복합조건 select
	@RequestMapping("/test01/3")
	@ResponseBody
	
	public List<RealEstate> test03(
//			@RequestParam(value="area", defaultValue="1") int area,
//			@RequestParam(value="price", defaultValue="1") int price
			@RequestParam("area") int area
				,@RequestParam("price") int price
			
			
			) {
		return realEstateBO.getRealEstateAreaList(area, price);
	}
	
	// 객체로 insert 하기
	@RequestMapping("/test02/1")
	@ResponseBody
	
	public String test04() {
	
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count = realEstateBO.addRealEstateAsObject(realEstate); 		
		
		return "입력 성공 : " + count;
	}
	
	
	
	// field로 insert 하기
	
	
	@RequestMapping("/test02/2")
	@ResponseBody
	public String test05 (
				@RequestParam("realtorId") int realtorId
				// 위는 그냥 파라미터를 받기 위한 과정으로 BO, DAO와 연관 없음. 변수 이름 realtorId라도 무관
			) {
		int count = realEstateBO.addRealEstate ("썅떼빌리버 오피스텔 814호", realtorId, 45, "월세", 100000, 120);
		
		
		
		return "입력 성공 : " + count;
		}
	
	
		
	@RequestMapping("/test03/1")
	@ResponseBody
		
		public String test03(
				@RequestParam("id") int id,
				@RequestParam("type") String type,
				@RequestParam("price") int price
			) {
			
			int count = realEstateBO.updateRealEstateByid(id, type, price);
			return "업데이트 개수 : " + count;
	}
	
	@RequestMapping("/test03/2")
	@ResponseBody
	
	public String test04 (
			@RequestParam("id") int id
			
			) {
			int count = realEstateBO.deleteByid(id);
			return "삭제 성공 : " + count;
		
	}
	
	
}
