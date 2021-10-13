package chapter01;

public class Member {

	// 2. Member 클래스를 생성하고
	// main()메소드를 만들고 자기 자신의 이름을 출력하는 메소드를 만들어 출력해 봅시다.
	public static void main(String[] args) {
		// static : 바이트 코드가 가상 머신에서 실행하는 시점(최초실행하는 시점)에
		// 메소드 코드가 메모리에 로드된다.
		System.out.println("이효은");
		System.out.println("메소드 호출");
		sayName();
	}
	// static 전역. 메소드가 실행되는 시점. 빈번하게 사용할 떄 자주사용.
	// 메모리와 cpu성능에 차이가 생기기때문에
	// static 붙이고 말고는 얼마나 많이 사용하느냐.

	// 이름을 출력하는 메소드
	// 반환타입 메소드 이름 (매개변수, ...)
	static void sayName() {
		System.out.println("이효은");
	}
	// static
	// 아무것도 반환하지 않을 때 void

}