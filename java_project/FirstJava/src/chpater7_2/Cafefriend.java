package chpater7_2;

// 추상 클래스를 상속해서 새로운 클래스를 정의
public abstract class Cafefriend extends Friend2 {
	
	String cafrName;
	
	public CafeFriend(String name, String phoneNumber, String address) {
		super(name, phoneNumber, address);
		this.cafeName = cafeName;
	}
	
	// 반드시 추상메소드를 완성시켜야 인스턴스 생성이 가능!
	@Override
	public void showBasicInfo() {
		System.out.println("이름: "+name);
		System.out.println("전번: "+phoneNumber);
		System.out.println("동호회이름: "+cafeName);
	}
	

}
