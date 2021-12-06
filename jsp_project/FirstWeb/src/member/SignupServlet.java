package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/Signup", "/signup" })
public class SignupServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 사용자가 입력한 userid, pw를 받아서 응답 메시지에 포함해서 처리
		String uid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String pwCheck = request.getParameter("pwCheck");
		String username = request.getParameter("username");
		System.out.println("userid: "+uid);
		System.out.println("pw: "+pw);
		System.out.println("pwCheck: "+pwCheck);
		System.out.println("username: "+username);

	    PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<head><title>파라미터 데이터 받기</title></head>");
		out.println("	<body>");
		out.println("		<h1>");
		out.println("			User ID: " + uid + "<br>");
		out.println("			Password: " + pw + "<br>");
		out.println("			Name: " + username + "<br>");
		out.println("		</h1>");
		out.println("	</body>");
		out.println("</html>");
	
	}

	// 사용자가 요청할 때 Post 방식으로 요청 해쓸 때 처리되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post 방식으로 요청처리!!!");
		doGet(request, response);
	}

}
