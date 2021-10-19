package Projects;

import java.util.Scanner;

import Projects.Contact;

//Project-1 요구사항에 맞게 클래스를 정의하고 깃헙공유하기

//우리가 흔히 볼 수 있는 스마트폰에 이름, 전화번호, 이메일 등과 같은 연락처 정보를 저장하는 애플리케이션.
//데이터를 출력하는 메소드를 가지는 클래스 Contact를 정의해보자.

//저장정보: 이름, 전화번호, 이메일, 주소, 생일, 그룹
//기능: 위 데이터를 출력하는 기능

//추가요구사항
//1. 변수들은 직접 참조를 막아 캡슐화 처리
//2. 게터, 세터메소드 정의
//3. 인스턴스 생성과 함께 데이터를 초기화할 수 있도록 생성자를 정의
//4. 저장할 데이터를 콘솔에서 사용자의 입력 값으로 인스턴스를 생성

public class Contact {
	public static Scanner scanner = new Scanner(System.in);

	// 저장정보
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

	// 생성자 메소드
	public Contact() {

	}

	// 파라미터 있는 메소드
	public Contact(String name, String phoneNum, String email, String birthday, String group, String address) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.birthday = birthday;
		this.group = group;
		this.address = address;
	}

//	// 스캐너를 외부에서 받아서 처리할 수 있게 하는 세터메소드
//	public void setScanner(Scanner scanner) {
//		this.scanner = scanner;
//	}

	// 메인 메소드
	public static void main(String[] args) {
		Contact c = new Contact();

		System.out.println("입력한 데이터를 저장하고 출력합니다.");
		// 입력메소드 실행
		c.insertData(c);
		// 출력메소드 실행
		c.showData(c);
		System.out.println("=============");
		
		System.out.println("입력한 데이터를 수정하고 출력합니다.");
		// 수정메소드 실행
		c.updateData(c);
		// 출력메소드 실행
		c.showData(c);
		
	}

	
	// 입력메소드
	private void insertData(Contact c) {
		System.out.println("정보를 입력해주세요.");
		System.out.print("이름: ");
		String name = new String(scanner.nextLine());
		c.setName(name);

		System.out.print("전화번호: ");
		String phoneNum = new String(scanner.nextLine());
		c.setPhoneNum(phoneNum);

		System.out.print("이메일: ");
		String email = new String(scanner.nextLine());
		c.setEmail(email);

		System.out.print("주소: ");
		String address = new String(scanner.nextLine());
		c.setAddress(address);

		System.out.print("생일: ");
		String birthday = new String(scanner.nextLine());
		c.setBirthday(birthday);

		System.out.print("그룹: ");
		String group = new String(scanner.nextLine());
		c.setGroup(group);

		c = new Contact(name, phoneNum, email, birthday, group, address);

	}

	// 출력메소드
	private void showData(Contact c) {
		System.out.println("\n---저장정보---");
		System.out.println("@이름: " + c.getName());
		System.out.println("@전화번호: " + c.getPhoneNum());
		System.out.println("@이메일: " + c.getEmail());
		System.out.println("@주소: " + c.getAddress());
		System.out.println("@생일: " + c.getBirthday());
		System.out.println("@그룹: " + c.getGroup());
	}

	// 수정메소드
	private void updateData(Contact c) {
		System.out.println("\n수정 할 정보를 입력해주세요.");
		System.out.print("수정할 이름: ");
		String name = new String(scanner.nextLine());
		c.setName(name);

		System.out.print("수정할 전화번호: ");
		String phoneNum = new String(scanner.nextLine());
		c.setPhoneNum(phoneNum);

		System.out.print("수정할 이메일: ");
		String email = new String(scanner.nextLine());
		c.setEmail(email);

		System.out.print("수정할 주소: ");
		String address = new String(scanner.nextLine());
		c.setAddress(address);

		System.out.print("수정할 생일: ");
		String birthday = new String(scanner.nextLine());
		c.setBirthday(birthday);

		System.out.print("수정할 그룹: ");
		String group = new String(scanner.nextLine());
		c.setGroup(group);
		
	}

}
