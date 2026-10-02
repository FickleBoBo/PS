package day_30.SWEA_D1_2063;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();    // N : 점수의 개수
		int[] arr = new int[N];    // arr : 점수를 담을 배열
		
		for(int i=0 ; i<N ; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0 ; i<=N/2 ; i++) {    // 선택정렬(i 값의 범위가 포인트~!!)
			int minIdx = i;
			for(int j=i+1 ; j<N ; j++) {
				minIdx = arr[minIdx]<arr[j] ? minIdx : j;
			}
			int tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;
		}
		
		System.out.print(arr[N/2]);    // 199/2 = 99 = 배열에서 100번째~!!(중간)
		sc.close();
	}
}
