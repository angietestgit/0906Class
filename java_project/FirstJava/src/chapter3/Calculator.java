package chapter3;

import java.util.Scanner;

public class Calculator {
//	 1. Calculator 클래스를 정의해봅시다.
	
	//상수
	//final 변수 앞에-> 상수(변하지 않는 수) 
	// 또는 클래스 앞에 사용 -> 상속의 대상이 아니다!!!
	// java에서 상수: 변수에 최초 초기화된 값을 바꾸지 못한다!!!
	final float PI = 3.1415f;
	final String USER_NAME;
	// 많이 사용, 변경x 기 때문에 steady,
	//public을 붙여줘서 직접 access하게 해주기도 한다.
	
	// 생성자 : 초기화메소드, 메소드 구조와 유사하지만 반환기능이 없다!
	// 클래스이름(){}
	Calculator(String name){
		//USER_NAME = "손흥민";
		USER_NAME = name;
	}
	
//	① 정수 두 개를 매개변수의 인자로 전달받아 더하기연산 후 출력하는 메소드를 정의
	public void plus(int num1, int num2) {
		//21억 + 1억하면 22억이 표현이 안되기때문에 long을 써줬음
		long result = (long)num1 + num2;
		System.out.println(num1+"+"+num2+"="+result);
	}
//	② 정수 두 개를 매개변수의 인자로 전달받아 빼기연산 후 출력하는 메소드를 정의
	public void minus(int num1, int num2) {
		long result = (long)num1 - num2;
		// 이항연산의 방향->
		//System.out.println(num1+"-"+num2+"="+result);
		// 문자열은 num1-num2 에서 - 할 수 없기 떄문에 묶음
		System.out.println(num1+"-"+num2+"="+(num1 - num2));

	}
//	③ 정수 두 개를 매개변수의 인자로 전달받아 곱하기연산 후 출력하는 메소드를 정의
	public void multiply(int num1, int num2) {
		long result = (long)num1 * num2;
		System.out.println(num1+"*"+num2+"="+result);
	}
//	④ 정수 두 개를 매개변수의 인자로 전달받아 나누기연산 후 출력하는 메소드를 정의
	public void devide(int num1, int num2) {
		float result = (float)num1 / num2;
		System.out.println(num1+"/"+num2+"="+result);
	}

	//	⑤ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 둘레를 구해 반환하는 메소드를 반환하는 메소드를 정의
	public float cirCum(float r) {
//		float result = (float)r * PI * 2; 
//		System.out.println("2*"+r+"*"+PI+"="+result);		
//		return result;
		return 2*PI*r; //int * float * float
	}
//	⑥ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 넓이를 구해 반환하는 메소드를 반환하는 메소드를 정의
//	원의 둘레 : 2 x π x r , 월의 넓이 : π x r x r
	public float cirArea(float r) {
//		float result = (float)r * PI * PI;
//		System.out.println("result");
//		return result;
		return PI*r*r;
	}
	
//	⑦ main() 메소드를 정의하고 각각의 메소드를 호출해서 결과를 콘솔에 출력해봅시다.
	//나중가면 메인메소드는 테스트목적으로 쓰는것.
	public static void main(String[] args) {
		
		Calculator cal = new Calculator("손흥민");
		
		//상수 출력
		System.out.println("PI : " + cal.PI);
		System.out.println("USER_NAME = " + cal.USER_NAME);
		
		// cal.USER_NAME = "이강인"; //상수의 값을 변경하는 것은 안된다!!!
		cal.plus(10, 20); //테스트목적이기때문에 매개변수값도 같이 출력할 수 있도록 print문을 작성하는 것이 좋다.
		
		//	⑧ 콘솔에서 사용자에게 데이터를 받아 메소드를 호출할 때 사용자에게 받은 데이터를 메소드의 매개변수의 인자로 전달하는 코드를 main() 메소드
//	에 추가해봅시다.
	
	//사실 웹에서는 스캐너도 잘 안쓰이고 콘솔은 확인용 테스트로 많이 쓰인다.
	// String name ; //java lang 은 import 안해줘도 됨
    //근데 스캐너는 import 해줘야됨
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("덧셈을 시작합니다.\n숫자 1을 입력해주세요.");
	 // wrapper 클래스. static 메소드자주사용하니깐 잘 알아두기
	int num1 = Integer.parseInt(scanner.nextLine());
	//System.out.println(num1);
	System.out.println("숫자 2를 입력해주세요.");
	int num2 = Integer.parseInt(scanner.nextLine());

	cal.plus(num1, num2);
	
	System.out.println("=================");
	System.out.println("원의 둘레와 넓이를 구합니다.\n 반지름을 입력해주세요.");
	float r = Float.parseFloat(scanner.nextLine()); //float을 float으로 반화해주는 메소드
	
	System.out.println("전달받은 반지름 : "+ r);
	System.out.println("원의 둘레: "+cal.cirCum(r));
	System.out.println("원의 넓이: "+cal.cirArea(r));
	
	
	
	}
	
	
	
}
