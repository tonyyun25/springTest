package com.lytear.springTest.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.springTest.lesson04.dao.SellerDAO;
import com.lytear.springTest.lesson04.model.Seller;
@Service
public class SellerBO {

	
	@Autowired
	private SellerDAO sellerDAO;
	
	public int add_seller(String nickname, String profileImageUrl, double temperature) {
		return sellerDAO.insert_seller(nickname, profileImageUrl, temperature);
	}
	
	
	public Seller getLastSeller() {
		return sellerDAO.selectLastSeller();
	}
	
	public Seller getSeller(int id) {
		return sellerDAO.selectSeller(id);
	}
	
}
