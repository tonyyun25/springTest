package com.lytear.springTest.Dlesson06.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DfavoriteDAO {

	
	public int insertFavorite(
			@Param("name") String name
			,@Param("url") String url
			);
	
}
