package chapter04;

import java.util.Calendar;
import java.util.Scanner;

//10.13 수 대면
// 독감, 예방접종 퀴즈 내가 한거 + 선생님이 한거
// + 수업 내용 짬뽕

public class Member {
	
	String name; //인스턴스변수
	int birthyear;
	int age;
	
	
	//shift+alt+s 자동완성 generate constructor using fields
public Member(String name, int birthyear, int age) {
		//super();
		this.name = name;
		this.birthyear = birthyear;
		this.age = age;
	}

//	//기본생성자
	//안써도 기본으로 생성됨 그런데 있으면 매개변수가 없는 생성자 호출을 때로 해줄필요가 있음
//	Member(){
//	}
	//기본생성자. 초기화메소드. 반환이 아닌 초기화의 목적으로 사용
	// 이름데이터를 받아서 초기화
	Member(String name, int year){
		//지역변수
		// 지역변수1name = 지역변수1name; //지역변수1은 원래 인스턴스변수여야됨 근데 이렇게 둘이 잇으면 지역변수가 우선
		// 그래서 아래같이 사용. 똑같은 이름으로 만들어야 할 경우 구분 하면서 인스턴스받아오기 위해 참조변수 this를 사용.
		this.name=name;
		birthyear = year;
		age=ageCal(year);
	}
	
	//오버로딩
	Member(int year){
		//birthyear = year;
		//age=ageCal(year);
		this(null,year);
		//this는 위의 Member(String userName, int year)을 호출
	}
	
	//매개변수가 없는 생성자 호출
	//기본생성자
	Member(){}
	
//	① 독감예방 접종이 가능한지 여부를 확인하는 메소드를 정의합니다.
//	- 매개변수로 태어난 해(년도)를 전달받습니다.
//	- 15세 미만의 경우와 65세 이상의 경우 “무료예방접종이 가능합니다.” 메시지가 콘솔에 출력하도록 합니다.
//	- 위에서 정의한 조건의 범위가 아닌 나머지의 경우 “무료접종 대상이 아닙니다.”라고 출력하도록 합니다.

	public void fluVacheck() {
		
		//int age = 2021 - year - 1; //만나이

		if(age<15 || age>=65) {
			System.out.println("무료접종 대상이 아닙니다.");
		} else {
			System.out.println(age+"세입니다. 무료예방접종이 가능합니다.");
		}	
		
	}
	
////	② 건강검진 대상 여부를 판별하고 어떤 검진이 가능한지 확인하는 메소드를 정의합니다.
////	- 매개변수로 태어난 해(년도)를 전달받습니다.
////	- 대한민국 성인( 20세 )의 경우 무료로 2년마다 건강검진을 받을 수 있습니다.
////	- 짝수 해에 태어난 사람은 올해가 짝수년이라면 검사 대상이 됩니다.
////	- 40 이상의 경우는 암 검사도 무료로 검사를 할 수 있습니다.
	public void healthcheck() {
		
		// int age = 2021 - year - 1;

		boolean checkup = birthyear%2 == 2021%2; //검진대상 여부확인
		
		if(age>=20 && checkup) {
			System.out.println(age+"세 입니다. 건강검진을 받을 수 있습니다.");
			if(age>=40) {
				System.out.println("암 검사를 무료로 받을 수 있습니다.");
			} else {
				System.out.println("건강검진 대상이 아닙니다.");
			}
		}

	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Member member = new Member("손흥민", 2021); //인스턴스생성할때 딱 한번만 생성
		
		System.out.println("태어난 년도를 입력해주세요.");
		int birthyear = scanner.nextInt();
		
		System.out.println("이름: "+member.name);
		
		member.fluVacheck();
		
		member.healthcheck();		
		
		scanner.close();
		
	}
	
	
////	//========================
////	//쌤거
//	public void vaccineCheck(int birthyear) {
//		//나이연산
//		int age = 2021 - birthyear - 1;
//
//		boolean checkAge1 = age<15 || age >= 65;
//		boolean checkAge2 = !(age>=15 || age < 65);
//		
//		if(checkAge1) {
//			System.out.println("무료예방접종이 가능합니다.");
//		} else {
//			System.out.println("무료접종 대상이 아닙니다.");
//		}	
//	}
//	
//	public void checkUp(int birthyear) {
//		//나이연산
//		int age = 2021 - birthyear - 1;
//		//올해 연도 구하기
//		int year = Calendar.getInstance().get(Calendar.YEAR);
////		System.out.println(year);
//		
//		boolean checkup = birthyear%2 == year%2; //검진대상 여부확인
//		
//		if(age>=20 && checkup) {
//			System.out.println("올해 검진 대상입니다.");
//			if(age>=40) {
//				System.out.println("암검진 대상자 입니다.");
//			} else {
//				System.out.println("올해는 검진 대상이 아닙니다.");
//			}
//		}
//	}
//	
//	//중첩되는 연산, 공통코드들은 메소드로 빼는게 아주 좋은!
//	// 나이 연산 
	int ageCal(int year) {
		return Calendar.getInstance().get(Calendar.YEAR)-year-1;
	}
//	
//	public static void main(String[] args) {
//		Member member = new Member();
//		
//		member.vaccineCheck(2000);
//		member.checkUp(2000);
//	}
	

}
