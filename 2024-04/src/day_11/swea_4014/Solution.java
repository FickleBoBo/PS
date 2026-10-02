package day_11.SWEA_모의SW역량테스트_4014;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			int ans = 2 * N;
			
			int[][] map = new int[N][N];
			int[][] counting = new int[N+2*X][N+2*X];
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N-1 ; j++) {
					if(map[i][j] > map[i][j+1]) {
						for(int k=1 ; k<=X ; k++) {
							counting[i+X][j+X+k] += map[i][j] - map[i][j+1];
						}
					}
					else if(map[i][j] < map[i][j+1]) {
						for(int k=0 ; k<X ; k++) {
							counting[i+X][j+X-k] += map[i][j+1] - map[i][j];
						}
					}
				}
			}
			
			for(int i=0 ; i<counting.length ; i++) {
				for(int j=0 ; j<counting[i].length ; j++) {
					if(counting[i][j] > 0) {
						if(i<X || i>=N+X || j<X || j>=N+X) {
							ans--;
							break;
						}
						else if(counting[i][j] > 1) {
							ans--;
							break;
						}
					}
				}
			}
			
			counting = new int[N+2*X][N+2*X];
			
			for(int j=0 ; j<N ; j++) {
				for(int i=0 ; i<N-1 ; i++) {
					if(map[i][j] > map[i+1][j]) {
						for(int k=1 ; k<=X ; k++) {
							counting[i+X+k][j+X] += map[i][j] - map[i+1][j];
						}
					}
					else if(map[i][j] < map[i+1][j]) {
						for(int k=0 ; k<X ; k++) {
							counting[i+X-k][j+X] += map[i+1][j] - map[i][j];
						}
					}
				}
			}
			
			for(int i=0 ; i<counting.length ; i++) {
				for(int j=0 ; j<counting[i].length ; j++) {
					if(counting[j][i] > 0) {
						if(i<X || i>=N+X || j<X || j>=N+X) {
							ans--;
							break;
						}
						else if(counting[j][i] > 1) {
							ans--;
							break;
						}
					}
				}
			}
			
//			System.out.println(ans);
//			for(int i=0 ; i<counting.length ; i++) {
//				for(int j=0 ; j<counting[i].length ; j++) {
//					System.out.print(counting[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			System.out.printf("#%d %d\n", tc, ans);
		}
		sc.close();
	}
}
