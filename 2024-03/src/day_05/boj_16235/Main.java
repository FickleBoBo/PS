package day_05.BOJ_G3_16235;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[][] foodMap;
	static int[][] addFoodMap;
	static int[][] treeIdxMap;
	static int[][][] treeMap;
	static int[][] deadTree;
	static int N;
	static int cnt;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();

		foodMap = new int[N][N];
		for(int i=0 ; i<N ; i++) {
			Arrays.fill(foodMap[i], 5);
		}
		
		addFoodMap = new int[N][N];
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				addFoodMap[i][j] = sc.nextInt();
			}
		}
		
		treeIdxMap = new int[N][N];
		
		treeMap = new int[N][N][1000];
		for(int i=0 ; i<M ; i++) {
			int r = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			treeMap[r][c][++treeIdxMap[r][c]] = sc.nextInt();
			cnt++;
		}
		
		deadTree = new int[N][N];
		
		while(K > 0) {
			printAll();
			Spring();
			printAll();
			Summer();
			printAll();
			Fall();
			printAll();
			Winter();
			printAll();
		
			K--;
		}

		System.out.println(cnt);
		
		sc.close();
	}
	
	static void printAll() {
		System.out.println("푸드맵");
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				System.out.print(foodMap[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("애드푸드맵");
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				System.out.print(addFoodMap[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("트리맵");
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				System.out.print(treeMap[i][j][2] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("트리인덱스맵");
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				System.out.print(treeIdxMap[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void Spring() {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				int len = treeIdxMap[i][j];
				for(int k=0 ; k<len ; k++) {
					if((foodMap[i][j] - treeMap[i][j][k]) > 0) {
						foodMap[i][j] -= treeMap[i][j][k];
						treeMap[i][j][k] *= 2;
					}
					else {
						deadTree[i][j] += treeMap[i][j][k];
						treeMap[i][j][k] = 0;
						treeIdxMap[i][j]--;
						cnt--;
					}
				}
				Arrays.sort(treeMap[i][j]);
			}
		}
		
	}

	private static void Summer() {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				foodMap[i][j] += deadTree[i][j] / 2;
			}
		}
		
	}
	
	private static void Fall() {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				int len = treeIdxMap[i][j];
				for(int k=0 ; k<len ; k++) {
					if(treeMap[i][j][k] % 5 == 0) {
						for(int dir=0 ; dir<8 ; dir++) {
							int nr = i + dr[dir];
							int nc = j + dc[dir];
							if((nr>=0) && (nc>=0) && (nr<N) && (nc<N)) {
								treeMap[nr][nc][treeIdxMap[nr][nc]++] = 1;
								cnt++;
								Arrays.sort(treeMap[i][j]);
							}
						}
					}
				}
			}
		}
		
	}

	private static void Winter() {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				foodMap[i][j] += addFoodMap[i][j];
			}
		}
	}
	
	
	
}
