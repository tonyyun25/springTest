package com.lytear.springTest.Dlesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lytear.springTest.Dlesson06.bo.DfavoriteBO;

@Controller
@RequestMapping("/Dlesson06")
public class DFavoriteController {

	@Autowired
	private DfavoriteBO dfavoriteBO;
	
	@RequestMapping("/addFavorite")
	public String add_favorite() {
		return "lesson06/Dadd_favorite";
	}
	
	@RequestMapping("addResult")
	public String add_result(
			@RequestParam("name") String name
			,@RequestParam("url") String url
			
			) {
		
		int count = dfavoriteBO.addFavorite(name, url);
		
		return "추가 성공" + count;
		
	}
	
	
	
	
}
