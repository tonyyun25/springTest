package com.lytear.springTest.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lytear.springTest.lesson04.model.Realtor;
import com.lytear.springTest.lesson06.bo.FavoriteBO;
import com.lytear.springTest.lesson06.model.Favorite;

@Controller
@RequestMapping("/lesson06")
public class FavoriteListController {

	
	@Autowired
	private FavoriteBO favoriteBO;
	
	@GetMapping("/insert_user_view")// 이동된 화면
	public String insertUserView(
			Model model) {

		List<Favorite> favoriteList = favoriteBO.getFavoriteList();
		model.addAttribute("favoriteList",favoriteList);
		
		return "lesson06/insertNewUser";
	}
	
	
	
}
