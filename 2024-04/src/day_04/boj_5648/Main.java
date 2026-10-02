package day_04.BOJ_S5_5648;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[] nums = new long[N];
		
		StringBuilder sb;
		for(int i=0 ; i<N ; i++) {
			sb = new StringBuilder();
			sb.append(sc.next());
			nums[i] = Long.parseLong(sb.reverse().toString());
		}
		
		Arrays.sort(nums);
		
		for(long num : nums) {
			System.out.println(num);
		}
		
		sc.close();
		
	}
}
