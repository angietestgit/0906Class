package chapter6;

import java.util.Scanner;

//문제 1.
//int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최대값,
//그리고 최소값을 구해서 반환하는 메소드를 다음의 형태로 각각 정의.
// public static int miniValue(int[] arr) { . . . . } // 최소값 반환
// public static int maxValue(int[] arr) { . . . . } // 최대값 반환
//
//위의 두 매소드는 인자로 전달되는 "배열의 길이에 상관없이 동작"하도록 정의.
//두 매소드 실행을 확인하기 위한 main 메소드 정의.
//int형 배열에 채워질 정수는 프로그램 사용자로부터 입력 받고, 배열의 길이는
//임의로 결정

//핵심은 배열을 매개변수로 전달하고 받을 수 있다는 것!


public class ArrEx01 {
	Scanner scanner;
	
	
	public static int minValue(int[] arr) {
		int min = arr[0]; // 처음값을 최소값으로 저장
		
		//각 요소의 값과 최소값들을 비교 후 새로운 값이 더 작을 때 최소값으로 저장
		// 전달 받은 배열의 사이즈만큼 반복하면서 비교
		// "배열의 길이에 상관없이 동작"은 length를 의미함
		for(int i = 1; i<arr.length; i++) {
			
			if(arr[i]<min) {
				min = arr[i];
			}
		}
		
		return min;
		} // 최소값 반환

	public static int maxValue(int[] arr) {
		// 최댓값
		int max = arr[0];
		
		for(int i = 1; i <arr.length; i++ ) {
			if(arr[i]>max) {
				max= arr[i];
			}
		}
		
		return max;
	} // 최대값 반환


	public static void main(String[] args) {

		//배열 생성
		int[] arr = {100, 240, 180, 60, 150, 90, 30, 200};
		int[] arr2 = {100, 240, 200};
		
		System.out.println("최대값: "+maxValue(arr));
		System.out.println("최소값: "+minValue(arr2));
		
		
	}
}
