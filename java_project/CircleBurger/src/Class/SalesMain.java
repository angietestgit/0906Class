package Class;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dept.ConnectionProvider;
import dept.Dept;
import dept.DeptDao;

public class SalesMain {
	public static void main(String[] args) {

		SalesDao SalesDao = SalesDao.getInstance();

		
Connection conn =null;
		
		List<Dept> list = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			
			// 트렌젝션 일의 단위
			conn.setAutoCommit(false); // 트렌젝션의 컨트롤 하겠다!
			
} catch (SQLException e) {
	
	try {
		conn.rollback();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	// TODO Auto-generated catch block
	e.printStackTrace();
	
	
}
}
