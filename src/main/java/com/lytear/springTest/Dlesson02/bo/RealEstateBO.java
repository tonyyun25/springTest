package com.lytear.springTest.Dlesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.springTest.Dlesson02.Dmodel.RealEstate;
import com.lytear.springTest.Dlesson02.dao.RealEstateDAO;

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
	
	
}
