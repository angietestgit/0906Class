package ver06;

public class DuplicatePhoneNumberException extends Exception{

	public DuplicatePhoneNumberException(String arg0) {
		super("전화번호 형식에 맞지 않습니다.");
	}

	
}
