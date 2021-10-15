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

		// 2차원배열의 shift 퀴즈풀이
		int[][] arr1 = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10,11,12}
		};
		
		//출력
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				System.out.print(arr1[i][j]+"\t");
			}
			System.out.println();
		}
		//////////////////////////////////////////////////
		// 행의 시프트
		
		//임시배열 선언
		int[] temp = arr1[arr1.length-1];
		
		for(int i=arr1.length-1; i>0; i--) {
			arr1[i] = arr1[i-1];
		}
		
		arr1[0] = temp;
		/////////////////////////////////////////////////
		System.out.println("행의 시프트");
		//출력
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				System.out.print(arr1[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("============================");
		
		//배열 생성
		int[] arr = {100, 240, 180, 60, 150, 90, 30, 200};
		int[] arr2 = {100, 240, 200};
		
		System.out.println("최대값: "+maxValue(arr));
		System.out.println("최소값: "+minValue(arr2));
		
		// 2차원 배열의 선언
		int[][] arr3 = {
				{1, 2, 3},
				{4, 5, 6, 7},
				{8,9,10,11,12,13} //가변배열
		};
		System.out.println("2차원 배열 출력");
		addOneDArr(arr3, 100);
		
		System.out.println("=============================");
		// for-each문
		for(int i=0; i<arr.length; i++) {
			System.out.println("arr[i]");
		}
		System.out.println("=============================");
		for(int num : arr) { // 각요소를 변경할 떄 안쓰고 참조에서 읽어올 때만 포이치문 사용
			System.out.println(num);
		}
	}
	
	public static void addOneDArr(int[][] arr, int add) {
		
		//2차원 배열의 출력
		// 행
		for(int i=0; i<arr.length; i++) {
			// 열
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+ "\t");
				
			}
			System.out.println();
		}
		
		// 매개변수로 전달 받은 숫자를 각 요소에 더해준다.
		for(int i=0; i<arr.length; i++) {
			// 열
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] += add;
			}
		}
		
		
		System.out.println("각 요소에 숫자를 더하기=====");
		
		//2차원 배열의 출력
		// 행
		for(int i=0; i<arr.length; i++) {
			// 열
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+ "\t");
				
			}
			System.out.println();
		}
	}
}
