package day_05.SWEA_D2_1989;

import java.util.Scanner;

public class Solution{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());    // 이렇게 받아야 개행 문자가 다음 sc.nextLine()에 안들어감
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			String[] text = sc.nextLine().split("");
			int flag = 1;    // 회문이라 가정
			
			for(int i=0 ; i<text.length/2 ; i++) {
				if(!(text[i].equals(text[text.length-1-i]))) {
					flag = 0;    // 회문이 아닌 순간 0으로 바꾸기
					break;
				}
			}
			
			System.out.printf("#%d %d\n", tc, flag);
			
		}
		sc.close();
	}
}