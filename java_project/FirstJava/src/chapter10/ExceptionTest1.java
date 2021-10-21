package chapter10;

import java.util.Scanner;

public class ExceptionTest1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("피제수를 입력해주세요.");
		int num1 = sc.nextInt();
		System.out.println("제수를 입력해주세요.");
		int num2 = sc.nextInt();

		int result = 0;
		// 예외처리
		try {
//			int result = num1 / num2;
			// 지역변수 사라짐 여기서만사용
			result = num1 / num2;
			//영향을 주는 문구 같이 넣어주기
			System.out.println("나눗셈이 정상적으로 처리되었습니다.");
			System.out.println("나눗셈의 결과는" + result + "입니다.");
			
			
		} catch (ArithmeticException e) { // 에러났던 메시지를 그대로 긁어와도 좋음
			System.out.println("0으로 나누기를 할 수 없습니다.");
			System.out.println(e.getMessage());
		} catch (Exception e) { // 상위에서 일어난 에러를 쭉 찾아서 내려옴
			System.out.println("오류 발생");
		}

		System.out.println("프로그램을 종료합니다.");
	}
}
