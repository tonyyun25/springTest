package com.lytear.springTest.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.springTest.lesson06.dao.FavoriteDAO;
import com.lytear.springTest.lesson06.model.Favorite;

@Service
public class FavoriteBO {

	@Autowired
	private FavoriteDAO favoriteDAO;
	
	public int addFavorite(String name, String url) {
		return favoriteDAO.insertFavorite(name, url);
	}
	
	
	public List<Favorite> getFavoriteList() {
		return favoriteDAO.selectFavoriteList();
	}
	
	public boolean checkDuplicate(String url) {
		int count = favoriteDAO.verifyDuplicate(url);
		
		if(count >= 1) {
			return true;
		} else {
			return false;
		}
 		
	}
	
	
	
	
}
