package kioskProjectTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Jdbc_SalesDAO {

	private Jdbc_SalesDAO() {
	}

	// 클래스 내부에서 인스턴스 생성
	private static Jdbc_SalesDAO dao = new Jdbc_SalesDAO();

	// 내부에서 만들어진 인스턴스를 특정 메소드를 이용해서 받을 수 있도록 함
	static public Jdbc_SalesDAO getInstance() {
		return dao;
	}

	// 1. showAllMenu() 모든 상품을 리스트로 저장해서 반환
	public List<VO_Sales> sendAllMenu() {
		String sql = "select * from sales";
		Connection conn = null;
		ResultSet rs = null;
		Statement stm = null;
		List<VO_Sales> salesList = new LinkedList<VO_Sales>();

		try {
			conn = Jdbc_ConPrivider.getConnection();
			stm = conn.createStatement();

			rs = stm.executeQuery(sql);

			while (rs.next()) {

				VO_Sales sales = new VO_Sales(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6));
				salesList.add(sales);
			}

		} catch (SQLException e) {

		} finally {
			Jdbc_Closer.close(rs);
			Jdbc_Closer.close(stm);
			Jdbc_Closer.close(conn);
		}

		return salesList;

	}

	// 2. outOfStock() : Connector , VO_Sales 객체를 매개변수로 받아
	// 매개변수 VO_Sales 상품에 들어가는 재료가 있는지 확인하고 충분하지 않다면 true반환
	public boolean outOfStock(Connection conn, VO_Sales sales) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// sql : select
		// 1. 해당 ? (상품이름)에 대해 재고에서 해당 상품에 들어가는 재고를 뺀 결과를 보내줌(Java 의 ResultSet에 저장용)
		String sql = "select ingre_stock-ingre_need from (select * from VO_Sales s1 natural join ingredient where s1.s_name = '?')";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sales.getProductName());

			rs = pstmt.executeQuery();

			// 매개변수 VO_Sales 상품에 들어가는 재료가 있는지 확인하고 충분하지 않다면 true반환
			while (rs.next()) {
				boolean check = false;

				if (rs.getInt(1) < 0) {
					check = true;
					break;
				}

				return check;
			}

		} catch (SQLException e) {
			System.err.println("일시적인 오류입니다.");
		} finally {
			Jdbc_Closer.close(rs);
			Jdbc_Closer.close(pstmt);

		}

		return false;
	}

	// 3. recieveOrder() : VO_Sales 객체를 매개변수로 받아 해당 상품의 재료가 재고에 충분한지 확인 후
	// 충분하다면 재고에서 필요 재료수만큼 재료 차감 (outOfStock 반환값이 true 일시 실행)
	public void recieveOrder(Connection conn, VO_Sales sales) {
		PreparedStatement pstmt = null;

		// sql : select
		// 2. 해당 ?(상품이름) 필요재료를 재고에서 차감
		String sql = "update ingredient i1 set ingre_stock = ingre_stock - ingre_need*? where i1.s_id = (select s_id from VO_Sales s1 where s1.s_name = '?')";

		if (outOfStock(conn, sales)) {
			System.err.println("재고가 없어 주문할 수 없습니다.");

		} else {

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, sales.getQuantity());
				pstmt.setString(2, sales.getProductName());
				pstmt.executeQuery();

			} catch (SQLException e) {
				System.err.println("일시적인 오류입니다.");
			} finally {
				Jdbc_Closer.close(pstmt);
			}

		}
	}

	// 노인을 위한 추천메뉴 햄버거를 리스트로 저장해서 반환
	public List<VO_Sales> recoHamburgerForTheOld() {
		String sql = SQLQuery.showHamburgerForTheOld;

		Connection conn = null;
		ResultSet rs = null;
		Statement stm = null;

		List<VO_Sales> salesList = new LinkedList<VO_Sales>();

		try {
			conn = Jdbc_ConPrivider.getConnection();
			stm = conn.createStatement();

			rs = stm.executeQuery(sql);

			while (rs.next()) {

				VO_Sales sales = new VO_Sales(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6));
				salesList.add(sales);
			}

		} catch (SQLException e) {

		} finally {
			Jdbc_Closer.close(rs);
			Jdbc_Closer.close(stm);
			Jdbc_Closer.close(conn);
		}

		return salesList;
	}
	
	
	// 추천버거 9개에 대한 DAO (나중에 showHamburger 쿼리문 바꿔야됨!)
	public List<VO_Sales> recoHamburgerForAll() {
		String sql = SQLQuery.showHamburger;

		Connection conn = null;
		ResultSet rs = null;
		Statement stm = null;

		List<VO_Sales> salesList = new LinkedList<VO_Sales>();

		try {
			conn = Jdbc_ConPrivider.getConnection();
			stm = conn.createStatement();

			rs = stm.executeQuery(sql);

			while (rs.next()) {

				VO_Sales sales = new VO_Sales(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6));
				salesList.add(sales);
			}

		} catch (SQLException e) {

		} finally {
			Jdbc_Closer.close(rs);
			Jdbc_Closer.close(stm);
			Jdbc_Closer.close(conn);
		}

		return salesList;
	}

	// 추천메뉴 음료를 리스트로 저장해서 반환
	public List<VO_Sales> recoBeverage() {

		String sql = SQLQuery.showBeverageForTheOld;

		Connection conn = null;
		ResultSet rs = null;
		Statement stm = null;

		List<VO_Sales> salesList = new LinkedList<VO_Sales>();

		try {
			conn = Jdbc_ConPrivider.getConnection();
			stm = conn.createStatement();

			rs = stm.executeQuery(sql);

			while (rs.next()) {

				VO_Sales sales = new VO_Sales(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6));
				salesList.add(sales);
			}

		} catch (SQLException e) {

		} finally {
			Jdbc_Closer.close(rs);
			Jdbc_Closer.close(stm);
			Jdbc_Closer.close(conn);
		}

		return salesList;
	}

	// 추천메뉴 사이드메뉴를 리스트로 저장해서 반환
	public List<VO_Sales> recoSide() {
		String sql = SQLQuery.showSideForTheOld;

		Connection conn = null;
		ResultSet rs = null;
		Statement stm = null;

		List<VO_Sales> salesList = new LinkedList<VO_Sales>();

		try {
			conn = Jdbc_ConPrivider.getConnection();
			stm = conn.createStatement();

			rs = stm.executeQuery(sql);

			while (rs.next()) {

				VO_Sales sales = new VO_Sales(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6));
				salesList.add(sales);
			}

		} catch (SQLException e) {

		} finally {
			Jdbc_Closer.close(rs);
			Jdbc_Closer.close(stm);
			Jdbc_Closer.close(conn);
		}

		return salesList;
	}


}