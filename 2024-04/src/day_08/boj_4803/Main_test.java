package day_08.BOJ_G4_4803;

import java.util.Arrays;
import java.util.Scanner;

public class Main_test {

	static int[] p;
	static int[] p1;
	static int[] p2;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input);

		while(true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			if(n==0 && m==0) break;

			p = new int[1+n];
			for(int i=1 ; i<=n ; i++) {
				p[i] = i;
			}
			p1 = new int[1+n];
			for(int i=1 ; i<=n ; i++) {
				p1[i] = i;
			}
			p2 = new int[1+n];
			for(int i=1 ; i<=n ; i++) {
				p2[i] = i;
			}
			
			for(int i=0 ; i<m ; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				int x = find(a);
				int y = find(b);
				union(x, y);

				int x1 = find_return_x(a);
				int y1 = find_return_x(b);
				union1(x1, y1);
				
				int x2 = find_return_px(a);
				int y2 = find_return_px(b);
				union2(x2, y2);
			}

			// [0, 1, 1, 1, 1, 5, 6]
			// [0, 1, 1, 1, 1, 1, 1]
			// [0, 1, 1, 1, 4, 4, 4]
			System.out.println("처음했던거 : " + Arrays.toString(p));

			// [0, 1, 1, 2, 3, 5, 6]
			// [0, 1, 1, 2, 3, 4, 5]
			// [0, 1, 1, 1, 6, 4, 5]
			System.out.println("x 반환 : " + Arrays.toString(p1));
			
			// [0, 1, 1, 1, 1, 5, 6]
			// [0, 1, 1, 1, 1, 1, 1]
			// [0, 1, 1, 1, 4, 4, 4]
			System.out.println("p[x] 반환 : " + Arrays.toString(p2));
		}

		sc.close();
	}

	private static int find(int x) {
		if(p[x] == x) {
			return x;
		}
		return find(p[x]);
	}

	private static int find_return_x(int x) {
		if(p1[x] != x) {
			p1[x] = find_return_x(p1[x]);
		}
		return x;
	}
	
	private static int find_return_px(int x) {
		if(p2[x] != x) {
			p2[x] = find_return_px(p2[x]);
		}
		return p2[x];
	}

	private static void union(int x, int y) {
		p[y] = x;
	}

	private static void union1(int x, int y) {
		p1[y] = x;
	}
	
	private static void union2(int x, int y) {
		p2[y] = x;
	}
	
	
	
	static String input = "6 3\r\n"
			+ "1 2\r\n"
			+ "2 3\r\n"
			+ "3 4\r\n"
			+ "6 5\r\n"
			+ "1 2\r\n"
			+ "2 3\r\n"
			+ "3 4\r\n"
			+ "4 5\r\n"
			+ "5 6\r\n"
			+ "6 6\r\n"
			+ "1 2\r\n"
			+ "2 3\r\n"
			+ "1 3\r\n"
			+ "4 5\r\n"
			+ "5 6\r\n"
			+ "6 4\r\n"
			+ "0 0";
	
}
