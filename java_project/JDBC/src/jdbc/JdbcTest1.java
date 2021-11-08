package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest1 {
	public static void main(String[] args) {

		// 커넥션 개체 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// Dept 저장을 위한 List<Dept>
		List<Dept> list = new ArrayList<Dept>();
		
		
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

			// 3. 작업 : CRUD -> Statement객체 생성
			stmt = conn.createStatement();

			// Sql : select
			String sql = "select * from dept order by deptno";

			// Sql 실행
			rs = stmt.executeQuery(sql);

			// 반복을 통해 행단뒤 데이터 검색
			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString(2);
				String loc = rs.getString("loc");
				//System.out.println(deptno + "\t" + dname + "\t" + loc + "\n");
				Dept dept = new Dept(deptno, dname, loc);
				list.add(dept);
			}

			// Sql 실행
			rs = stmt.executeQuery(sql);

			// 4. 종료 : close()

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("데이터베이스에 연결할 수 없습니다. 연결 실패!");
			e.printStackTrace();
		} finally { // 예외와 상관없이 반드시 실행

			// 썼으면 순서대로 닫아주기
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();

				}
			}
			// stmt.close();

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}

			}
		}
	
		
	System.out.println("부서 리스트");
	System.out.println("-----------------------------");
	System.out.println("부서번호\t부서이름\t위치");
	System.out.println("-----------------------------");
	
	for(Dept dept : list) {
		System.out.println(dept);
	 
	}
	
	
	}
}