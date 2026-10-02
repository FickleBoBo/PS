package day_31.SWEA_D2_2001;

import java.util.Scanner;

public class Solution{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();                         // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {                // tc : 각 테스트 케이스 수행
			
			int N = sc.nextInt();                     // N : 파리가 있는 정사각형 배열 한변의 길이
			int M = sc.nextInt();                     // M : 정사각형 파리채 한변의 길이
			int[][] arr = new int[N][N];              // arr : 파리가 있는 배열 표현
			int[][] prefixSum = new int[N+1][N+1];    // prefixSum : arr의 누적합(패딩 O)
			
			for(int i=0 ; i<N ; i++) {    // 열심히 파리 입력 받기
				for(int j=0 ; j<N ; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i=1 ; i<=N ; i++) {    // 누적합 배열 채우기
				for(int j=1 ; j<=N ; j++) {
					prefixSum[i][j] = sum(arr, i, j);
				}
			}
			
			
			int max = 0;    // max : 가장 많은 파리를 죽였을 때
			int tmp = 0;    // tmp : 각각의 위치에서 죽인 파리의 수를 임시로 담을 변수
			for(int i=M ; i<=N ; i++) {
				for(int j=M ; j<=N ; j++) {
					tmp = prefixSum[i][j] - prefixSum[i-M][j] - prefixSum[i][j-M] + prefixSum[i-M][j-M];    // 누적합 점화식으로 죽인 파리의 수 계산
					if(tmp > max) {
						max = tmp;
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, max);

		}
		sc.close();
	}

	public static int sum(int[][] arr, int i, int j) {    // 누적합을 구하는 함수
		int sum = 0;                                      // 이중 for문으로 구리게 짬
		for(int r=0 ; r<i ; r++) {                        // 점화식을 이용하면 훨씬 좋을듯
			for(int c=0 ; c<j ; c++) {
				sum += arr[r][c];
			}
		}
		return sum;
	}
}