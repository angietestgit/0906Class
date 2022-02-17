package com.bitcamp.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bitcamp.jpa.member.domain.MemberEntity;
import com.bitcamp.jpa.member.domain.MemberRepository;

@SpringBootTest
class BootJpaApplicationTests {

	@Autowired
	MemberRepository repository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void 회원정보생성() {
		
		MemberEntity entity = MemberEntity.builder()
								.idx(111)
//								.userid("cool@gmail.com")
//								.password("1234")
//								.username("COOL")
//								.photo("starwars.png")
//								.regdate(new Date().toString())
								.role("ADMIN")
								.build(); // 객체 생성-빌드
		
		System.out.println(entity);
							
	}
	
	@Test //내부적으로 자동으로 만들어진 아이디 가져오는지
	void 회원정보생성및데이터가져오기() {
		
		MemberEntity entity = MemberEntity.builder()
				.idx(0) //생성된 0번째 가져오기
				.userid("cool@gmail.com")
				.password("1234")
				.username("COOL")
				.photo("starwars.png")
				.regdate(new Date().toString())
				.role("ADMIN")
				.build(); // 객체 생성-빌드
	
		repository.saveAndFlush(entity); //repository에 저장
		System.out.println("저장!");
		
		List<MemberEntity> list = repository.findAll(); //저장확인
		
		MemberEntity memberEntity = list.get(0);
		System.out.println(memberEntity);
				
		assertThat(memberEntity.getUserid()).isEqualTo("cool@gmail.com");
		assertThat(memberEntity.getRole()).isEqualTo("ADMIN");
		
		
		

		
	
	}
	

}
