package day_27.BOJ_S2_2477;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		
		int[] round = new int[6];
		for(int i=0 ; i<6 ; i++) {
			sc.nextInt();
			round[i] = sc.nextInt();
		}
		
		int maxLength = Integer.MIN_VALUE;
		int maxLengthIdx = -1;
		for(int i=0 ; i<6 ; i++) {
			if(round[i] > maxLength) {
				maxLength = round[i];
				maxLengthIdx = i;
			}
		}
		
		int maxLength2;
		int area;
		if(round[(maxLengthIdx-1+6)%6] > round[(maxLengthIdx+1+6)%6]) {
			maxLength2 = round[(maxLengthIdx-1+6)%6];
			area = maxLength * maxLength2 - (round[(maxLengthIdx+2+6)%6] * round[(maxLengthIdx+3+6)%6]);
		}
		else {
			maxLength2 = round[(maxLengthIdx+1+6)%6];
			area = maxLength * maxLength2 - (round[(maxLengthIdx-2+6)%6] * round[(maxLengthIdx-3+6)%6]);
		}
		
		System.out.println(area * K);
		
		
		sc.close();
	}
}
