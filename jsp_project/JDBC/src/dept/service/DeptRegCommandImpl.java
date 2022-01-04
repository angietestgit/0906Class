package dept.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDao;
import dept.domain.Dept;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class DeptRegCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		//<< 순서 >>
		// 1. 사용자가 입력한 데이터를 받고
		// 2. Dept 객체를 생성
		// 3. Dao insert 메소드로 입력 처리
		// 4. 결과 반환
		// 5. request 속성에 저장
		//===============================
		
		String view = null;
		
		if(request.getMethod().equals("GET")) {
			
			// 전송방식 확인
			System.out.println(request.getMethod());
			
			view = "/WEB-INF/views/dept/regform.jsp";
			
		} else if(request.getMethod().equals("POST")) {
			
			// 전송방식 확인
			System.out.println(request.getMethod());
			
			// post 방식에서 한글처리
			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			// 1. 사용자가 입력한 데이터를 받고
			String deptno = request.getParameter("deptno");
			String dname = request.getParameter("dname");
			String loc = request.getParameter("loc");
			
			// 2. Dept 객체를 생성
			Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
			
			// 3. Dao insert 메소드로 입력 처리
			Connection conn = null;
			
			int regCnt = 0; 
			
			try {
				conn = ConnectionProvider.getConnection();
				
				// 4. 결과 반환
				regCnt = DeptDao.getInstance().insertDept(conn, dept);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn);
			}
			
			// 5. request 속성에 저장
			request.setAttribute("result", regCnt);
			request.setAttribute("dept", dept);			
			
			view = "/WEB-INF/views/dept/reg.jsp";
			
		}		
		
		return view;
		// return "/WEB-INF/views/dept/reg.jsp";
	}
	

}
