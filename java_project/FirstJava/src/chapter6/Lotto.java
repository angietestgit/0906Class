package chapter6;

// 211014. 로또

public class Lotto {
	
	public static void main(String[] args) {
		//1~45까지의 숫자를 저장할 수 있는 배열을 생성
		int[] ball = new int[45];
		
		//각 배열의 요소에 1~45까지의 숫자를 저장
//		ball[0] = 1;
//		ball[1] = 2;... 이런짓하지 말고 반복문!
		for(int i = 0; i<ball.length; i++) {
			//각 요소에 값을 저장
			ball[i] = i+1;
		}
		
		for(int i = 0; i<ball.length; i++) {
			System.out.println(ball[i]);
		}
		
		System.out.println("숫자 섞기 ==========="); //셔플(섞기)
		
		// 임시변수 : 0번지의 값을 저장
		int temp = 0;
		
		// 만번 반복
		for(int i = 0; i<10000; i++) {
		// 랜덤한 index(정수) -> 0~44
		// 랜덤한 정수 뽑는 방법
		// 랜덤한 수를 절삭해서 int 정수 형변환시키고 +1은 시작이 0이아니라 1이라는거
		int index = (int)(Math.random()*44+1); // 0.0 <= r < 45.0 => 44.999999999 
		
		temp = ball[0];
		ball[0] = ball[index];
		ball[index] = temp;
		}
		
		//배열의 모든 요소 출력
		for(int i = 0; i<ball.length; i++) {
			System.out.println(ball[i]);
		}
		
		System.out.println("---------------");
		
		//배열의 요소 0~5 출력
		for(int i = 0; i<6; i++) {
			System.out.println(ball[i]);
		}
		
		//인덱스 정확하게 이해하고 넘어가기! ^^
 	}

}
