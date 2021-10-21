package JavaTest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Execption {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 아이디 처리
		try {
			String id = getId(); // 예외 발생 포인트
			System.out.println("id: " + id);

		} catch (BadIdInputException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}

		// 출생연도 처리
		try {
			System.out.println("출생 연도를 입력해주세요: ");
			int birthyear = sc.nextInt();
			System.out.println("출생연도: " + birthyear);

		} catch (InputMismatchException e) { // 정수로 입력할 걸 문자로 입력한 경우 예외발생 처리
			System.out.println("연도를 잘못 입력하셨습니다.");

		}

		System.out.println("프로그램을 종료합니다.");
	}

	public static String getId() throws BadIdInputException {

		System.out.println("아이디를 입력해주세요.\n영문,숫자만 입력하세요\n--------------");

		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();

		String CheckEng = "^[a-zA-Z]*$";
		String CheckNum = "^[0-9]+$";

		if (id.matches(CheckEng) && id.matches(CheckNum)) {
			System.out.println("아이디는 영문 대소문자, 숫자만 입력가능합니다.");

			// 1. 예외 객체 생성
			BadIdInputException e = new BadIdInputException(id);

			// 2. 예외 발생
			throw e;

		}

		sc.close();
		return id;
	}

}
