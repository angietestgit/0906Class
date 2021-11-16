package kioskProjectTest2;

	// step2RecoMenuPrint()
	public void step2RecoMenuPrint() {
		// 추천메뉴 출력
		List<VO_Sales> saleRecoBurgerList = new LinkedList<>();
		saleRecoBurgerList = dao.recoHamburgerForAll();

		printBanner("Recommended");
		// 정보를 3열로 출력

		SortPrinting.printInfoInRow(saleRecoBurgerList, 3);

		System.out.println(SortPrinting.SPACE);
		System.out.println(SortPrinting.ROW);
		System.out.println(SortPrinting.SPACE);

		// 주문내역 장바구니에서 가져오기
		if (myBasket.list.isEmpty()) {
			SortPrinting.centerAlign("Basket is Empty");

		} else {
			// 주문내역 총 합계, 총 제품수
			int totalPrice = 0;
			int totalProduct = 0;

			for (int i = 0; i < myBasket.list.size(); i++) {

				totalPrice += myBasket.list.get(i).getPrice() * myBasket.list.get(i).getQuantity();
				totalProduct += myBasket.list.get(i).getQuantity();
			}
			String basketInfo = "Sum ".concat(
					String.valueOf(totalPrice).concat("┃ count ").concat(String.valueOf(totalProduct).concat("ea")));
			SortPrinting.leftAlign(basketInfo);
		}

		System.out.println(SortPrinting.SPACE);
		System.out.println(SortPrinting.ROW);
		SortPrinting.centerAlign("[,] Burger  [.] Drink  [/] Side");
		System.out.println(SortPrinting.ROW);
		System.out.println(SortPrinting.SPACE);
		SortPrinting.centerAlign("[space] Cancel          [Enter] Pay");
		System.out.println(SortPrinting.BOTTOM);

		// (추천메뉴선택, 버거보기, 음료보기, 사이드보기, 주문내역 출력, 주문취소,주문완료선택)
		// 추천메뉴는 1~9까지 선택하며, 버거보기는 , 음료보기는 . 사이드보기는 / 키를 입력해야 합니다.
		// 입력은 Scan 클래스의 screenChoice2 가 담당합니다.
		// 이 screenChoice2 에 들어가는 매개변수는 정수 9 입니다.
		// screenChoice2 가 반환하는 정수는 "1~9", ",", ".", "/", "space키", "엔터키" 에 대한
		// 아스키코드 값 - 48 입니다.

		int choice = scan.screenChoice2(9) - 1;

		// 키 입력시 코드실행
		// 추천메뉴(버거) -> 추천메뉴상세보기로 이동
		if (choice >= 0 && choice <= 9) {
			// 추천메뉴(버거) 상세보기 메소드

			if (dao.recieveOrder(saleRecoBurgerList.get(choice))) {
				System.out.println("재고가 없어 주문할 수 없습니다.");
				step2RecoMenuPrint();
			} else {

				myBasket.list.add(saleRecoBurgerList.get(choice));
				showSalesBySelected((saleRecoBurgerList.get(choice).getProductName()),
						myBasket.list.get(myBasket.list.size() - 1).getQuantity());
			}
		}

		// 버거->버거상세보기. 음료->음료상세보기. 사이드 상세보기로 이동
		else if (choice == -5) {
			showBurgerType();
		}

		else if (choice == -3) {
			// 음료 상세보기 메소드
			drinkChoice();
		}

		else if (choice == -2) {
			// 사이드 상세보기 메소드
			sideShow();
		}

		// 주문취소(space) -> 일반주문/간편주문 메소드
		else if (choice == -17) {
			myBasket.list.clear();
			showMain();
		}

		// 주문완료(enter) -> 주문내역확인 메소드
		else if (choice == -36) {
			
			lastCheck(myBasket.list, 1);

		}

	}

//////////////////////////////////////
//package kioskProject;
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class test {
//
//	// showMain()최초화면-> 간편주문(age=0)고령자를 위한 햄버거 메뉴 출력 ->단품/세트/라지 선택
//
//	// 새로운 테이블을 만들고 => SQLQuery로 대체
//	// 고령자를 위한 추천 버거만 나오는 메소드를 만들거임
//
//	///////////////////////////////
//	// 버거 선택하면
//
//	// 단품/세트/라지 선택메소드로
//	// 위 메소드에서
//	
//	// 버거 단품 선택하면 바로 /음료 하고 결제 //
//	// 버거 세트/라지세트 하면 바로 장바구니로
//
//	//////////////////////////////
//	// 고령자를 위한 추천 버거를 보여주는 메소드입니다.
//	public void showBurForTheOld() {
//		
//		System.out.println("\t 간편 버거 주문 스크린");
//		
//		// 고령자용 버거메뉴 리스트
//		List<VO_Sales> saleRecoBurListOlder = new LinkedList<>();
//
//		saleRecoBurListOlder = dao.showRecoForTheOld();
//
//		// 고령자용 버거메뉴 출력
////		for (int i = 0; i < saleRecoBurListOlder.size(); i++) {
////			System.out.printf("[%d] %s %d %d", i + 1, saleRecoBurListOlder.get(i).getProductName(),
////					saleRecoBurListOlder.get(i).getPrice(), saleRecoBurListOlder.get(i).getCalorie());
////		}
//		printInfoInRow(saleRecoBurListOlder,3);
//		
//
//		// 고령자가 먹고싶은 메뉴를 선택하면
//		int RecoBurgerChoice = scan.getChoice(saleRecoBurListOlder.size()) - 1;
//
//		// 선택한 매개변수를 가지고
//		// 단품, 세트, 라지세트 유무를 선택하는 메소드로 이동
//		if (RecoBurgerChoice != -16) {
//			// step2RecoMenuPrint 메소드 매개변수는 이름으로 버거이름으로 넘겨주기
//			String choiceRecoBurOlder = myBasket.list.get(saleRecoBurListOlder).getProductName();
//			step2RecoMenuPrint(choiceRecoBurOlder);
//						
//			
//		} else { // 스페이스(취소)하면 메인화면으로 돌아가기
//			showMain();
//
//		}
//
//	}
//}
