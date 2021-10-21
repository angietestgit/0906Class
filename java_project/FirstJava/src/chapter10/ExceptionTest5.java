package chapter10;

public class ExceptionTest5 {
//	public static void main(String[] args) throws Exception{
//
//		// 1. 예외 객체 생성
//		Exception e = new Exception("개발자가 고의로 발생시킨 예외");
//		
//		// 2. 예외 발생
//		throw e; //호출한쪽으로 예외를 던져버리기.
//				   catch블럭이나 위처럼 throw Exception달린 메소드로 
//				     호출받은쪽에서 예외를 처리해줌
//		
//	}

	public static void main(String[] args) {

		try {
			// 1. 예외 객체 생성 (예외매시지가 고의로발생시킨~ 이 뜸)
			Exception e = new Exception("개발자가 고의로 발생시킨 예외");

			// 2. 예외 발생
			throw e; // 호출한쪽으로 예외를 던져버리면 호출받은쪽에서 예외를 처리해줌
		
		} catch (Exception e) {
			System.out.println("예외 메시지: " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("프로그램이 종료됩니다.");
	}
}
