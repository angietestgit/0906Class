package chapter10;

import java.util.Scanner;

public class ExceptionTest7 {
	public static void main(String[] args) {

		System.out.println("나이를 입력해주세요.");

		try {
			int age = getAge(); //예외 발생 포인트
			System.out.println("나이는 "+age+"세 입니다.");
			
		} catch (AgeInputException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
			e.print();
		}
		
		System.out.println("프로그램을 종료합니다.");
	}

	// 사용자의 나이를 입력받아 반환하는 메소드
	public static int getAge() throws AgeInputException { // 에이지인풋익센션이 발생하면 이걸 호출할 쪽으로 던지겠다는 뜻
		// throws AgeInputException
		// 메소드 내부에서 AgeInputException 예외가 발생하면
		// 메소드 내부에서 예외처리 하지 않고 호출한 메소드로 예외 객체를 전달

		int age = 0;

		// 핵심 처리하고 age 값을 대입
		Scanner sc = new Scanner(System.in);
		age = sc.nextInt();

		if (age < 0) {
			// 1. 예외 객체 생성
			//AgeInputException e = new AgeInputException();
			AgeInputException e = new AgeInputException(age);
			
			// 2. 예외 발생
			throw e;
		}

		return age;
	}
}
