package kioskProjectTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class test {

	// 추천메뉴 햄버거를 리스트로 저장해서 반환
	public List<VO_Sales> recoHamburger() {

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

				VO_Sales sales = new VO_Sales(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
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

					VO_Sales sales = new VO_Sales(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
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

					VO_Sales sales = new VO_Sales(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
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