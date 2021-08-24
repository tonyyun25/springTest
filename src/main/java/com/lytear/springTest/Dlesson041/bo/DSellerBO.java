package com.lytear.springTest.Dlesson041.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.springTest.Dlesson041.dao.DSellerDAO;
import com.lytear.springTest.Dlesson041.model.DSeller;

@Service
public class DSellerBO {

	
	@Autowired
	private DSellerDAO dSellerDAO;
	
	public int add_seller(String nickname, String profileImageUrl, double temperature) {
		return dSellerDAO.insertSeller(nickname, profileImageUrl, temperature);
	}
	
	public DSeller getLastUser() {
		return dSellerDAO.selectLastUser();
	}
	
	public DSeller getUser(int id) {
		return dSellerDAO.selectUser(id);
	}
	
	
}
