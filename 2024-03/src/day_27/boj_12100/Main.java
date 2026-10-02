package day_27.BOJ_G2_12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;                                    // N : 맵의 크기
	static int[][] map;                              // map : 게임할 테이블
	static int[][] copyMap;                          // copyMap : 원본 맵을 복사한 맵(각 명령 조합마다 원본을 복사해서 테스트)
	static char[] command = {'U', 'D', 'L', 'R'};    // command : 명령 조합
	static char[] sel = new char[5];                 // sel : 명령들 중 5개를 선택하는데 순서가 있어야 해서 순열로 저장
	static int ans = 0;                              // ans : 지금까지 찾은 최대 숫자 저장
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// step1 - 입력 받기(그냥 입력 받은거임)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		copyMap = new int[N][N];
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<N ; i++) {
			sb.append(br.readLine() + " ");
		}
		StringTokenizer st = new StringTokenizer(sb.toString(), " ");
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// step2 - 순열로 5가지 명령 조합을 하나씩 찾고 최대 숫자 갱신 반복
		permutation(0, 0);
		
		System.out.println(ans);
		
		br.close();
	}
	
	// 원본 맵을 복사하는 메서드
	private static void copyOriginMap() {
		for(int i=0 ; i<N ; i++) {
			copyMap[i] = Arrays.copyOf(map[i], N);
		}
	}
	
	// 명령 c에 대해서 블록들을 이동 및 합체시키는 메서드
	private static void dropBlocks(char c) {
		if(c=='U') {
			for(int j=0 ; j<N ; j++) {
				for(int i=0 ; i<N ; i++) {
					if(copyMap[i][j] == 0) {
						for(int k=i ; k<N ; k++) {
							if(copyMap[k][j] != 0) {
								copyMap[i][j] = copyMap[k][j];
								copyMap[k][j] = 0;								
								break;
							}
						}
					}
					if((i != 0) && (copyMap[i][j] > 0) && (copyMap[i][j]==copyMap[i-1][j])) {
						copyMap[i-1][j] *= 2;
						copyMap[i][j] = 0;
						for(int k=i ; k<N ; k++) {
							if(copyMap[k][j] != 0) {
								copyMap[i][j] = copyMap[k][j];
								copyMap[k][j] = 0;								
								break;
							}
						}
					}
				}
			}
		}
		else if(c=='D') {
			for(int j=0 ; j<N ; j++) {
				for(int i=N-1 ; i>=0 ; i--) {
					if(copyMap[i][j] == 0) {
						for(int k=i ; k>=0 ; k--) {
							if(copyMap[k][j] != 0) {
								copyMap[i][j] = copyMap[k][j];
								copyMap[k][j] = 0;
								break;
							}
						}
					}
					if((i != N-1) && (copyMap[i][j] > 0) && (copyMap[i][j]==copyMap[i+1][j])) {
						copyMap[i+1][j] *= 2;
						copyMap[i][j] = 0;
						for(int k=i ; k>=0 ; k--) {
							if(copyMap[k][j] != 0) {
								copyMap[i][j] = copyMap[k][j];
								copyMap[k][j] = 0;
								break;
							}
						}
					}
				}
			}
		}
		else if(c=='L') {
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					if(copyMap[i][j] == 0) {
						for(int k=j ; k<N ; k++) {
							if(copyMap[i][k] != 0) {
								copyMap[i][j] = copyMap[i][k];
								copyMap[i][k] = 0;
								break;
							}
						}
					}
					if((j != 0) && (copyMap[i][j] > 0) && (copyMap[i][j]==copyMap[i][j-1])) {
						copyMap[i][j-1] *= 2;
						copyMap[i][j] = 0;
						for(int k=j ; k<N ; k++) {
							if(copyMap[i][k] != 0) {
								copyMap[i][j] = copyMap[i][k];
								copyMap[i][k] = 0;
								break;
							}
						}
					}
				}
			}
		}
		else if(c=='R') {
			for(int i=0 ; i<N ; i++) {
				for(int j=N-1 ; j>=0 ; j--) {
					if(copyMap[i][j] == 0) {
						for(int k=j ; k>=0 ; k--) {
							if(copyMap[i][k] != 0) {
								copyMap[i][j] = copyMap[i][k];
								copyMap[i][k] = 0;
								break;
							}
						}
					}
					if((j != N-1) && (copyMap[i][j] > 0) && (copyMap[i][j]==copyMap[i][j+1])) {
						copyMap[i][j+1] *= 2;
						copyMap[i][j] = 0;
						for(int k=j ; k>=0 ; k--) {
							if(copyMap[i][k] != 0) {
								copyMap[i][j] = copyMap[i][k];
								copyMap[i][k] = 0;
								break;
							}
						}
					}
				}
			}
		}
	}

	// 복사한 맵에서 가장 큰 숫자를 반환하는 메서드
	private static int maxNum() {
		int max = 0;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				max = Math.max(max, copyMap[i][j]);
			}
		}
		return max;
	}
	
	// 5개의 명령 조합을 찾으면 각각의 명령을 복사한 맵에서 실행하고 최댓값을 찾아서 현재까지 찾은 최댓값과 비교
	private static void permutation(int idx, int sidx) {
		if(sidx==5) {
			copyOriginMap();
			for(char c : sel) {
				dropBlocks(c);
			}
			ans = Math.max(ans, maxNum());
			return;
		}
		
		for(int i=0 ; i<4 ; i++) {
			sel[sidx] = command[i];
			permutation(idx+1, sidx+1);
		}
		
		
	}
	
}
