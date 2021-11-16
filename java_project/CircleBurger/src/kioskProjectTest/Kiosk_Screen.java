package kioskProjectTest;

import java.util.LinkedList;
import java.util.List;

//키오스크 화면 출력만을 담당하는 클래스

public class Kiosk_Screen {
	Input_Scan scan;
	Jdbc_SalesDAO dao;
	Basket myBasket;

	public Kiosk_Screen() {
		scan = new Input_Scan();
		dao = Jdbc_SalesDAO.getInstance();
		myBasket = new Basket();
	}

	// showMain();
	// 최초 화면 ( 신상품, 추천메뉴 , 광고를 출력)
	public void showMain() {
		////////// 광고, 신상품, 추천메뉴 를 출력했습니다.
		System.out.println("\t주문하시려면 클릭하세요");
		System.out.println("1.일반주문 \t || \t 2.간편주문");
		int choice = scan.getChoice(2);

		switch (choice) {
		case 1:
			step0();
			break;
		case 2:
			// 간편주문
			step0();
			break;
		}

	}

;
	// 매장식사, 테이크 아웃 을 선택하는 메소드
	// 선택 후 step2RecoMenuPrint(); 메소드 이동
	public void takeChoice() {
		System.out.println("\t수령방법을 선택하세요");
		System.out.println("1.매장식사 \t || \t2.테이크아웃");
		int choice = scan.getChoice(2);

		switch (choice) {
		case 1:
			System.out.println("\t매장식사를 선택하셨습니다.\n\t메뉴선택으로 이동합니다.");
			step2RecoMenuPrint(); // 추천메뉴 메인메소드로 이동
			break;

		case 2:
			System.out.println("\t테이크아웃을 선택하셨습니다.\n\t메뉴선택으로 이동합니다.");
			step2RecoMenuPrint();
			break;
		}
	}

	// 일반 주문
	// step1();
	// 버거, 음료/커피, 사이드를 출력하는 메소드
	public void step1() {
		List<VO_Sales> saleList = new LinkedList<>();
		saleList = dao.sendAllMenu();

		for (int i = 0; i < saleList.size(); i++) {
			System.out.printf("%d %s %d %d\n", i + 1, saleList.get(i).getProductName(), saleList.get(i).getPrice(),
					saleList.get(i).getCalorie());
		}

		System.out.println("상품을 선택하세요");

		int choice = scan.getChoice(saleList.size()) - 1;

		myBasket.add(saleList.get(choice));

		System.out.println("선택하신 상품이 장바구니에 담겼습니다.");

		for (VO_Sales obj : myBasket) {
			System.out.println(obj.toString());
		}

	}
	
	
	
	
	

	// 추천메뉴(버거) 상세보기 메소드
	public void detailRecoMenu(int choice) {
		List<VO_Sales> saleRecoBurgerList = new LinkedList<>();
		saleRecoBurgerList = dao.recoHamburgerForAll();

		System.out.println(" **추천버거목록** ");
		for (int i = 0; i < saleRecoBurgerList.size(); i++) {
			System.out.printf("[%d] %s %d %d\n", i + 1, saleRecoBurgerList.get(i).getProductName(),
					saleRecoBurgerList.get(i).getPrice(), saleRecoBurgerList.get(i).getCalorie());
		}

		// 추천버거 선택
		System.out.println("상품을 선택하세요");
		int RecoBurgerChoice = scan.getChoice(saleRecoBurgerList.size()) - 1;

		System.out.println();
		// (주문취소)space -> 일반주문/간편주문 메소드
		if (RecoBurgerChoice != -16) {
			setMenuChoice(myBasket.list.get(RecoBurgerChoice).getProductName());

		} else {
			step2RecoMenuPrint();

		}

	}
	
	
	public void setMenuChoice(String name) {
	};
	

	// step2();
	// 추천메뉴를 출력해주는 메소드
	public void step2RecoMenuPrint() {
		// 추천메뉴 출력
		List<VO_Sales> saleRecoBurgerList = new LinkedList<>();
		saleRecoBurgerList = dao.recoHamburgerForAll();

		// 추천메뉴 보기
		System.out.println("===============\n**  추천메뉴  **");
		for (int i = 0; i < saleRecoBurgerList.size(); i++) {
			System.out.printf(" %s ", saleRecoBurgerList.get(i).getProductName());
		}

		System.out.println("---------------");
		System.out.println("버거. 음료, 사이드/ ");
		System.out.println("---------------");
		
		// 주문내역 장바구니에서 가져오기 
		if (myBasket.list.isEmpty()) {
			System.out.println("장바구니가 비어 있습니다.");
		
		} else {
			// 주문내역 총 합계, 총 제품수
			int totalPrice = 0;
			int totalProduct = 0;
			
			for(int i = 0; i < myBasket.list.size(); i++) {
				totalPrice += myBasket.list.get(i).getPrice()*myBasket.list.get(i).getQuantity();
				totalProduct += myBasket.list.get(i).getQuantity();
			}
			
			System.out.printf("합계: %d |제품: %d", totalPrice, totalProduct);
		}
		

		System.out.println("---------------");
		System.out.println("주문취소(space)\n주문완료(enter)\n===============");

		
		// (추천메뉴선택, 버거보기, 음료보기, 사이드보기, 주문내역 출력, 주문취소,주문완료선택)
		// 추천메뉴는 1~9까지 선택하며, 버거보기는 , 음료보기는 . 사이드보기는 / 키를 입력해야 합니다.
		// 이는 Scan 클래스의 screenChoice2 가 담당합니다.
		// 이 screenChoice2 에 들어가는 매개변수는 정수 9 입니다.
		// screenChoice2 가 반환하는 정수는 "1~9", ",", ".", "/", "space키", "엔터키" 에 대한
		// 아스키코드 값 - 48 입니다.

		int choice = scan.screenChoice2(9);
		
		// 키 입력시 코드실행
		// 추천메뉴(버거) -> 추천메뉴상세보기로 이동
		if (choice >= 1 && choice <= 9) {
			// 추천메뉴(버거) 상세보기 메소드
			detailRecoMenu(choice);
		}

		// 버거->버거상세보기. 음료->음료상세보기. 사이드 상세보기로 이동
		else if (choice == -4) {
			// 버거 상세보기 메소드
		}

		else if (choice == -2) {
			// 음료 상세보기 메소드
		}

		else if (choice == -1) {
			// 사이드 상세보기 메소드
		}

		// 주문취소(space) -> 일반주문/간편주문 메소드
		else if (choice == -16) {
			showMain();
		}

		// 주문완료(enter) -> 주문내역확인 메소드
		else if (choice == -35) {
			// 주문내역확인 메소드
		
		}

	}

}