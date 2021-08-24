package com.lytear.springTest.DDDlesson02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lytear.springTest.DDDlesson02.model.Score;

@Repository
public interface ScoreDAO {
	
	public List<Score> selectScoreList(@Param("id") int id);
	
	
}
