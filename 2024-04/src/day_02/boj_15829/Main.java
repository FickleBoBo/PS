package day_02.BOJ_B2_15829;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		char[] input = sc.next().toCharArray();
		long[] hash = new long[L];
		hash[0] = 1;
		for(int i=1 ; i<L ; i++) {
			hash[i] = hash[i-1] * 31 % 1234567891;
		}
		
		long ans = 0;
		for(int i=0 ; i<L ; i++) {
			ans = (long) (ans % 1234567891 + ((input[i]-'a'+1) * hash[i] % 1234567891) % 1234567891);
//			System.out.printf("%2d %,15d\n", i+1, ans);
		}
		
		System.out.println(ans % 1234567891);
		
		sc.close();
	}
}
