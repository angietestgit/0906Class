package chapter06.score;

public class ScoreMain {
	public static void main(String[] args) {
		
		//3.main()메소드에 아래 내용을 정의해봅시다.
		//
		//①Student 타입의 배열을 선언하고, 요소 10개를 저장할 수 있는 배열 인스턴스를 생성해 봅시다.
		Student[] score = new Student[10]; // null null null ..
		
		int numOfStudent = 0; //입력된 학생의 수!, 배열에 입력할 때 index로 사용
		
		//②Student 타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의해봅시다.
		Student s1 = new Student("손흥민", 100, 100, 100);
		//score[0] = s1; // 0번지에만 손흥민
		score[numOfStudent] = s1; //최초 학생 0
		numOfStudent++; //추가된 학생의 수를 +1증가
		
		Student s2 = new Student("이강인", 90,80,70);
		score[numOfStudent] = s2;
		numOfStudent++;
		
//		//③배열에 저장된 Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다.
//		for(Student student: score) {
//			System.out.println(
//					student.getScoreKor()
//					+"\t"+student.getScoreEng()
//					+"\t"+student.getScoreMath()
//					+"\t"+student.getSum()
//					+"\t"+student.getAvg()
//					); //값이 다 있을 때 출력
//		}
		
		//③배열에 저장된 Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다.
		for(int i=0; i<numOfStudent; i++ ) {
//			System.out.println(
//					score[i].getScoreKor()
//					+"\t"+score[i].getScoreEng()
//					+"\t"+score[i].getScoreMath()
//					+"\t"+score[i].getSum()
//					+"\t"+score[i].getAvg()
//					); 
			
			System.out.println(score[i]); // 출력
		} //클래스는 하나의 기능, 요소를 책임진다!
		
		// score[5].getAvg(); // 오류!!! 널값이기때문에
		
		// 데이터 입력 -> 배열에 저장
		// 데이터 검색 -> 배열의 요소(객체)에서 검색
		// 데이터 삭제 -> 배열의 요소를 객체
	}
	

}
