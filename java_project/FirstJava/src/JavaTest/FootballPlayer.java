package JavaTest;

import java.util.HashMap;

//
//1.축구선수 인스턴스를 저장할 수 있는 List<E> 컬렉션 인스턴스를 생성해서
// 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
//2.축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 같은 선수라 판단하고 입력이 되지 않도록
// Set<E> 컬렉션을 이용해서 축구선수 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
//3.TreeSet<E>을 이용해서 팀 이름순으로 정렬하고, 같은 팀의 선수들은 이름 순으로 정렬하고, 
// 같은 이름의 선수는 번호 순으로 저장하는 프로그램을 만들어 봅시다.
//4.축구선수의 번호를 key로 하고 축구선수 인스턴스를 저장하
// Map<K,V> 인스턴스를 이용해서 프로그램을 만들어봅시다.

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;


public class FootballPlayer implements Comparable<FootballPlayer> {

	String name;
	int number;
	String team;
	int age;

	public FootballPlayer(String name, int number, String team, int age) {
//		super();
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	@Override
	public String toString() {
		return "FootballPlayer [name=" + name + ", number=" + number + ", team=" + team + ", age=" + age + "]";
	}

	@Override
	public int compareTo(FootballPlayer o) {

		int result = this.team.compareTo(o.team);
		if(result == 0) {
			result = this.name.compareTo(o.name);
			if(result == 0) {
				result = this.number - o.number;
			}
		}

		return 0;
	}

	public static void main(String[] args) {

//		축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 같은 선수라 판단하고 입력이 되지 않도록
//		Set<E> 컬렉션을 이용해서 축구선수 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
		HashSet<FootballPlayer> list = new HashSet<FootballPlayer>();

		list.add(new FootballPlayer("SON", 1, "A", 28));
		list.add(new FootballPlayer("Lee", 2, "B", 20));
		list.add(new FootballPlayer("Park", 5, "C", 40));
		list.add(new FootballPlayer("KIM", 4, "D", 40));
		list.add(new FootballPlayer("Park", 3, "C", 40));

		Iterator<FootballPlayer> itr = list.iterator();
		while (itr.hasNext()) { // hasNext는 다음게 있다없다 가리킴
			FootballPlayer str = itr.next();
			//System.out.println(str);

//			if(str.compareTo(name, team, age) == 0 ) { //음수 0 양수로 비교
//				itr.remove();
//			

		}

		TreeSet<FootballPlayer> trset = new TreeSet<FootballPlayer>();
		trset.add(new FootballPlayer("SON", 1, "A", 28));
		trset.add(new FootballPlayer("Lee", 2, "B", 20));
		trset.add(new FootballPlayer("Park", 5, "C", 40));
		trset.add(new FootballPlayer("KIM", 4, "D", 40));
		trset.add(new FootballPlayer("Park", 3, "C", 40));

		
		Iterator<FootballPlayer> itrPlayer = trset.iterator();

		System.out.println("축구선수 리스트\n1)");

		itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		
		System.out.println("2)");
		
		
		HashMap<Integer, FootballPlayer> map = new HashMap<Integer, FootballPlayer>();
		
		map.put(1, new FootballPlayer("SON", 1, "A", 28));
		map.put(2, new FootballPlayer("Lee", 2, "B", 20));
		map.put(5, new FootballPlayer("Park", 5, "c", 40));
		map.put(4, new FootballPlayer("KIM", 4, "D", 40));
		map.put(3, new FootballPlayer("Park", 3, "C", 40));
		
		for(Integer i : map.keySet()) {
			System.out.println(map.get(i));
		}

	}
	
	
	//2.축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 같은 선수라 판단하고 입력이 되지 않도록
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj != null && obj instanceof FootballPlayer) {
			FootballPlayer player = (FootballPlayer) obj;
			if(this.team.equals(player.team) && this.name.equals(player.name)
					&& this.age == player.age) {
				result = true;
			}
		}
			

		return result;
	}
	
	
	@Override
	public int hashCode() {
		return this.age%10; //해시코드는10으로설정
	}
	
	



}
