package chapter09;

import java.util.Random;

public class RandomNumberGenerator {
	public static void main(String[] args) {

		// (int)(Math.random()*10)+1 -> 1~10

		Random r1 = new Random();

		for (int i = 0; i < 10; i++) {
			// 1~10
			int num1 = r1.nextInt(10) + 1; // 0~9 0이상10미만+1-> 10이하
			//System.out.println(num1);
		
		}
		
		Random r2 = new Random(2);		//시드에 맞는 난수의 특정패턴이 나옴
		for (int i = 0; i < 10; i++) {
			// 1~10
			long num = System.currentTimeMillis(); //밀리단위로쪼갬
			long num2 = System.nanoTime(); //나노단위로쪼갬 
			
			r2.setSeed(num2); 
			int num1 = r2.nextInt(10) + 1; 
			System.out.println(num1);
		
		}
		
	}
}
