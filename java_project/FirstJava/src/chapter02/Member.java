package chapter02;

public class Member {
	/* 앞서 생성 했던 Member 클래스에 main() 메소드 안에 아래 조건의 변수를 정의해봅시다. 
① String 타입의 이름을 저장할 수 있는 변수 name을 정의해봅시다.
② int 타입의 나이를 저장할 수 있는 변수 age를 정의해봅시다.
③ double 타입의 키를 저장할 수 있는 변수 height를 정의해봅시다.
④ boolean 타입의 JAVA책의 보유 여부를 저장할 수 있는 변수 hasBook를 정의해봅시다.
⑤ 이름과 나이, 키, 책의 보유 여부를 출력해봅시다.
*/
	
	//클래스 정의
	// [접근제어자] [final] 클래스이름
	//final 상수만들때
	//클래스 이름에 붙을 때는 상속관계여부
	//string 클래스 final String 클래스는 상속하는 경우가 없기때문에
	// {
	//   변수 정의
	//   메소드 정의		
	// }
	
	private String name; //null, 사용자의 이름을 저장하는 변수
	//인스턴스 변수는 초기화 안해도 됨. 초기화 디폴트값은 null
	//인스턴스는 기본 변수는 자동 초기화
	// private 데이터를 직접 참조하지 않기때문에. 캡슐화;정보은닉

	
	int age; //사용자의 나이를 저장하는 변수
	double height; // 사용자의 키
	boolean hasBook; //자바책 보유여부
	
	// 회원의 데이터를 출력하는 메소드
	void printData() {
		System.out.println("이름:" +name);
		System.out.println("나이:" +age);
		System.out.println("키:"  +height);
		System.out.println("자바 도서의 보유 여부:" +hasBook);
	}
	
	public static void main(String[] args) {
		
		long juminNumber = 97010111111111L; //임시로 메모리공간에 넣어줘야됨. 
		//971010-111111는 String으로
		
		// 멤버 클래스로 안스턴스를 생성 -> 이름, 나이, 키, 책보유상태를 저장할 수 있는 메모리 공간을 생성
		//인스턴스만들기
		Member member = new Member();
		
//		// 인스턴스의 변수를 참조해서 출력
//		System.out.println("이름:" +member.name);
//		System.out.println("나이:" +member.age);
//		System.out.println("키:"  +member.height);
//		System.out.println("자바 도서의 보유 여부:" +member.hasBook);
		
		member.printData();
		
		// 인스턴스 변수의 값을 변경
		member.name = "이효은";
		member.age = 20;
		member.height = 169.9; //double로 바뀌어서 연산이 이뤄짐
		member.hasBook = true;
		
		System.out.println("------------------");
		System.out.println("인스턴스 변수의 값을 변경");
		System.out.println("------------------");
		
		System.out.println("이름:" +member.name);
		System.out.println("나이:" +member.age);
		System.out.println("키:"  +member.height);
		System.out.println("자바 도서의 보유 여부:" +member.hasBook);
		
		
		
		//이게 클래스를 만드는 목적. 데이터를 저장하는 목적과 기능을 구현하는 목적
		
		// 공통 코드들(2개이상나온다?그럼 바로 정리) => 메소드로 정의 => Member 클래스에서 정의
		
	}
	


}
