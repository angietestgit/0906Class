package chapter11;

public class Person implements Comparable<Person> {
	
	String name;
	int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	} //여기까지 초기화 완료

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person o) {
		if(this.age>o.age) {
			return 1; //양수
		} else if(this.age<o.age) {
			return -1;//음수
		} else {
			//return 0; //또 다른 기준
			return this.name.compareTo(o.name); //나이가 같으면 이름순으로 정렬시킴(오름차순기본)
			//return -(this.name.compareTo(o.name)); // -를 붙이면 위와 반대차순
		}

		//
//		return this.age-o.age; //this.age 와 o.age를 빼서 비교하는 법임 위와 같은 코드!
		//
//		return -(this.age-o.age);

	}
	
	
	
	

}
