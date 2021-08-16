package com.lytear.springTest.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
@RequestMapping("/lesson01/test02")

public class Test02Controller {

// http://localhost:8080/lesson01/test02/1
	@RequestMapping("/1")
	public List<Map<String, Object>> movieList() {
	// 여러 개의 형태가 들어갈 때는 부모 형태 Object로 잡아주면 둘 다 적용 가능
	// 밸류의 타입은 여러 형태기 때문에 Object로 잡음
	// 지금은 맵을 생성하는 게 아니라 맵들을 저장할 ArrayList를 생성
		List<Map<String, Object>> movieList = new ArrayList<>();
	
		Map<String, Object> movie = new HashMap<>();
		movie.put("title", "기생충");
		movie.put("director", "봉준호");
		movie.put("time", 131);
		movie.put("rate", 15);
		// 맵을 만든 이유 : 리스트에 저장하기 위해서
		movieList.add(movie);
		
		movie = new HashMap<>(); // 아까 만들었던 movie는 새로운 객체로 사용 X (리스트에만 저장) 지금 형태로만 사용
		// 변수 이름 똑같다고 헷갈리지 마세요. 완전 다른 객체를 리스트에 하나하나 차곡차곡 쌓는 것
		movie.put("title", "인생은 아름다워");
		movie.put("director", "로베르토 베니니");
		movie.put("time", 116);
		movie.put("rate", 0);
		movieList.add(movie);
		
		movie.put("title", "인생은 아름다워");
		movie.put("director", "로베르토 베니니");
		movie.put("time", 116);
		movie.put("rate", 0);
		movieList.add(movie);
		
		movie.put("title", "인생은 아름다워");
		movie.put("director", "로베르토 베니니");
		movie.put("time", 116);
		movie.put("rate", 0);
		movieList.add(movie);
		
		movie.put("title", "인생은 아름다워");
		movie.put("director", "로베르토 베니니");
		movie.put("time", 116);
		movie.put("rate", 0);
		movieList.add(movie);
		return movieList;// 맵은 순서가 없으므로 그냥 출력
		
	}
	
// 	http://localhost:8080/lesson01/test02/2
	
	@RequestMapping("/2")
	
//	public List<BoardContent> boardList = new ArrayList<>();
	// 이제 메소드를 만드는 과정
	public List<BoardContent> boardList() {
		List<BoardContent> boardList = new ArrayList<>();
		
		BoardContent content = new BoardContent();
		content.setTitle("안녕하세요 가입인사 드립니다.");//게터 세터 만들었기 때문에 내가 만든 내용이 객체 안의 변수로 바뀐다
		content.setUser("hagulu");
		content.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다.");
		boardList.add(content);
		
		content = new BoardContent();// 이번에도 변수를 재사용. 여기에다 새로운 객체를 사용
		content.setTitle("헐 대박");
		content.setUser("hagulu");
		content.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다.");
		boardList.add(content);
		
		
		return boardList;
	}
	
	@RequestMapping("/3")
	public ResponseEntity<BoardContent> entity() {
		BoardContent content = new BoardContent();
		content.setTitle("안녕하세요 가입인사 드립니다.");
		content.setUser("hagulu");
		content.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다.");
		// 리턴할 결과 만들기
		ResponseEntity<BoardContent> entity = new ResponseEntity<>(content, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
		
		
	}
	// Handler mapping이 우리가 요청한 url을 기반으로 일치하는 controller
	/*
	 * Spring: servlet과 달리 큰 규모 PJT 관리하기 위해 만들어진 프로그램. 그 툴이 gradle로 매우 중요한 개념
	 * gradle : 각종 라이브러리를 간단하게 포함시킨다, 빌드 과정을 손쉽게 셋팅할 수 있다. 비슷한 기능으로 Maven 있음. 완벽한 
	 *  프로그램을 만들어주게 관리. 이게 없음 이클립스 설정 들어가 하나씩 다 맞춰줘야 함
	 *  Maven보다 훨씬 속도 빨라. 복잡한 빌드 셋팅과 라이브러리 셋팅을 간편하게 해 준다
	 *  
	 *  
	 *  
	 *  
	 *  
	 * */
	
	
}
