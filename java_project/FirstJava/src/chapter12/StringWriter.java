package chapter12;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class StringWriter {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		BufferedWriter out = new BufferedWriter(new FileWriter("String.txt"));
		
		// 한라인의 문자열을 받을 변수
		String str;
		
		while(true) {
			str = in.readLine();
		}
	
	}

}
