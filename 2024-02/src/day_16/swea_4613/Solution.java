package day_16.SWEA_D4_4613;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();                      // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {             // tc : 각각의 테스트 케이스
			int N = sc.nextInt();                  // N : 국기의 세로 길이(행)
			int M = sc.nextInt();                  // M : 국기의 가로 길이(열)
			String[][] flag = new String[N][M];    // flag : 국기 정보를 String[][]로 받을 예정
			
			/* flagColors
			 * 국기의 각 행에 대해서 얼마나 색을 칠하면 한 줄을 같은 색으로 채울 수 있는지 저장할 예정
			 * 0번 인덱스는 흰색을 채우는데 필요한 횟수
			 * 1번 인덱스는 파란색으로 채우는데 필요한 횟수
			 * 2번 인덱스는 빨간색으로 채우는데 필요한 횟수
			 */
			int[][] flagColors = new int[N][3];
			for(int i=0 ; i<N ; i++) {
				flag[i] = sc.next().split("");    // 한 글자(String)씩 쪼개서 넣음
				flagColors[i][0] = M;             // M으로 초기화 시키고 같은 색이 나오면 뺄셈 연산할 예정
				flagColors[i][1] = M;             // M으로 초기화 시키고 같은 색이 나오면 뺄셈 연산할 예정
				flagColors[i][2] = M;             // M으로 초기화 시키고 같은 색이 나오면 뺄셈 연산할 예정
			}
			
			
			
			// 2차원 배열을 돌며 같은 색이 나오면 그만큼 덜 칠해도 되니 뺄셈을 해줌
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<M ; j++) {
					if     (flag[i][j].equals("W")) flagColors[i][0]--;
					else if(flag[i][j].equals("B")) flagColors[i][1]--;
					else if(flag[i][j].equals("R")) flagColors[i][2]--;
				}
			}
			
			
			
			int min = Integer.MAX_VALUE;        // 출력할 값(int형 최댓값으로 초기화)
			for(int i=1 ; i<N-1 ; i++) {        // 파란색 시작 행 인덱스
				for(int j=i+1 ; j<N ; j++) {    // 빨간색 시작 행 인덱스
					
					int sum = 0;                // sum : 칠하는데 필요한 횟수
					
					for(int a=0 ; a<i ; a++) {    // 맨 위부터 파란색 시작전까지 흰색으로 칠한 횟수 셈
						sum += flagColors[a][0];
					}
					for(int b=i ; b<j ; b++) {    // 파란색 시작부터 빨간색 시작전까지 파란색으로 칠한 횟수 셈
						sum += flagColors[b][1];
					}
					for(int c=j ; c<N ; c++) {    // 빨간색 시작부터 국기 바닥까지 빨간색으로 칠한 횟수 셈
						sum += flagColors[c][2];
					}
					
					min = Math.min(min, sum);    // 더 최솟값으로 min값 갱신
				}
			}
			
			System.out.printf("#%d %d\n", tc, min);
			
		}
		sc.close();
	}
}
