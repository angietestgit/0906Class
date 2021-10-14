package chapter4;

import java.util.Scanner;

// 21.10.13.수.대면.
// 퀴즈
// Project-1 요구사항에 맞게 클래스를 정의하고 깃헙공유하기

//우리가 흔히 볼 수 있는 스마트폰에 이름, 전화번호, 이메일 등과 같은 연락처 정보를 저장하는 애플리케이션.
//데이터를 출력하는 메소드를 가지는 클래스 Contact를 정의해보자.

// 저장정보: 이름, 전화번호, 이메일, 주소, 생일, 그룹
// 기능: 위 데이터를 출력하는 기능

// 추가요구사항
// 1. 변수들은 직접 참조를 막아 캡슐화 처리
// 2. 게터, 세터메소드 정의
// 3. 인스턴스 생성과 함께 데이터를 초기화할 수 있도록 생성자를 정의
// 4. 저장할 데이터를 콘솔에서 사용자의 입력 값으로 인스턴스를 생성

public class Contact {
		
	private String name;
	private String phoneNum;
	private String email;
	private String address;
	private String birthday;
	private String group;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	public Contact() {
		
	}
	
	// 입력메소드
	private void dataInsert() {
		
		Scanner scanner = new Scanner(System.in);
		Contact contact = new Contact();

		System.out.print("이름: ");
		String name = new String(scanner.nextLine());
		contact.setName(name);

		System.out.print("전화번호: ");
		String phoneNum = new String(scanner.nextLine());
		contact.setPhoneNum(phoneNum);

		System.out.print("이메일: ");
		String email = new String(scanner.nextLine());
		contact.setEmail(email);

		System.out.print("주소: ");
		String address = new String(scanner.nextLine());
		contact.setAddress(address);

		System.out.print("생일: ");
		String birthday = new String(scanner.nextLine());
		contact.setBirthday(birthday);

		System.out.print("그룹: ");
		String group = new String(scanner.nextLine());
		contact.setGroup(group);
		
		scanner.close();
	}
	
	
	public static void main(String[] args) {
		Contact contact = new Contact();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("입력한 데이터를 저장하고 출력합니다.\n 정보를 입력해주세요.");
		
		contact.dataInsert();
		contact.dataShow(contact);
		contact.update(scanner);
		contact.dataShow(contact);
	}
	
	// 출력 메소드
	private void dataShow(Contact contact) {
		System.out.println("\n---저장정보---");
		System.out.println("@이름: " + contact.getName());
		System.out.println("@전화번호: "+ contact.getPhoneNum());
		System.out.println("@이메일: " + contact.getEmail());
		System.out.println("@주소: " + contact.getAddress());
		System.out.println("@생일: "+ contact.getBirthday());
		System.out.println("@그룹: "+ contact.getGroup());
	}
	
	// 인스턴스의 각 변수에 값을 바꾸는 데이터 수정 메소드
	public void update(Scanner scanner) {		
		
		System.out.print("변경할 이름: ");
		setName(scanner.nextLine());

		System.out.print("변경할 전화번호: ");
		setPhoneNum(scanner.nextLine());

		System.out.print("변경할 이메일: ");
		setEmail(scanner.nextLine());

		System.out.print("변경할 주소: ");
		setAddress(scanner.nextLine());

		System.out.print("변경할 생일: ");
		setBirthday(scanner.nextLine());

		System.out.print("변경할 그룹: ");
		setGroup(scanner.nextLine());
		System.out.println();
		

	}
	

}
