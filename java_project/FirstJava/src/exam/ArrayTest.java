package exam;

public class ArrayTest {
	//쌤거 fork

	public static void main(String[] args) {

		int[][] arr1 = { 
				{ 1, 2, 3 }, 
				{ 4, 5, 6 }, 
				{ 7, 8, 9 }, 
				{ 10, 11, 12 } 
				};

		// 출력
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j] + "\t");
			}
			System.out.println();
		}

		/////////////////////////////////////////////
		// 행의 시프트

		// 임시 배열 선언
		int[] temp = arr1[arr1.length - 1];

		for (int i = arr1.length - 1; i > 0; i--) {
			arr1[i] = arr1[i - 1];
		}

		arr1[0] = temp;

		//////////////////////////////////////////////

		System.out.println("시프트 ====================");
		// 출력
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("============================");

		// 배열 생성
		int[] arr = { 100, 240, 180, 60, 150, 90, 30, 200 };
		int[] arr2 = { 100, 240, 200 };

		System.out.println("최대값: " + maxValue(arr2));
		System.out.println("최소값: " + miniValue(arr2));

		// 2차원 배열의 선언
		int[][] arr3 = { { 1, 2, 3 }, { 4, 5, 6, 7 }, { 8, 9, 10, 11, 12, 13 } };

		System.out.println("2차원 배열 출력");
		addOneDArr(arr3, 100);
		
		System.out.println("====================================");
		//for-each
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("====================================");
		for(int num : arr) {
			System.out.println(num);
		}

	}

	public static void addOneDArr(int[][] arr, int add) {

		// 2차원 배열의 출력
		// 행
		for (int i = 0; i < arr.length; i++) {
			// 열
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

		// 매개변수로 전달 받은 숫자를 각 요소에 더해준다.
		for (int i = 0; i < arr.length; i++) {
			// 열
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] += add;
			}
		}

		System.out.println("각 요소에 숫자를 더하기 ===================");

		// 2차원 배열의 출력
		// 행
		for (int i = 0; i < arr.length; i++) {
			// 열
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

	// 최소값 반환
	public static int miniValue(int[] arr) {

		// 최소값
		int minVal = arr[0]; // 처음값을 최소값으로 저장

		// 각 요소의 값과 최소값들을 비교 후 새로운 값이 더 작을 때 최소값으로 저장
		// 전달받은 배열의 사이즈만큼 반복하면서 비교
		for (int i = 1; i < arr.length; i++) {

			if (arr[i] < minVal) {
				minVal = arr[i];
			}
		}

		return minVal;
	}

	// 최대값 반환
	public static int maxValue(int[] arr) {
		// 최대값
		int maxVal = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > maxVal) {
				maxVal = arr[i];
			}
		}

		return maxVal;
	}

}