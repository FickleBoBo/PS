package day_13.BOJ_S1_2527;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 4; tc++) {

			int[] nemo1 = new int[4];
			int[] nemo2 = new int[4];
			for (int i = 0; i < 4; i++) {
				nemo1[i] = sc.nextInt();
			}
			for (int i = 0; i < 4; i++) {
				nemo2[i] = sc.nextInt();
			}

			if (((nemo1[0] > nemo2[2]) || (nemo1[2] < nemo2[0])) 
				|| ((nemo1[1] > nemo2[3]) || (nemo1[3] < nemo2[1]))) {
				System.out.println("d");
			} 
			else if (((nemo1[0] == nemo2[2]) && (nemo1[1] == nemo2[3]))
				|| ((nemo1[2] == nemo2[0]) && (nemo1[1] == nemo2[3]))
				|| ((nemo1[0] == nemo2[2]) && (nemo1[3] == nemo2[1]))
				|| ((nemo1[2] == nemo2[0]) && (nemo1[3] == nemo2[1]))) {
				System.out.println("c");
			} 
			else if (((nemo1[0] == nemo2[2]) || (nemo1[1] == nemo2[3]))
				|| ((nemo1[2] == nemo2[0]) || ((nemo1[3] == nemo2[1])))) {
				System.out.println("b");
			} 
			else {
				System.out.println("a");
			}
		}
		sc.close();
	}
}
