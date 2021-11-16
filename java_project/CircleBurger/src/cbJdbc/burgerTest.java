package cbJdbc;

public class burgerTest {
	
	private int burgerno;
	private String bname;
	private String price;

	// 버거 생성자 초기화
	public burgerTest(int burgerno, String bname, String price) {
		super();
		this.burgerno = burgerno;
		this.bname = bname;
		this.price = price;
	}
	
	// 기본 생성자
	public burgerTest() {}

	public int getBurgerno() {
		return burgerno;
	}

	public void setBurgerno(int burgerno) {
		this.burgerno = burgerno;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	
	}
	
}