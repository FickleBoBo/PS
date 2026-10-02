package day_27.BOJ_S1_1074_Fail;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int r;
	static int c;
	static int ans;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int L=0 ; L<7 ; L++) {
			N = sc.nextInt();
			r = sc.nextInt();
			c = sc.nextInt();
			ans = (int) ( Math.pow(2, N) * Math.pow(2, N));
			
			DFS(N, r, c);
			
			System.out.println(ans-1);
		}
		sc.close();
	}

	private static void DFS(int n, int r, int c) {
		int UL = 0;
		int UR = (int) (Math.pow(2, N-2));
		int DL = (int) (Math.pow(2, N-1));
	}
}
