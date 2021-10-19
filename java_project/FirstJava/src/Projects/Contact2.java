package Projects;

import java.util.Scanner;

import Projects.Contact2;

//Project-2 Contact클래스를 기반으로 요구사항을 추가해서 프로그램작성, 깃헙공유하기

//1. 스마트폰 클래스를 정의. 연락처 정보를 관리하는 클래스
// 인스턴스 10개를 저장할 수 있는 배열을 정의
// 배열에 인스턴스를 저장, 수정, 삭제, 저장된 데이터의 리스트를 출력하는 메소드 정의

//2. 메인메소드
// 스마트폰 클래스의 인스턴스 생성
// 사용자로부터 입력받아 Contact 인스턴스 생성후 스마트폰클래스의 인스턴스가 가지고 있는 배열에 추가
// 10번 반복해서 배열에 추가
// 배열의 모든 요소 출력, 검색
// 배열의 요소 삭제, 수정

public class Contact2 {
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
	public Contact2() {

	}

	// 파라미터 있는 메소드
	public Contact2(String name, String phoneNum, String email, String birthday, String group, String address) {
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
		Contact2 c = new Contact2();

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

	// 연락처 정보를 관리하는 클래스
	private void SmartPhone() {
		// contact 클래스의 인스턴스 10를 저장할 수 있는 배열을 정의
		
	}
	
	// 입력메소드
	private void insertData(Contact2 c) {
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

		c = new Contact2(name, phoneNum, email, birthday, group, address);

	}

	// 출력메소드
	private void showData(Contact2 c) {
		System.out.println("\n---저장정보---");
		System.out.println("@이름: " + c.getName());
		System.out.println("@전화번호: " + c.getPhoneNum());
		System.out.println("@이메일: " + c.getEmail());
		System.out.println("@주소: " + c.getAddress());
		System.out.println("@생일: " + c.getBirthday());
		System.out.println("@그룹: " + c.getGroup());
	}

	// 수정메소드
	private void updateData(Contact2 c) {
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
