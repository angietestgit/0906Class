package chapter11;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest1 {
	public static void main(String[] args) {
		
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("First");
		hashSet.add("Second");
		hashSet.add("Third");
		hashSet.add("First");
		
		System.out.println("모든 요소의 개수 : " +hashSet.size()); //셋은 같은걸 다시 세지 않음!
		
		
		Iterator<String> itr = hashSet.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

	}
}