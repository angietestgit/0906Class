package chapter06;

// 퀴즈
//2.Student 클래스를 정의해봅시다.
//
//①학생이름, 국어점수, 영어점수, 수학점수를 저장하는 변수를 정의 합니다.
//
//②변수는 캡슐화를 합니다. getter/setter 메소드를 정의합니다.
//
//③총점과 평균을 구해 결과를 반환하는 메소드를 정의합니다.
//
//​
//
//3.main()메소드에 아래 내용을 정의해봅시다.
//
//①Student 타입의 배열을 선언하고, 요소 10개를 저장할 수 있는 배열 인스턴스를 생성해 봅시다.
//
//②Student 타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의해봅시다.
//
//③배열에 저장된 Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다.

public class Student {
	String name;
	int korScore;
	int engScore;
	int mathScore;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorScore() {
		return korScore;
	}
	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}
	public int getEngScore() {
		return engScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	
	
	

}
