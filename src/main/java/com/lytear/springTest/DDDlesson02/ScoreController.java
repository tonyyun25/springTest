package com.lytear.springTest.DDDlesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lytear.springTest.DDDlesson02.bo.ScoreBO;
import com.lytear.springTest.DDDlesson02.model.Score;


@Controller
public class ScoreController {

	@Autowired
	private ScoreBO scoreBO;
	
	
	@RequestMapping("/lesson02/DDDtest01")
	@ResponseBody
	
	
	public List<Score> DDDtest01 (@RequestParam("id") int id) {
		
		
		return scoreBO.getScoreList(id);
	}
	
}
