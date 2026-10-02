package day_14.SWEA_D2_1961;

import java.util.Scanner;

public class Solution {
	
	static int[][] clockwiseRotation(int[][] arr) {    // 입력 받은 2차원 배열을 90도 돌려서 리턴
		int len = arr.length;
		int[][] arrR = new int[len][len];
		
		for(int i=0 ; i<len ; i++) {
			for(int j=0 ; j<len ; j++) {
				arrR[i][j] = arr[len-j-1][i];
			}
		}
		return arrR;
	}
	
	static void printArr(int[][] arr1, int[][] arr2, int[][] arr3) {    // 출력 조건을 맞춘 억지 메소드
		int len = arr1.length;
		
		for(int i=0 ; i<len ; i++) {
			for(int j=0 ; j<len ; j++) {
				System.out.print(arr1[i][j]);
			}
			System.out.print(" ");
			for(int j=0 ; j<len ; j++) {
				System.out.print(arr2[i][j]);
			}
			System.out.print(" ");
			for(int j=0 ; j<len ; j++) {
				System.out.print(arr3[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int[][] arr90 = clockwiseRotation(arr);        // 90도 휘바휘바
			int[][] arr180 = clockwiseRotation(arr90);     // 90도 돌린거 다시 90도 휘바휘바
			int[][] arr270 = clockwiseRotation(arr180);    // 180도 돌린거 마지막으로 90도 휘바휘바
			
			System.out.println("#" + tc);
			printArr(arr90, arr180, arr270);
		}
		sc.close();
	}
}
