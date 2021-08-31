package com.lytear.springTest.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@GetMapping("/add_favorite_view")// 웹사이트 그대로 들어가는 거니까 getMapping
	
	public String addUserView() {
		return "lesson06/addFavorite";
	}
	
	@PostMapping("/add_favorite")
	@ResponseBody // Map을 HTTP message converter가 json으로 변환시켜 준다
	// Ajax 니깐 string 아니라 json 형태 전달이 좋다
	public Map<String, String> addFavorite(
//	public String addUser(		
			@RequestParam("name") String name
			,@RequestParam("url") String url
			
			) {
		
		int count = favoriteBO.addFavorite(name, url);
		
		Map<String, String> result = new HashMap<>();
		
		// 성공 했을때 {"result" : "success"}
		// 실패 했을떄 {"result" : "fail"}
		if(count == 1) {
			result.put("result","success");
		} else {
			result.put("result","fail");
		}
		return result;
		
//		return "입력 성공 " + count ;
		
		
	}
	
	@GetMapping("/favorite_list")// 이동된 화면
	public String favoriteList( // jstl 연동되어야 하므로 jstl 리턴해 주는 String
			Model model) {

		List<Favorite> favoriteList = favoriteBO.getFavoriteList();
		// model 에 값 세팅하기. 키는 favoriteList, 뒤에 들어 가는 것은 "값"으로 위의 변수명 favoriteList 그대로 씀
		model.addAttribute("favoriteList",favoriteList);
		
		return "lesson06/favoriteList";
	}
	
	@GetMapping("/duplicate_Check")
	@ResponseBody
	public Map<String, Boolean> duplicateCheck(
			@RequestParam("url") String url
		
			) {
		
		Map<String, Boolean> result = new HashMap<>();
		
		if(favoriteBO.checkDuplicate(url)) {
			result.put("checkDuplicate",true);
		} else {
			result.put("checkDuplicate",false);
		}
		return result;
	}
	
	
	
	
}
