package JavaTest;

import java.util.Scanner;

import JavaTest.CountDownThread;

public class HighRowGame {
	
	static boolean inputCheck = false;

	public static void main(String[] args) {

		CountDownThread t = new CountDownThread();
		t.start();


		System.out.println("$$$$$$게임을 시작합니다.$$$$$$"
		+ "\n1~100 중에서 원하시는 숫자를 입력하세요.\n>>");
		Scanner sc = new Scanner(System.in);
		int userNum = sc.nextInt();

		int secretNum = (int) (Math.random() * 100);

		//System.out.println("내번호: " + userNum + "/비밀번호: " + secretNum);
		
		while (true) {

			if (!(userNum == secretNum)) {
				if (userNum > secretNum) {
					System.out.println("로우 입니다. 숫자를 재입력 하세요\n>>");
					userNum = sc.nextInt();
					
				} else if (userNum < secretNum) {
					System.out.println("하이 입니다. 숫자를 재입력 하세요\n>>");
					userNum = sc.nextInt();
				}
			} else if (userNum == secretNum) {
				inputCheck = true;

			}

		}
	}
}
