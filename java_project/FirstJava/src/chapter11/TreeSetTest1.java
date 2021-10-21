package chapter11;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest1 {
	public static void main(String[] args) {
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(4);
		set.add(3);
		set.add(1);
		set.add(2);
		set.add(5);
		set.add(3);
		set.add(1);
		
		System.out.println("요소의 개수 : " + set.size());
		
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) { //itr이 다음요소가 있는지 확인하고 출력
			System.out.println(itr.next());
		}
		
		
	}

}
