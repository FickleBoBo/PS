package day_09.BOJ_S2_1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int cnt1 = 0;
	static int cnt2 = 0;
	static int cnt3 = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<N ; i++) {
			sb.append(br.readLine() + " ");
		}
		
		StringTokenizer st = new StringTokenizer(sb.toString(), " ");
		
		map = new int[N][N];
		for(int i=0 ; i<N; i++) {
			for(int j=0 ; j<N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recur(N, 0, 0, N, N);
		
		System.out.println(cnt1);
		System.out.println(cnt2);
		System.out.println(cnt3);
		
		br.close();
	}

	private static void recur(int n, int sr, int sc, int er, int ec) {
		
		if(checkArr(sr, sc, er, ec)) {
			
//			System.out.printf("%d %d %d %d   %d\n", sr, sc, er, ec, map[sr][sc]);
			
			if(map[sr][sc]==-1) cnt1++;
			else if(map[sr][sc]==0) cnt2++;
			else if(map[sr][sc]==1) cnt3++;
		}
		else {
			recur(n/3, sr,       sc,       er-n/3*2, ec-n/3*2);
			recur(n/3, sr,       sc+n/3,   er-n/3*2, ec-n/3);
			recur(n/3, sr,       sc+n/3*2, er-n/3*2, ec);
			recur(n/3, sr+n/3,   sc,       er-n/3,   ec-n/3*2);
			recur(n/3, sr+n/3,   sc+n/3,   er-n/3,   ec-n/3);
			recur(n/3, sr+n/3,   sc+n/3*2, er-n/3,   ec);
			recur(n/3, sr+n/3*2, sc,       er,       ec-n/3*2);
			recur(n/3, sr+n/3*2, sc+n/3,   er,       ec-n/3);
			recur(n/3, sr+n/3*2, sc+n/3*2, er,       ec);
		}
		
	}
	
	private static boolean checkArr(int sr, int sc, int er, int ec) {
		int standard = map[sr][sc];
		for(int i=sr ; i<er ; i++) {
			for(int j=sc ; j<ec ; j++) {
				if(map[i][j] != standard) return false;
			}
		}
		return true;
	}
	
}
