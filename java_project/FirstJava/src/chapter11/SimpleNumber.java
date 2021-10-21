package chapter11;

public class SimpleNumber {
	
	int num;
	
	SimpleNumber(int num){
		this.num = num;
	}
	
	@Override
	public String toString() {
		return String.valueOf(num); //스트링타입을 반환
	}
	
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false; //초기값 설정
		
		//obj -> 형변환 //아래코드는 비교해서 트루를반환하는 처리 잘쓰이는코드니깐 잘 알아두기
		SimpleNumber sNum = (SimpleNumber)obj;
		if(sNum.num == this.num) {
			result = true;
		} 
		
		return result;
	}
	
	@Override
	public int hashCode() {
		return this.num%10; //해시코드는10으로설정
	}
	
	
}
