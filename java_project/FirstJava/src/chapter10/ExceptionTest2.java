package chapter10;

import java.util.Scanner;

public class ExceptionTest2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("피제수를 입력해주세요.");
		int num1 = sc.nextInt();
		System.out.println("제수를 입력해주세요.");
		int num2 = sc.nextInt();

		//예외처리. 근데 예외처리는 if문으로는 잘 하지 않음
		// if는 프로그램의 주 흐름인지 예외처리인지 구분안되고 복잡해짐
		if (num2 == 0) {
			System.out.println(num1 / num2);
			//return;

		} else
			System.out.println(num1 / num2);

	}
}
