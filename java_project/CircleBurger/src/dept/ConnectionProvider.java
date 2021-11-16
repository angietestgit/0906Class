package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	//효율적인 메소드(자주사용하는 공통코드라서 메소드로 따로 빼둠)
	public static Connection getConnection() throws SQLException {
		
		// String jdbcUrl = "jdbc:oracle:thin:@[주소]:[포트]:[데이터 베이스]";
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String pw = "tiger";

		return DriverManager.getConnection(jdbcUrl, user, pw);
	}

}
