package com.lytear.springTest.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lytear.springTest.lesson06.bo.FavoriteBO;
import com.lytear.springTest.lesson06.model.Favorite;

@Controller
@RequestMapping("/lesson06")
public class FavoriteController {
	/*
	 * 1. Required request parameter 'name' for method parameter type String is not present
	 * 원인 : jsp에서 input box name 미입력, jsp 추가를 input 속성 입력했으나 value 지정 안 함, xml
	 *  values 에서 #이 아닌 EL tag 사용
	 * 
	 * 
	 * */
	@Autowired
	private FavoriteBO favoriteBO;
	
	@GetMapping("/add_user_view")
	
	public String addUserView() {
		return "lesson06/addNewUser";
	}
	
	@PostMapping("/add_user")
	@ResponseBody
	public Map<String, String> addUser(
//	public String addUser(		
			@RequestParam("name") String name
			,@RequestParam("url") String url
			
			) {
		
		int count = favoriteBO.addUser(name, url);
		
		Map<String, String> result = new HashMap<>();
		if(count == 1) {
			result.put("result","success");
		} else {
			result.put("result","failure");
		}
		return result;
		
//		return "입력 성공 " + count ;
		
		
	}
	
	
	
	
}
