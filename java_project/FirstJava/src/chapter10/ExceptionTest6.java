package chapter10;

public class ExceptionTest6 {
	public static void main(String[] args) {

		try {
			System.out.println(10 / 2);
			return; //리턴해도 파이널리까지는 무조건 실행후 리턴됨
		} catch (Exception e) {
			System.out.println("예외발생 = 예외처리");
		} finally {
			System.out.println("예외상황과 상관없이 실행!(catch없어도)");

		}

		try {
			System.out.println("try");
		} finally {
			System.out.println("finally"); //데이터베이스 처리 코드만들때 특히 잘 씀!

		}

	}
}
