package com.lytear.springTest.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.springTest.lesson03.Dmodel.RealEstate;
import com.lytear.springTest.lesson03.dao.RealEstateDAO;

@Service
public class RealEstateBO {

	@Autowired	
	private RealEstateDAO realEstateDAO;
	
	public RealEstate getRealEstate(int id) {
		return realEstateDAO.selectRealEstate(id);
	}
	
	
	public List<RealEstate> getRealEstateRentList(int rentPrice) {
		return realEstateDAO.selectRealEstateRentList(rentPrice);
	}

	
	
	
	public List<RealEstate> getRealEstateAreaList(int area, int price) {
		return realEstateDAO.selectRealEstateAreaList(area, price);
	}
	
	
	public int addRealEstateAsObject(RealEstate realEstate) {
		return realEstateDAO.insertRealEstateAsObject(realEstate);//DAO를 호출
	}
	
	
	
	
	
	public int addRealEstate(String address, int realtorId, int area, String type, int price, int rentPrice) {
		
		return realEstateDAO.insertRealEstate(address, realtorId, area, type, price, rentPrice);
		
		
		}
		
	public int updateRealEstateByid (int id, String type, int price) {
		
		return realEstateDAO.updateRealEstateByid(id, type, price);
	
		
		
		
	}
	
	public int deleteByid(int id) {
		return realEstateDAO.deleteByid(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
