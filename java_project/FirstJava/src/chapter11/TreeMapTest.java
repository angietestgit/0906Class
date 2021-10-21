package chapter11;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args) {
		
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		
		// 데이터를 저장
		map.put(1, "AAA");
		map.put(5, "EEE");
		map.put(3, "CCC");
		map.put(2, "BBB");
		map.put(4, "DDD");
		
		
		NavigableSet<Integer> navi = map.navigableKeySet();
		
		System.out.println("key값의 오름차순 출력");
		Iterator<Integer> itr = navi.iterator();
		while(itr.hasNext()) {
			System.out.println(map.get(itr.next()));
		}
		
		System.out.println("=================");
		
		System.out.println("key값의 내림차순 출력");
		itr = navi.descendingIterator();
		while(itr.hasNext()) {
			System.out.println(map.get(itr.next()));
		}
		
		//해시맵은 꼭 기억을 하기!!!! 어레이리스트!!! 강조 계속하는 이유가 있다구~~~
	}

}
