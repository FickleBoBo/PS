package day_05.SWEA_D3_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1 ; tc<=10 ; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] compare = br.readLine().split("");     // 비교할 짧은 문자열
			String[] original = br.readLine().split("");    // 비교될 긴 문자열
			int ans = 0;

			for(int i=0 ; i<=original.length-compare.length ; i++) {    // 쭉 순회
				int cnt = 0;
				for(int j=0 ; j<compare.length ; j++) {
					if(!(original[i+j].equals(compare[j]))) {
						break;
					} else {
						cnt++;
					}
				}
				if(cnt == compare.length) {    // 전부 다 같으면 ans 하나 올려줌
					ans++;
				}
			}
			System.out.printf("#%d %d\n", N, ans);
		}
		br.close();		
	}
}
