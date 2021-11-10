package dept;

import java.sql.SQLException;

public class DeptMain {
	
	public static void main(String[] args) {
		
		DeptDao deptDao = new DeptDao();
		
		
		// 변수가 없는 클래스, 기능만 있는 클래스
		// 인스턴스를 하나만  
		
		// 인스턴스를 하ㅏㄴ                                                                       
		
		
		
		// 부서 리스트를 확인
		//List<Dept> list = new ArrayList<Dept>();
		
		Connction = connll
		
		List<Dept> list = null;
		
		
		try {
			conn = ConnectionProvider.getConnetcion();
			
			//부서 리스트를 확인
			list = deptDao.selectAllList(conn);
			
			System.out.println("부서리스트");
			System.out.println("--------------------------");
			
			for(Dept dept : list) {
				System.out.println(dept);
				
			}
			
			// 부서 정보 검색 : 부서 번호
			Dept dept = deptDao.selectByDeptno(conn, 10);
			System.out.println("10번 부서: "+dept);
			
			// 부서 정보를 입력
			Dept newDept = new Dept(50, "DEV", "SEOUL");
			
			int insertCnt = deptDao.insertDept(conn, newDept);
			if(insertCnt > 0) {
				System.out.println("부서 정보가 입력되었습니다.");
			} else {
				System.out.println("입력 실패");
			}
			
			System.out.println("입력 결과 "+ deptDao.selectByDeptno(conn, 50));
			
			
			System.out.println("------------------------");
			Dept editDept = new Dept(50, "Design", "Pusan");
			int editCnt = deptDao.editDept(conn, editDept);
			if(editCnt>0) {
				System.out.println("정보가 수정되었습니다.");
			} else {
				System.out.println("수정 실패 또는 조건에 맞ㄴㄴ 데이터가 존재하지 않습니다.");
			}
			System.out.println("수정 결과 "+ deptDao.selectByDeptno(conn, 50));

		
			
			// 부서 삭제 : deptno 기준으로 삭제(pk기반)
			int delCnt = deptDao.deleteDept(conn, 50);
			System.out.println("삭제 결과"+ deptDao.selectByDeptno(conn, 50));
			
			
			
			
			
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
