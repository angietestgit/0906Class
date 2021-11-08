package dept;
// 부서 정보를 담을 클래스

public class Dept {
	
	private int deptno;
	private String dname;
	private String loc;
	
	// 생성자 초기화
	public Dept(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}	
	
	// 기본 생성자: Beans 클래스 생성시 반드시 기본 생성자가 있어야 한다!!!
	
	// VO : 읽기전용  value object, getter 메소드만 존재
	// DTO : 읽고 쓰기 가능, getter/setter
	
	public Dept() {}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	

}
