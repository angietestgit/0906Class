package chapter10;

public class ExceptionTest4 {
	public static void main(String[] args) {

		int[] arr = new int[3];
		Object o = new String("abc"); // Object 타입은 최상위
		String str = null; //널포인터 예외 예제
		
		String number = "one"; //String -> int 예외예제

		
		try {
			// 배열 인덱스를 잘못 처리한 경우
			System.out.println(arr[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("예외 발생!!!");
			System.out.println(e.getMessage()); // 에러메시지 뜨게
		}

		try {
			Integer i = (Integer) o;
		} catch (ClassCastException e) {
			System.out.println("예외 발생!!!");
			System.out.println(e.getMessage());
		}

		int size = -10;

		try {
			int[] arr1 = new int[size];
		} catch (NegativeArraySizeException e) {
			System.out.println("예외 발생!!!");
			System.out.println(e.getMessage());
		}
		

		try {
			System.out.println(str.toUpperCase());
		} catch (NullPointerException e) {
			System.out.println("예외 발생!!!");
			System.out.println(e.getMessage());
		}
		
		
		try {
		//String -> int
		int temp = Integer.parseInt(number);
		} catch (NumberFormatException e) {  //예외처리를 뭘로할 지 모르겠으면 오라클홈페이지에서 api도 봐보기
			System.out.println("예외 발생!!!");
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("프로그램을 종료합니다.");
		
		
	}

}
