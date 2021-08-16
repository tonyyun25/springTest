package com.lytear.springTest.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.springTest.lesson02.dao.StoreDAO;
import com.lytear.springTest.lesson02.model.Store;

@Service//Spring bean(객체를 Spring이 자동생성하기 위해 등록해 주는 것)으로 등록하는 역할을 수행.
//@Controller, @Repository로 마찬가지 => 우리가 객체 생성해 버리면 수십만이 프로그램을 사용할 때 객체 무진장
//많이 만들어버리면 서버에 부하가 고스란히 전달. So SPring bean 등록하면 Spring에서 직접 객체 관리를 효율적으로 해 줌
// Spring bean으로 등록하면 싱글턴 형태로 사용됨
// DI, IoC, POJO 어려운 개념. Spring 마무리 될 때 쯤 공부해 두면 좋아

/*Mybatis 심화
 * 
 * DAO의 @Param("id")에 세팅된 값이 xml에서 가져오는 값이다
 * 
 * 
 * 
 * 
 * */


public class StoreBO {

	@Autowired
	private StoreDAO storeDAO;
	
	public List<Store> getStoreList() {
		return storeDAO.selectStoreList();
	}
	
	
	
}
