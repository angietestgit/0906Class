package ver02;

public class SmartPhoneMain {
	public static void main(String[] args) {
		
		// SmartPhone 클래스의 인스턴스를 생성합니다.
		SmartPhone phone = new SmartPhone(10);
		
		// 사용자로부 입력을 받아 Contact 인스턴스를 생성해서 SmartPhone 클래스의 인스턴스가 가지고 있
		// 10번 반복해서 배열에 추가합니다.
		for(int i=0; i<10; i++) {
			phone.insertContact();
		}
		
		// 배열의 모든 요소를 출력합니다.
		phone.printAllData();
		
		// 배열의 모든 요소를 검색합니다.
		phone.searchPrint();
		
		// 배열의 요소를 삭제해 봅시다.
		phone.deleteContact();
		
		// 배열의 요소를 수정해 봅시다.
		phone.editContact();
		
		
		// 삭제와 변경 여부 확인
		phone.printAllData();
		
	}

}
