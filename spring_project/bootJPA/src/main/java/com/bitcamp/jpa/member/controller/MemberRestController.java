package com.bitcamp.jpa.member.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.jpa.member.domain.MemberEntity;
import com.bitcamp.jpa.member.domain.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //2 lombok이 생성자를 대신만들어줌
@RestController //response body 생략가능 <->타임리프가지고 화면 만들경우 rest쓰면 안됨!
@RequestMapping("/api/member")
public class MemberRestController {

	//1 @Autowired 요즘엔 안쓰고 아래처럼생성해줌
	private final MemberRepository repository;
	//2 final 쓰면 상수의미 생성자에서 무조건 초기화처리 -> 아래처럼 안쓰고 lombok처리
	
	
	//1 @안써도 주입 가능~~!
//	public MemberRestController(MemberRepository repository) {
//		this.repository = repository;
//	}
	
	// 전체 리스트 출력
	@GetMapping
	public List<MemberEntity> getMemberList(){
		
		
		return repository.findAll();
	}
	
	@PostMapping
	public String memberInsert() {
		
		MemberEntity entity = MemberEntity.builder()
				.idx(0) //생성된 0번째 가져오기
				.userid("cool@gmail.com")
				.password("1234")
				.username("COOL")
				.photo("starwars.png")
				.regdate(new Date().toString())
				.role("ADMIN")
				.build(); // 객체 생성-빌드
		
		return repository.saveAndFlush(entity).toString(); 
	
	}
	
	
	@GetMapping("/{idx}")
	public Optional<MemberEntity> getMember(@PathVariable("idx") Long idx) {
		
		return repository.findById(idx);
	}
	
	@PutMapping("/{idx}")
	public String memberUpdate(@PathVariable("idx") Long idx) {
		
		MemberEntity entity = MemberEntity.builder()
				.idx(idx)
				.userid("hot@gmail.com")
				.password("0000")
				.username("HOT")
				.photo("mini1.png")
				.regdate(new Date().toString())
				.role("MEMBER")
				.build(); // 객체 업데이트-빌드
		
		return repository.saveAndFlush(entity).toString(); 
		
	}
	
	@DeleteMapping("/{idx}")
	public void memberDelete(@PathVariable("idx") Long idx) {
		//MemberEntity entity = MemberEntity.builder().idx(idx).build();
		repository.delete(MemberEntity.builder().idx(idx).build());
	}
}
