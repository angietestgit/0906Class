package chapter07.Friend_pck;

import java.util.Scanner;
import java.util.Calendar;

import chapter07.Menu;

public class FriendInfoMain {

	public static void main(String[] args) {
		

		// 추상클래스의 인스턴스 생성은 불가능
		//Friend friend = new Friend("","","");
	
		FriendInfoHandler handler = new FriendInfoHandler();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
//			System.out.println("##### 메뉴 선택 #####");
//			System.out.println(" 1. 고교 친구 정보 저장");
//			System.out.println(" 2. 대학 친구 정보 저장");
//			System.out.println(" 3. 전체 정보 출력");
//			System.out.println(" 4. 기본 정보 출력");
//			System.out.println(" 5. 프로그램 종료");
//			System.out.println("메뉴 선택 >>");
			
			System.out.println("##### 메뉴 선택 #####");
			System.out.println(Menu.INSERT_HIGH+". 고교 친구 정보 저장");
			System.out.println(Menu.INSERT_UNIV+". 대학 친구 정보 저장");
			System.out.println(Menu.SHOW_ALL+". 전체 정보 출력");
			System.out.println(Menu.SHOW_BASIC+". 기본 정보 출력");
			System.out.println(Menu.EXIT+". 프로그램 종료");
			System.out.println("메뉴 선택 >>");
			
			int select = Integer.parseInt(sc.nextLine());
			
			
			
			switch(select) {
//			case 1: case 2:
			case Menu.INSERT_HIGH: case Menu.INSERT_UNIV:
				handler.addFriend(select);
				break;
//			case 3:
			case Menu.SHOW_ALL:
				handler.showAllData();
				break;
			case 4:
				handler.ShowAllSimpleData();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0); // return
			}
			
			
			
		}
		

	}

}