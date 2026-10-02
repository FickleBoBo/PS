package day_16.SWEA_D3_1493;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			int p = sc.nextInt();
			int q = sc.nextInt();
			int n1 = 1;
			int Sn1 = 1;
			int n2 = 1;
			int Sn2 = 1;
			
			while(Sn1 < p) {
				n1++;
				Sn1 = (n1 * (n1 + 1)) / 2;
			}
			while(Sn2 < q) {
				n2++;
				Sn2 = (n2 * (n2 + 1)) / 2;
			}
			
			int x1 = n1 - (Sn1 - p);
			int y1 = 1 + (Sn1 - p);
			int x2 = n2 - (Sn2 - q);
			int y2 = 1 + (Sn2 - q);
			
			int x = x1 + x2;
			int y = y1 + y2;
			int n = x + y - 1;
			int Sn = (n * (n + 1)) / 2;
			
			int ans = Sn - n + x;
			
			System.out.printf("#%d %d\n", tc, ans);
		}
		sc.close();
	}
}
