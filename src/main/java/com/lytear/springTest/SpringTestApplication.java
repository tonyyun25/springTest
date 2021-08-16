package com.lytear.springTest;



import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@MapperScan(basePackages = "com.lytear.springTest.*")//DAO들을 가져다가 한 꺼번에 처리할 수 있도록
//DAO의 위치를 지정
public class SpringTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTestApplication.class, args);
	}
//	@Bean
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource);
//		// 아래 getResources 뒤에 (어떤 값을 가져오겠다 ) 경로 잡아주는 것이 중요. 쿼리 수행할 놈들의 경로
//		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
// 		sessionFactory.setMapperLocations(res);
//		
//		return sessionFactory.getObject();
//	}
//	
	
}
