package chapter06.score;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreManager2 {

	// 배열을 가지고 있고.
	// 배열의 요소를 추가, 검색, 삭제 기능

	//배열을 완전히 이해한다는 가정!
	// 2021.10.20 : 배열을 ArrayList로 변경
	// 정리한 버전 -> ArrayList를 쓰면 훨씬 깔끔하다는 것을 알 수 있다.

	public static final Scanner sc = new Scanner(System.in);

	private List<Student> score;
	private int numOfStudent;

	public ScoreManager2(int size) {
		score = new ArrayList<Student>(size);
	}

	public ScoreManager2() {
		this(10); // this에 10개 학생이 만들어 지도록
	}

	// 전체 데이터 출력 : 배열에 입력된 모든 데이터를 출력
	public void showAllData() {
		System.out.println("학생 점수 리스트");
		System.out.println("--------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("--------------");

		for (Student s : score) {
			System.out.println(s); // 각각의 요소를 출력
		}

		System.out.println("--------------");

	}

	// 데이터 추가 : 배열의 요소로 추가 -> Student 타입의 참조값
	public void insertScore(Student s) {

	}

	// 데이터 검색 : 이름 기준 검색 -> 배열의 요소 들중 이름(검색어)을 비교
	public void searchData() {

		System.out.println("검색하고자하는 학생의 이름을 입력해주세요.");
		String name = sc.nextLine();

		// -1 또는 배열 범위 안의 정수 0~N-1
		int index = searchIndex(name);

		if (index > -1) {
			System.out.println(score.get(index));
		} else {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		}

	}

	// 데이터 삭제 : 이름 기준으로 삭제
	// -> 배열에 요소에 손흥민 정보를 지운다! -> 손흥민 객체를 참조하는 값이 없으면
	public void deleteScore() {

		System.out.println("삭제 하고자 하는 학생의 이름을 입력해주세요.");
		String name = sc.nextLine();

		int index = searchIndex(name);

		if (index > -1) {
			score.remove(index); //리무브에 전달받은 인덱스를 삭제
			System.out.println("검색하신 정보가 삭제되었습니다.");

		} else {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		}
	}

	// 이름으로 배열의 index 찾아 index값을 반환하는 메소드
	private int searchIndex(String name) {

		int index = -1;

		for (int i = 0; i < score.size(); i++) {
			if (score.get(i).getName().equals(name)) {
				index = i;
				break;
			}
		}

		return index;
	}

	// 학생 정보를 저장하고 -> 배열에 저장하는 메소드
	public void insertStudent() {

		System.out.println("학생 성적 데이터를 입력합니다.");

		System.out.println("이름> ");
		String name = sc.nextLine();
		System.out.println("국어 점수> ");
		int scoreKor = Integer.parseInt(sc.nextLine());
		System.out.println("영어 점수> ");
		int scoreEng = Integer.parseInt(sc.nextLine());
		System.out.println("수학 점수> ");
		int scoreMath = Integer.parseInt(sc.nextLine());

		// Student 객체 생성 -> 배열에 저장
		insertScore(new Student(name, scoreKor, scoreEng, scoreMath));
		System.out.println("성적 데이터가 입력되었습니다.");

	}

}
