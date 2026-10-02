package day_15.SWEA_D3_7272;

import java.util.Scanner;

public class Solution {

	// holeList : 구멍의 갯수를 미리 int 배열로 계산해 놓음
	static int[] holeList = { 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();                         // T : 테스트 케이스의 수

		for (int tc = 1; tc <= T; tc++) {             // tc : 각각의 테스트 케이스
			boolean isOK = true;                      // isOK : 일단 같다고 놓고 반례가 나오면 바로 나가리시킴
			char[] str1 = sc.next().toCharArray();    // str1 : 앞쪽 문자열 char 배열로 받음
			char[] str2 = sc.next().toCharArray();    // str2 : 뒷쪽 문자열 char 배열로 받음

			if (str1.length != str2.length) {         // 길이가 다르면 바로 끝
				isOK = false;
			} else {                                  // 길이가 같으면 일일이 비교
				for (int i = 0; i < str1.length; i++) {
					if (holeList[str1[i]-'A'] != holeList[str2[i]-'A']) {    // 여기가 포인트인데 char 뺄셈으로 holeList의 인덱스로 바로 받음
						isOK = false;
						break;
					}
				}
			}
			
			if (isOK) System.out.printf("#%d SAME\n", tc);
			else      System.out.printf("#%d DIFF\n", tc);
			
		}
		sc.close();
	}
}
