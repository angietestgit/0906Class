package kioskProjectTest;

import java.util.LinkedList;
import java.util.List;

public class Basket {

	public List<VO_Sales> list;
	
	
	public Basket(){
		list = new LinkedList<VO_Sales>();
	}
	
	
// add(): VO_Sales 객체 매개변수로 받아서 리스트에 추가
	public void add(VO_Sales s)  {
		list.add(s);
	}
	
	
// update(): VO_Sales객체 index 정수를 매개변수로 받아 리스트의 index번 인덱스에 있는 객체를 VO_Sales로 덮어씌운다.
	public void update(VO_Sales s, int index) {
		list.set(index, s);
	}
	
// delete(): VO_Sales 객체를 매개변수로 받아서 해당객체 삭제 (삭제하는 기준 : 상품명이 같으면 삭제)
	public void delete(VO_Sales s) {
	
		list.remove(s);
	}
	

}