package chapter07;

public class ClassPrinter {
	
	public static void print(Object obj) { //Object 는 어떤 타입이던 받겠다는 의미

		// 전달받은 객체의 toString() 출력
		String str = obj.toString();
		
		// 해당 객체가 UpperCasePrintable 을 구현하고 있는지 체크
		// 구현하고 있다면 대문자로 출력
		if(obj instanceof UpperCasePrintable) {
			str = str.toUpperCase();
			
		}
		
		System.out.println(str);
		
	}
}
