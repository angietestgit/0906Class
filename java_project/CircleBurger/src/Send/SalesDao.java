package Send;
// Sales sql처리하는 DAO클래스입니다.

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SalesDao {

	private SalesDao() {
	}

	// 클래스 내부에서 인스턴스 생성
	private static SalesDao dao = new SalesDao();

	// 내부에서 만들어진 인스턴스를 특정 메소드를 이용해서 받을 수 있도록 함
	static public SalesDao getInstance() {
		return dao;
	}

	// 1. showAllMenu() Connect 객체를 매개변수로 받아서 DB 내의 모든 상품을 저장하여 List<Sales> 로 만들어 반환
	public List<Sales> showAllMenu(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		List<Sales> result = new ArrayList<Sales>();

		try {
			// 결과 생성
			stmt = conn.createStatement();

			String sql = "select * from Sales";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				result.add(new Sales(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}

		} catch (SQLException e) {
			System.out.println("예외처리");
			e.printStackTrace();
		} finally {

		}

		return result;
	}

	
	// 2. outOfStock() : Connector , Sales 객체를 매개변수로 받아
	// 매개변수 Sales 상품에 들어가는 재료가 있는지 확인하고 충분하지 않다면 true반환
	public boolean outOfStock(Connection conn, int salesId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 검색 결과 : Sales정보
		Sales sales = null;

		// sql : select
		// 1. 해당 ? (상품이름)에 대해 재고에서 해당 상품에 들어가는 재고를 뺀 결과를 보내줌(Java 의 ResultSet에 저장용)
		String sql = "select ingre_stock-ingre_need from (select * from sales s1 natural join ingredient where s1.s_name = '?')";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, salesId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				sales = new Sales(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			}

			// 매개변수 Sales 상품에 들어가는 재료가 있는지 확인하고 충분하지 않다면 true반환
			while (rs.next()) {
				boolean check = false;

				if (rs.getInt(1) < 0) {
					check = true;
					break;
				}

				return check;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}

		return false;
	}
	

	// 3. recieveOrder() : Sales 객체를 매개변수로 받아 해당 상품의 재료가 재고에 충분한지 확인 후
	// 충분하다면 재고에서 필요 재료수만큼 재료 차감 (outOfStock 반환값이 true 일시 실행)
	public void recieveOrder(Connection conn, Sales sales) {
		PreparedStatement pstmt = null;

		// sql : select
		// 2. 해당 ?(상품이름) 필요재료를 재고에서 차감
		String sql = "update ingredient i1 set ingre_stock = ingre_stock - ingre_need where i1.s_id = (select s_id from sales s1 where s1.s_name = '?')";
		
		if (outOfStock(conn, sales.getProductId())) {
			System.out.println("재고가 없어 주문할 수 없습니다.");
			
		} else {

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sales.getProductName());
				pstmt.executeQuery();
			} catch (SQLException e) {

			}

		}
	}

}

