package day_05.SWEA_D3_1216;

import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {

		// 그동안 왜 안된건지 모르겠다
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("day_04/src/swea_1216_회문2/input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc=1 ; tc<=10 ; tc++){
			int N = Integer.parseInt(br.readLine());
			String[][] arr = new String[100][100];
			for(int i=0 ; i<100 ; i++){
				arr[i] = br.readLine().split("");
			}

			int max = 0;
			int n = 101;
			int cnt = 0;

			while(n-- >= 1){
				for(int i=0 ; i<100 ; i++) {
					for(int j=0 ; j<=100-n ; j++) {
						cnt = 0;
						for(int k=0 ; k<n/2 ; k++) {
							if(!(arr[i][j+k].equals(arr[i][j+n-k-1]))) {
								break;
							}
							cnt++;
							if(cnt == n/2) {
								max = max > n ? max : n;
							}
						}
					}
				}
			}

			n = 101;
			while(n-- >= 1){
				for(int i=0 ; i<100 ; i++) {
					for(int j=0 ; j<=100-n ; j++) {
						cnt = 0;
						for(int k=0 ; k<n/2 ; k++) {
							if(!(arr[j+k][i].equals(arr[j+n-k-1][i]))) {
								break;
							}
							cnt++;
							if(cnt == n/2) {
								max = max > n ? max : n;
							}
						}
					}
				}
			}
			System.out.printf("#%d %d\n", N, max);
		}
		br.close();
	}
}