package com.bitcamp.op.member.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.EditRequest;
import com.bitcamp.op.member.domain.Member;

@Service
public class MemberEditService {

	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public Member getMember(int memberIdx) {
		// dao = template.getMapper(MemberDao.calss);
		return template.getMapper(MemberDao.class).selectByIdx(memberIdx);
		
	}
	
	public int editMember(
			EditRequest editRequest,
			HttpServletRequest request
			) {
		
		
		// 파일 저장
		
		dao = template.getMapper(MemberDao.class);
		
		
		return 0;
		
	}
	
	
}
