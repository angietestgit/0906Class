package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcPreparedTestStatementDMLTest {
	public static void main(String[] args) {

		// 커넥션 개체 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
//		Statement stmt = null;
//		ResultSet rs = null;

		try {
			// 1. 드라이버 로드
			Class.forName("Oracle.jdbc.driver.OracleDriver");

			// 2. 연결 : Connection
			// String jdbcUrl = "jdbc:oracle:thin:@[주소]:[포트]:[데이터 베이스]";
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String pw = "tiger";

			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			System.out.println("데이터베이스 연결 성공!");

			// 3. 작업 : CRUD
			
			String sql = "insert into dept values (?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  90);
			pstmt.setString(2, "DEV");
			pstmt.setString(3, "PUSAN");
			
			// DML 실행
			int resultCnt = pstmt.executeUpdate();
			
			if(resultCnt > 0 ) {
				System.out.println("입력되었습니다.");
			} else  {
				System.out.println("입력실패!(조건에 합당하는)");
			}
			
			// 4. 종료 : close()
			

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("데이터베이스에 연결할 수 없습니다. 연결 실패!");
			e.printStackTrace();
		} finally { // 예외와 상관없이 반드시 실행

			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 썼으면 순서대로 닫아주기
			// rs.close();
			// stmt.close();

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}

			}
		}
	}
}