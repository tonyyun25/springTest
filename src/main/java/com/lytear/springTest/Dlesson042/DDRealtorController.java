package com.lytear.springTest.Dlesson042;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lytear.springTest.Dlesson042.bo.DDRealtorBO;
import com.lytear.springTest.Dlesson042.model.DDRealtor;

@Controller
@RequestMapping("/Dlesson042/test02")
public class DDRealtorController {
	/* 1. Could not set parameters for mapping: ParameterMapping{property='office', mode=IN, 
	 * javaType=class java.lang.Integer, jdbcType=null, numericScale=null, 
	 * resultMapId='null', jdbcTypeName='null', expression='null'}. Cause: 
	 * org.apache.ibatis.type.TypeException: Error setting non null for parameter
	 *  #1 with JdbcType null .
	 * : xml parameterType="int" 로 잘못 정의함
	 * 
	 * 2. There was an unexpected error (type=Internal Server Error, status=500).
	Mapper method 'com.lytear.springTest.Dlesson042.dao.DDRealtorDAO.insertRealtor' 
	has an unsupported return type: class com.lytear.springTest.Dlesson042.model.DDRealtor
	 * : BO, DAO 메소드 리턴 타입을 DDRealtor로 잘못 입력
	 * 
	 * */
	@GetMapping("/1")
	public String addRealtorview() {
		return "lesson04/DDaddRealtor";
	}
	
	@Autowired
	private DDRealtorBO ddRealtorBO;
	
	@GetMapping("/2")
	public String getRealtor(
			@ModelAttribute DDRealtor ddRealtor
			, Model model
			) {
		
		ddRealtorBO.addRealtor(ddRealtor);
		model.addAttribute("result", ddRealtor);
		
		return "lesson04/DDrealtorInfo";
	}
	
}
