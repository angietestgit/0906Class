package JavaTest;

public class BadIdInputException extends Exception {

	public BadIdInputException() {
		super("유효하지 않은 아이디가 입력되었습니다.");
	}

	public BadIdInputException(String id) {
		super(id + "는 유효한 아이디 정보가 아닙니다.");

	}

	public void print() {
		System.out.println("예외 클래스에 정의한 메소드입니다.");
	}

}
