package day_14.SWEA_D3_7236;

import java.util.Scanner;

public class Solution {
	
	static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};    // 상 하 좌 우 좌상 좌하 우상 우하
	static int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};    // 상 하 좌 우 좌상 좌하 우상 우하
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			int N = Integer.parseInt(sc.nextLine());    // Integer랑 String 같이 받을 때는 제발 이렇게
			int[][] mat = new int[1+N+1][1+N+1];        // 패딩 주고 물은 1, 땅은 0으로 변환함
			String[][] tmp = new String[N][N];          // 일단 String으로 입력 받음
			
			for(int i=0 ; i<N ; i++) {                  // 입력 받으면서 바로 변환해줌(시간 250ms -> 133ms로 단축)
				tmp[i] = sc.nextLine().split(" ");
				for(int j=0 ; j<N ; j++) {
					if(tmp[i][j].equals("W")) {         // 0으로 배열이 초기화 되어있어서 물만 고려하면 됨
						mat[i+1][j+1] = 1;              // 패딩 고려해서 옮겨줌
					}
				}
			}

			int max = 0;
			for(int i=1 ; i<=N ; i++) {
				for(int j=1 ; j<=N ; j++) {
					if(mat[i][j]==1) {                // 물 만났을 때
						int ans = 0;
						for(int k=0 ; k<8 ; k++) {    // 8방 탐색
							ans += mat[i+dr[k]][j+dc[k]];
						}
						if(ans == 0) {                // 물 만났는데 주변이 전부 땅이면
							ans = 1;
						}
						max = Math.max(max, ans);     // 기존의 최댓값이랑 비교
					}
				}
			}
			System.out.printf("#%d %d\n", tc, max);
		}
		sc.close();
	}
}
