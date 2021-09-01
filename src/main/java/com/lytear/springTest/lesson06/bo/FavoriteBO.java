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
	
	public boolean isDuplicateUrl(String url) {
		int count = favoriteDAO.selectCountUrl(url);
		
		if(count >= 1) {
			return true;
		} else {
			return false;
		}
 		
	}
	// update, delete는 각각 수정, 삭제된 행의 개수가 나옴 (workbench)
	public int deleteFavorite(int id) {
		return favoriteDAO.deleteFavorite(id);
	}
	
	
	
	
}
