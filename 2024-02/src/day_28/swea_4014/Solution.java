package day_28.SWEA_모의SW역량테스트_4014;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();    // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {    // 각각의 테스트 케이스
			int N = sc.nextInt();
			int X = sc.nextInt();
			int ans = 2 * N;    // 최댓값에서 만족 안하는 경우마다 하나씩 빼서 답 구할 예정
			
			int[][] map = new int[N][N];
			int len = X+N+X;
			int[][] putRampRow = new int[len][len];    // 패딩주고 행에서 경사로를 설치한 인덱스를 +1 해줄 카운팅 배열
			int[][] putRampCol = new int[len][len];    // 패딩주고 열에서 경사로를 설치한 인덱스를 +1 해줄 카운팅 배열
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			
			// 각 행마다 상향, 하향 경사로를 설치해야 할 경우 해당 카운팅 배열에 둘의 높이 차를 더해줌
			// 둘의 높이 차가 경사로의 높이를 넘어가도 활주로가 불가능하므로 이를 찾기 위함(안하면 테케 2개 안돌아감)
			for(int row=0 ; row<N ; row++) {
				for(int col=0 ; col<N-1 ; col++) {
					if(map[row][col] > map[row][col+1]) {
						for(int i=1 ; i<=X ; i++) {
							putRampRow[X+row][X+col+i] += map[row][col] - map[row][col+1];
						}
					}
					else if(map[row][col] < map[row][col+1]) {
						for(int i=0 ; i<X ; i++) {
							putRampRow[X+row][X+col-i] += map[row][col+1] - map[row][col];
						}
					}
				}
			}

			
			// 똑같은거 열에서 해줌
			for(int row=0 ; row<N ; row++) {
				for(int col=0 ; col<N-1 ; col++) {
					if(map[col][row] > map[col+1][row]) {
						for(int i=1 ; i<=X ; i++) {
							putRampCol[X+col+i][X+row] += map[col][row] - map[col+1][row];
						}
					}
					else if(map[col][row] < map[col+1][row]) {
						for(int i=0 ; i<X ; i++) {
							putRampCol[X+col-i][X+row] += map[col+1][row] - map[col][row];
						}
					}
				}
			}

			// 행 카운팅 배열을 돌며 인덱스 넘어간거랑 경사로 중복설치(2 이상인거) 찾음
			for(int i=0 ; i<len ; i++) {
				for(int j=0 ; j<len ; j++) {
					if((putRampRow[i][X-1] > 0) || (putRampRow[i][N+X] > 0)) {
						ans--;
						break;
					}
					if(putRampRow[i][j] > 1) {
						ans--;
						break;
					}
				}
			}

			// 똑같은거 열에서 해줌
			for(int i=0 ; i<len ; i++) {
				for(int j=0 ; j<len ; j++) {
					if((putRampCol[X-1][i] > 0) || (putRampCol[N+X][i] > 0)) {
						ans--;
						break;
					}
					if(putRampCol[j][i] > 1) {
						ans--;
						break;
					}
				}
			}
			
//			for(int i=0 ; i<len ; i++) {
//				for(int j=0 ; j<len ; j++) {
//					System.out.print(putRampRow[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			
//			for(int i=0 ; i<len ; i++) {
//				for(int j=0 ; j<len ; j++) {
//					System.out.print(putRampCol[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			
			
			
			System.out.printf("#%d %d\n", tc, ans);
			
		}
		sc.close();
	}
}
