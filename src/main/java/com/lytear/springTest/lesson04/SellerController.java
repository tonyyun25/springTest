package com.lytear.springTest.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lytear.springTest.lesson04.bo.SellerBO;

import com.lytear.springTest.lesson04.model.Seller;

@RequestMapping("/lesson04")
@Controller
public class SellerController {

	@RequestMapping("/test01/1")
	
	public String add_seller() {
		return "lesson04/addSeller";
	}
	
	/*
	 * 첫번째 에러: This application has no explicit mapping for /error, so you are seeing this as a fallback.
	 * 
	 * */
	
	
	@Autowired
	private SellerBO sellerBO;
	
	@GetMapping("/test01/add_seller")
	@ResponseBody
	public String add_seller(
				@RequestParam("nickname") String nickname
				,@RequestParam("profileImageUrl") String profileImageUrl 
				,@RequestParam("temperature") double temperature 
			) {
		
		int count = sellerBO.add_seller(nickname, profileImageUrl, temperature);
		return "입력 성공 : " + count;
		
	}
	
//	@GetMapping("/test01/2")
//	
//	public String sellerInfo(Model model ) {//jsp에 이 정보 전달 위해서 model이라는 파라미터 추가
//		Seller seller = sellerBO.getLastSeller();//리턴하면 된다. 리턴할 것은 jsp 경로 뿐
//		model.addAttribute("result",seller);//키와 밸류 형태로 저장
////		model.addAttribute("subject","판매자정보");
//		return "lesson04/sellerInfo";
//	}
	
	// 똑같은 주소를 다른 메소드에서 구현 불가. id 있을 때(id로 검색한 내용), 없을 때 (가장 최근 등록된 사용자목록)
//	controller만 하나의 메소드. 메소드가 같다고 BO, DAO도 똑같아야 되는 건 아님
	
//	@Autowired
//	private SellerIdBO sellerIdBO;
//	
//	@RequestMapping("/test03")
//	@ResponseBody
//	public Seller getIdUser(
//			@RequestParam(value="id", defaultValue="1") int id
//			) {
//		return sellerIdBO.getIdUser(id);
//	}
	// id가 없을 때는 기존처럼 lastuser 보여 줌
	
//	@GetMapping("/test01/3")
//	public String getIdUser(//수업 : String getSeller
//			Model model
//			,@RequestParam(value="id", defaultValue="1") int id
//			
//			) {
//		Seller sellerId = sellerIdBO.getIdUser(id);
//		model.addAttribute("result", sellerId);
//		model.addAttribute("subject", "판매자 정보");
//		return "lesson04/sellerInfo";
//	}
	
	@GetMapping("/test01/2")
	
	public String sellerInfo(
			@RequestParam(value="id", required = false) Integer id//id 없으면 에러 : (value="id", required = false) => 
//			기본 자료형이 아니라 래퍼 스타일로 적어줘야 id 없을 경우에는 null로 잡아 줌
			, Model model ) {//jsp에 이 정보 전달 위해서 model이라는 파라미터 추가
//		Seller seller = sellerBO.getLastSeller();//리턴하면 된다. 리턴할 것은 jsp 경로 뿐
		
//		Seller seller = sellerBO.getSeller(id);
		Seller seller = null;
		
		if(id == null) {
			seller = sellerBO.getLastSeller();	
		} else {
			seller = sellerBO.getSeller(id);	
		}
		
		model.addAttribute("result",seller);//키와 밸류 형태로 저장
//		model.addAttribute("subject","판매자정보");
		return "lesson04/sellerInfo";
	}
	
	/*
	 * 
	 * */
	
	
}
