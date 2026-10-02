package day_05.BOJ_S4_2960;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		boolean[] deleted = new boolean[1+N];
		
		out:
		for(int i=2 ; i<=N ; i++) {
			for(int j=1 ; j<=N ; j++) {
				if(i*j<=N && !deleted[i*j]) {
					deleted[i*j] = true;
					K--;
					if(K == 0) {
						System.out.println(i*j);
						break out;
					}
				}
			}
		}
		
		sc.close();
	}
}
