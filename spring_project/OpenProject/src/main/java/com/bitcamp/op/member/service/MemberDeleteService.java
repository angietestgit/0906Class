package com.bitcamp.op.member.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.Member;

@Service
public class MemberDeleteService {
	
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int deleteMember(int memberidx, HttpServletRequest request) {
		
		int resultCnt = 0;
		
		dao = template.getMapper(MemberDao.class);
		
		Member member = dao.selectByIdx(memberidx);
		
		if(member != null) {
			resultCnt = dao.deleteByIdx(memberidx);
						
			// 회원의 파일을 삭제
			if(member.getPhoto() != null && !member.getPhoto().equals("starwars.png")) {
				
				String savePath = request.getSession().getServletContext().getRealPath(CommonsData.SAVE_URI);
				File file = new File(savePath, member.getPhoto());
			
				if(file.exists()) {
					file.delete();
				}
			
			}
			
		}
		
		

		
		
		return resultCnt;
		
	}
	
	
}
