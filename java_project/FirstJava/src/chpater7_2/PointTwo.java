package chpater7_2;

import java.io.Serializable;

public class PointTwo implements Serializable{ //Serializable을 해줘야하는 이유: 마크를 저장을할때 (뒤쪽에서 다시 나옴)
	

	private int xPos;
	private int yPos;
	
	PointTwo(int x, int y){
		xPos = x;
		yPos = y;
	}

	@Override
	public String toString() {
		return "PointOne [xPos="+xPos+", yPos="+yPos+"]";
	}
	
	//오버라이딩할 수 있도록
	

}
