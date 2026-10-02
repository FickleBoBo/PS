package day_04.BOJ_G4_16234_Fail;

import java.util.Scanner;

public class Main {
	
	static int[][] population;
	static int[][] linkMat;
	static boolean[] visited;
	static int N;
	static int L;
	static int R;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		population = new int[N][N];
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				population[i][j] = sc.nextInt();
			}
		}
		
		linkMatrixUpdate();
//		printTable();
		
		
		for(int i=0 ; i<N ; i++) {
			visited = new boolean[N];
			linkSearch(i);
			pMove();
		}
		
		sc.close();
	}
	
	

//	static void printTable() {
//		for(int i=0 ; i<N*N ; i++) {
//			for(int j=0 ; j<N*N ; j++) {
//				System.out.print(linkMat[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
	
	static void linkMatrixUpdate() {
		linkMat = new int[N*N][N*N];
		
		for(int r=0 ; r<N ; r++) {
			for(int c=0 ; c<N ; c++) {
				for(int k=0 ; k<4 ; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					if((nr>=0) && (nc>=0) && (nr<N) && (nc<N) && 
							(Math.abs(population[r][c]-population[nr][nc])>=L) && 
							(Math.abs(population[r][c]-population[nr][nc])<=R)) {
						linkMat[N*r+c][N*nr+nc] = 1;
					}
				}
			}
		}
	}
	
	static void linkSearch(int idx) {
		for(int i=idx ; i<N*N ; i++) {
			if(!(visited[idx]) && (linkMat[idx][i] == 1)) {
				visited[idx] = true;
				linkSearch(i);
			}
		}
	}
	
	static void pMove() {
		int num = 0;
		for(int i=0 ; i<N ; i++) {
			if(visited[i]) {
				num += population[i / (int) (Math.sqrt(N))][i % (int) (Math.sqrt(N))];
			}
		}
		System.out.println(num);
	}
	
	
}
