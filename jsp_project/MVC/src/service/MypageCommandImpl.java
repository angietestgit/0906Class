package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MypageCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		// 사용자 페이지 MyPage는 로긩ㄴ 상태에서만 데이터 처리를 해준다!!!
		// 세션 페크 : sission 속성에 loginInfo 가 존재하는지 확인
		
		boolean loginChk = 	request.getSession().getAttribute("loginInfo") != null;

		if(loginChk) {
			// 결과 데이터를 생성
			String msg = "마이페이지에는 사용자 정보를 출력합니다."; 
			// request 속성에 데이터 저장
			request.setAttribute("msg", msg);
			
		}
		
		request.setAttribute("loginChk", loginChk);
		
		return "/WEB-INF/views/member/mypage.jsp";
	}

}
