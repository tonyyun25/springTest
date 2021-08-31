package com.lytear.springTest.Dlesson06.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.springTest.Dlesson06.dao.DfavoriteDAO;

@Service
public class DfavoriteBO {

	
	@Autowired
	private DfavoriteDAO dfavoriteDAO;
	public int addFavorite(String name, String url) {
		
		return dfavoriteDAO.insertFavorite(name, url);
	}
	
	
	
	
	
	
	
	
	
}
