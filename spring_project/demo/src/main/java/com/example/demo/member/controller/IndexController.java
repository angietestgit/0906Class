package com.example.demo.member.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.member.domain.Member;
import com.example.demo.member.mapper.MemberDao;

@RestController
public class IndexController {

	private MemberDao dao;
	
	private SqlSessionTemplate template;
	
	@RequestMapping("/")
	public String getIndex() {
		return "index";
		//return "INDEX Page";
	}
	
	@RequestMapping("members")
	public String getList(
			Model model
			){
				model.addAttribute("memberList", template.getMapper(MemberDao.class).selectList(null));
				return "member/list";

			
		
		//return template.getMapper(MemberDao.class).selectList(null);
	}
}
