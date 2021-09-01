package com.lytear.springTest.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lytear.springTest.lesson06.model.Favorite;

@Repository
public interface FavoriteDAO {
	
	public int insertFavorite(
			@Param("name") String name
			,@Param("url") String url
			);
	
	public List<Favorite> selectFavoriteList();
	
	
	public int selectCountUrl(
			@Param("url") String url // 명확하게 @Param annotation 붙여 주는 것이 좋음
			//String url 
			);
	
	public int deleteFavorite(
			@Param("id") int id
			);
	
	
}
