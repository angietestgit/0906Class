package chapter10;

import java.util.Scanner;

public class ExceptionTest3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("피제수를 입력해주세요.");
		int num1 = sc.nextInt();
		System.out.println("제수를 입력해주세요.");
		int num2 = sc.nextInt();

		// 예외처리
		try {
			System.out.println(num1 / num2);
		} catch (ArithmeticException e) { // 에러났던 메시지를 그대로 긁어와도 좋음
			System.out.println("0으로 나누기를 할 수 없습니다.");
			System.out.println(e.getMessage());
		} catch (Exception e) { // 상위에서 일어난 에러를 쭉 찾아서 내려옴
			System.out.println("오류 발생");
		}

//		// 에러!! 예외처리 순서때문에 ! 
//		try {
//			System.out.println(num1 / num2);
//		} catch (Exception e) { // 상위에서 일어난 에러를 쭉 찾아서 내려옴
//			System.out.println("오류 발생"); //모든에러를 체크하기때문에
//		} catch (ArithmeticException e) { //이 캐치는 보이지 않음
//			System.out.println("0으로 나누기를 할 수 없습니다.");
//			System.out.println(e.getMessage());
//		}

		System.out.println("프로그램을 종료 합니다.");

	}
}
