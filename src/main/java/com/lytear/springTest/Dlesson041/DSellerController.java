package com.lytear.springTest.Dlesson041;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lytear.springTest.Dlesson041.bo.DSellerBO;
import com.lytear.springTest.Dlesson041.model.DSeller;

@Controller
@RequestMapping("/Dlesson041/test01")
public class DSellerController {

/*	1. This application has no explicit mapping for /error, so you are seeing this as a fallback.
	안 된 이유 : xml에서 파라미터로 id를 받게 했음
	2. DSeller dSeller = dSellerBO.add_seller();에서 add_seller에 빨간 줄
	The method add_seller(String, String, double) in the type DSellerBO is not applicable for the arguments ()
java.lang.Error: Unresolved compilation problem: 
	lastUser 보여주는 BO 메소드를 안 만들었음
	3. Invalid bound statement (not found): com.lytear.springTest.Dlesson041.dao.DSellerDAO.selectLastUser
	: xml에서 select id 오타
	4. Operand should contain 1 column(s) ### The error may exist in file [C:\Users\01.Web개발\springTest\workspaceTest\SpringTest\bin\main\mappers\DsellerMapper.xml] 
	: xml select 문 칼럭이름 들 바깥에 괄호로 묶어 오류 발생
	5. This application has no explicit mapping for /error, so you are seeing this as a fallback.
	Sat Aug 21 16:51:07 KST 2021
	There was an unexpected error (type=Not Found, status=404).
	No message available
	: 구글 주소창에 url 주소를 Dlesson04로 잘못 입력	
	6. Invalid bound statement (not found): com.lytear.springTest.Dlesson041.dao.DSellerDAO.selectUser
	: xml 쿼리 미입력
	
	
	
	
	
	*/
	
	@RequestMapping("/1")
	public String addSellerView() {
		return "lesson04/Dseller";
	}
	

	@Autowired
	private DSellerBO dSellerBO;
	@GetMapping("/2")
	@ResponseBody
	
	public String add_seller(
			@RequestParam("nickname") String nickname
			,@RequestParam("profileImageUrl") String profileImageUrl
			,@RequestParam("temperature") double temperature
			) {
		int count = dSellerBO.add_seller(nickname, profileImageUrl, temperature);
		
		
		return "입력 성공 : " + count;
	}
	
	@GetMapping("/3")
	public String sellerInfo(Model model) {
		DSeller seller = dSellerBO.getLastUser();
		model.addAttribute("subject", "판매자 정보");
		model.addAttribute("result", seller);
			
		return "lesson04/DsellerInfo";
	}
	
	@GetMapping("/4")
	public String sellerInfo(Model model
			,@RequestParam(value="id", required=false) Integer id
			) {
		DSeller seller = null;
		if(id!=null) {
			seller = dSellerBO.getUser(id);
		} else {
			seller = dSellerBO.getLastUser();
		}
		model.addAttribute("subject", "판매자 정보");
		model.addAttribute("result", seller);
			
		return "lesson04/DsellerInfo";
	}	
	
	
	
	
}
