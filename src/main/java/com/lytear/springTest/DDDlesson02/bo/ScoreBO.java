package com.lytear.springTest.DDDlesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.springTest.DDDlesson02.dao.ScoreDAO;
import com.lytear.springTest.DDDlesson02.model.Score;

@Service
public class ScoreBO {

	
	@Autowired
	private ScoreDAO scoreDAO;
	
	public List<Score> getScoreList(int id) {
		
		
		return scoreDAO.selectScoreList(id);
	}
	
	
}
