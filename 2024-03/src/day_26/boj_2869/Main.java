package day_26.BOJ_B1_2869;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		
		int ans = (V-A) / (A-B) + 1;
		if((V-A) % (A-B) != 0) ans++;
		System.out.println(ans);
		
	}
}
