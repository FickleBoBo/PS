package day_04.BOJ_S4_11652;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[] nums = new long[N];
		
		HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
		
		for(int i=0 ; i<N ; i++) {
			long input = sc.nextLong();
			
			hm.put(input, hm.getOrDefault(input, 0)+1);
			nums[i] = input;
		}
		
		Arrays.sort(nums);
		
		long ans = 0;
		int cnt = 0;
		for(int i=N-1 ; i>=0 ; i--) {
			if(hm.get(nums[i]) >= cnt) {
				ans = nums[i];
				cnt = hm.get(nums[i]);
			}
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}
