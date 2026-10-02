package day_28.SWEA_D3_4615;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	// 8방 탐색 델타배열(시계방향) -> 상 / 우상 / 우 / 우하 / 하 / 좌하 / 좌 / 좌상
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static Stack<int[]> st = new Stack<int[]>();    // 뒤집을지말지 고려할 좌표들을 스택에 우르르 넣고 처리할 예정
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();    // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {    // 각각의 테스트 케이스

			// step1 - 게임 시작전 세팅
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];
			map[N/2-1][N/2-1] = 2;
			map[N/2-1][N/2] = 1;
			map[N/2][N/2-1] = 1;
			map[N/2][N/2] = 2;

			// step2 - 좌표와 플레이어를 입력받아 setMap() 메서드에 던져주고 리턴 값을 map에 넣어 갱신
			for(int i=0 ; i<M ; i++) {
				
				int xpos = sc.nextInt()-1;
				int ypos = sc.nextInt()-1;
				int player = sc.nextInt();
				
				map = setMap(map, xpos, ypos, player);
				
//				printMap(map, xpos, ypos);
			}

			// step3 - countStones로 흑돌, 백돌 개수 배열로 입력받음
			int[] stones = countStones(map);
			System.out.printf("#%d %d %d\n", tc, stones[0], stones[1]);
			
		}
		sc.close();
	}

	// 원본 맵이 2차원 배열이라 이를 복사할 메서드
	static int[][] copyMap(int[][] arr){
		int N = arr.length;
		int[][] tmp = new int[N][N];
		for(int i=0 ; i<N ; i++) {
			tmp[i] = Arrays.copyOf(arr[i], N);
		}
		return tmp;
	}

	// 돌을 놓은 후 바뀐 맵을 리턴할 메서드
	static int[][] setMap(int[][]arr, int col, int row, int player){
		int N = arr.length;
		int[][] tmp = copyMap(arr);    // 원본 맵을 복사받음
		tmp[row][col] = player;
		int otherPlayer = player==1 ? 2 : 1;    // player는 1 아니면 2 라서 3항 연산자로 스위치해줌
		
		for(int dir=0 ; dir<8 ; dir++) {    // 8방 탐색하면서
			int nrow = row + dr[dir];
			int ncol = col + dc[dir];
			while((nrow >= 0) && (ncol >= 0) && (nrow < N) && (ncol < N)     // 새로운 좌표가 맵 범위 안이면서 상대 플레이어의 돌일 경우
					&& (tmp[nrow][ncol] == otherPlayer)) {
				st.push(new int[] {nrow, ncol});    // 해당 방향으로 계속 좌표들을 저장
				nrow += dr[dir];
				ncol += dc[dir];
			}
			if((nrow >= 0) && (ncol >= 0) && (nrow < N) && (ncol < N)     // 상대 돌이 연속으로 나오는게 끝나고 자신의 돌이 나오면
					&& tmp[nrow][ncol] == player) {
				while(!st.isEmpty()) {    // 뒤집기
					int[] turn = st.pop();
					tmp[turn[0]][turn[1]] = player;
				}
			}
			else {    // 자신의 돌이 안나오면 안뒤집으므로 스택을 비워줌
				st.clear();
			}
		}
		return tmp;
	}

	// 돌맹이 세기
	static int[] countStones(int[][] arr) {
		int N = arr.length;
		int black = 0;
		int white = 0;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(arr[i][j] == 1) black++;
				else if(arr[i][j] == 2) white++;
			}
		}
		return new int[] {black, white};
	}

	// 잘 풀고 있나 출력용 메서드
	static void printMap(int[][] arr, int col, int row) {
		int N = arr.length;
		System.out.println("row : " + row + " col : " + col);
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
