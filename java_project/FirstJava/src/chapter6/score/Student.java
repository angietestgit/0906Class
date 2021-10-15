package chapter6.score;

//퀴즈 쌤이랑 풀이
//2.Student 클래스를 정의해봅시다.
//③총점과 평균을 구해 결과를 반환하는 메소드를 정의합니다.


public class Student { //오브젝트클래스의 생성자는 없는 상태

	// 데이터 저장 목적
	
	//①학생이름, 국어점수, 영어점수, 수학점수를 저장하는 변수를 정의 합니다.
	//②변수는 캡슐화를 합니다. getter/setter 메소드를 정의합니다.
	private String name; //private 캡슐화
	private int scoreKor;
	private int scoreEng;
	private int scoreMath;
	
	//생성자 (Generate Constructor using Fields)
	public String getName() {
		return name;
	}
	public Student(String name, int scoreKor, int scoreEng, int scoreMath) {
		// super(); //상위클래스 생성자 호출, 오브젝트클래스 생성자가 없기 때문에 호출할 이유 없음. 생략가능
		this.name = name;
		this.scoreKor = scoreKor;
		this.scoreEng = scoreEng;
		this.scoreMath = scoreMath;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getScoreKor() {
		return scoreKor;
	}
	public void setScoreKor(int scoreKor) {
		this.scoreKor = scoreKor;
	}
	public int getScoreEng() {
		return scoreEng;
	}
	public void setScoreEng(int scoreEng) {
		this.scoreEng = scoreEng;
	}
	public int getScoreMath() {
		return scoreMath;
	}
	public void setScoreMath(int scoreMath) {
		this.scoreMath = scoreMath;
	}
	
	//③총점과 평균을 구해 결과를 반환하는 메소드를 정의합니다.
	public int getSum() {
		return this.scoreKor+this.scoreEng+this.scoreMath;
	}
	
	public float getAvg() {
		return getSum()/3.0f;
	}

	//오버라이딩 Generate toString 참조변수만 전달해주면
	// 데이터가 정상적으로 들어가는지 확인(디버깅, 외부에서 데이터가 정상적으로 들어가는지 확인)
	@Override
	public String toString() {
//		return "Student [name=" + name + ", scoreKor=" + scoreKor + ", scoreEng=" + scoreEng + ", scoreMath="
//				+ scoreMath + "]";
		return name+"\t"+scoreKor+"/t"+scoreEng+"\t"+scoreMath+"\t"+getSum()+"\t"+getAvg();
	}
	
		



}
