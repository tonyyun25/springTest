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
	
	public int addUser(String name, String url) {
		return favoriteDAO.insertUser(name, url);
	}
	
	
	public List<Favorite> getFavoriteList() {
		return favoriteDAO.selectFavoriteList();
	}
	
}
