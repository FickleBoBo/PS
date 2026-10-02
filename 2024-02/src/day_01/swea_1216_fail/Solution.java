package day_01.SWEA_D3_1216_Fail;

import java.util.Scanner;

public class Solution{

	static int maxLen;
	static int size = 8;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for(int tc=1 ; tc<=1 ; tc++) {

			int N = Integer.parseInt(sc.next());
			String[][] arr = new String[size][size];
			for(int i=0 ; i<size ; i++) {
				arr[i] = sc.next().split("");
			}
			maxLen = 1;
			for(int startInx=0 ; startInx<size-1 ; startInx++) {
				for(int endInx=startInx+1 ; endInx<size ; endInx++) {
					findPalindrome(arr, startInx, endInx);
				}
			}



			System.out.printf("#%d %d\n", N, maxLen);

		}
		sc.close();
	}

	public static void findPalindrome(String[][] arr, int startInx, int endInx) {

		int i = -1;
		while(i++<size) {
			int front = startInx;
			int back = endInx;
			while(front < back) {
				if(!(arr[i][front].equals(arr[i][back]))) {
					i++;
					break;
				}
				front++;
				back--;
			}
			maxLen = maxLen > endInx - startInx + 1 ? maxLen : endInx - startInx + 1;
			System.out.println("행" + i + " : " + maxLen + " startInx " + startInx + " endInx " + endInx);
		}

		int j = -1;
		out: while(j++<size) {
			int front = startInx;
			int back = endInx;
			while(front < back) {
				if(!(arr[front][j].equals(arr[back][j]))) {
					j++;
					break out;
				}
				front++;
				back--;
			}
			maxLen = maxLen > endInx - startInx + 1 ? maxLen : endInx - startInx + 1;
			System.out.println("열" + j + " : " + maxLen + " startInx " + startInx + " endInx " + endInx);
		}

	}

}