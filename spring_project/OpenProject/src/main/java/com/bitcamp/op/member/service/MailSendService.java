package com.bitcamp.op.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailSendService {

	public int send(String subject, String content, String email) {
		return 0;
	}
	
	@Autowired
	private JavaMailSender sender;
	
	public int send(String subject, String content, String email) {
		return 0;
	}
	
	public int send(String email) {
		
		int resultCnt = 1;
		
		MimeMessage message = sender.createMimeMessage();
		
		try {
			
			// 메일 제목
			message.setSubject("[안내] 회원 가입을 축하합니다.", "utf-8");
		
			// 메일 내용 : html
			String html = "<h1>회원가입을 축하합니다.</h1>";
			html += "<a href=\"http://www.naver.com\">네이버</a> <br>";
			html += "<a href=\"http://localhost:8080/op\">오픈프로젝트 가기</a> <br>";

			// from : 보내는 사람 설정, 구글 정책은 setFrom 이 적용되지 않는다.
			message.setFrom(new InternetAddress("cool@naver.com"));
			
			// to : 받는 사람의 이메일 설정
			message.addRecipient(RecipientType.TO, new InternetAddress(email, userName+님, charset ))
			
			// 메일 발송
			sender.send(message);
			
			// 가입 메일 발송
			if(senderService.mail)
			
		} catch (MessagingException e) {
			
		}
				
		
		
		
		return 0;
	}
	
	public int send(String[] emails) {
		return 0;
	}
	
}
