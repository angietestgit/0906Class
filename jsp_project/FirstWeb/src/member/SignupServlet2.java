package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/Signup", "/signup" })
public class SignupServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// post 방식으로 데이터를 받을 때 한글 인코딩 처리!!! 필수!!!
		request.setCharacterEncoding("utf-8");

		// 사용자가 입력한 userid, pw를 받아서 응답 메시지에 포함해서 처리
		// 데이터 받기
		String uid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String pwCheck = request.getParameter("pwCheck");
		String username = request.getParameter("username");
		String comment = request.getParameter("comment");
		String gender = request.getParameter("gender");
		
		String[] interests = request.getParameterValues("interest");
		
		String byear = request.getParameter("byear");
		
		// 응답 하는 데이터의 타입
		response.setContentType("text/html; charset=utf-8");
		//response.setContentType("application/doc; charset=utf-8");
		
//		System.out.println("userid: " + uid);
//		System.out.println("pw: " + pw);
//		System.out.println("pwCheck: " + pwCheck);
//		System.out.println("username: " + username);

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<head>");
		out.println("		<meta charset=\"utf-8\">");
		out.println("		<title>데이터 확인</title>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("		<h1>");
		out.println("			User ID: " + uid + "<br>");
		out.println("			Password: " + pw + "<br>");
		out.println("			Name: " + username + "<br>");
		out.println("			comment : " + comment +  "<br>");
		out.println("			gender : " + gender +  "<br>");
		
		if(interests != null) {
			for(int i=0; i<interests.length; i++) {
				out.println("			interest : " + interests[i] +  "<br>");
			}
		} else {
			out.println("			interest : 선택된 관심사가 없습니다.<br>");
		}
		
		out.println("			byear : " + byear +  "<br>");
		
		out.println("		</h1>");
		out.println("	</body>");
		out.println("</html>");

	}

	// 사용자가 요청할 때 Post 방식으로 요청 해쓸 때 처리되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Post 방식으로 요청처리!!!");
		doGet(request, response);
	}

}
