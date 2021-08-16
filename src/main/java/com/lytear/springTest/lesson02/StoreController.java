package com.lytear.springTest.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lytear.springTest.lesson02.bo.StoreBO;
import com.lytear.springTest.lesson02.model.Store;// 내가 만든 것을 import 한다

@Controller
public class StoreController {

	@Autowired
	private StoreBO storeBO;
	
	@RequestMapping("/lesson02/test01")
	// RestController 아닌 Controller는 Responsebody를 통해서 HTTpmessage converter를 타도록 한다
	@ResponseBody
	public List<Store> test01() {
		
		return storeBO.getStoreList();
	}
	
	
	
	
}
