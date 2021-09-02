package com.lytear.springTest.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lytear.springTest.lesson06.model.Booking;
@Repository
public interface BookingDAO { // 다른 회사에서는 키워드를 DAO가 아니라 Repo라고 쓸 수도 있다

	public List<Booking> selectBookingList();
	
	public int deleteBooking(
			@Param("id") int sam // 삭제 성공. xml에 전달될 때의 형태가 @Param(이 안)
//			@Param("id") int id 도 삭제 성공
//			@Param("id") int bookListId도 삭제 성공
//			@Param("bookListId") int id 는 에러 발생
			
//			2. 매칭해야하는 부분 만 매칭 되면.되고 그외에는 달라도 관계 없습니다
// 			컨트롤러의 파라미터와 다오의 파라미터는 서로 관계가 없기 때문에 이름이 같을 필요는 없습니다
//			결론 : @Param() 안에 있는 파라미터만 DB의 칼럼명과 동일하게(여기서는 "id") 적어주면 되고 뒤에 int 명은 아무렇게나 써도 무관
			
			);
	
	public int insertBooking(
			@Param("name") String name
			,@Param("date") String date 
			,@Param("day") int day 
			,@Param("headcount") int headcount 
			,@Param("phoneNumber") String phoneNumber 
			,@Param("state") String state
			);
	
	
	
	
	
	
}
