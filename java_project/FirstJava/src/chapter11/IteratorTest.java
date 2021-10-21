package chapter11;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorTest {
	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<String>();
		list.add("First");
		list.add("Second");
		list.add("Third");
		list.add("Forth");
		
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) { //hasNext는 다음게 있다없다 가리킴
			String str = itr.next();
			System.out.println(str);
			
			if(str.compareTo("Third") == 0 ) { //음수 0 양수로 비교
				itr.remove();
			}
			
		}
		
		System.out.println("Third 제거 후 리스트");
		
		itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

	}
}
