package day_18.BOJ_G4_1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge implements Comparable<Edge>{
		int x, y, w;

		Edge(int x, int y, int w) { this.x = x; this.y = y; this.w = w; }

		@Override
		public int compareTo(Edge o) { return Integer.compare(this.w, o.w); }
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<M ; i++) {
			sb.append(br.readLine());
			sb.append(" ");
		}
		StringTokenizer st = new StringTokenizer(sb.toString(), " ");
		
		Edge[] edges = new Edge[M];
		for(int i=0 ; i<M ; i++) {
			edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(edges);
		
		p = new int[1+N];
		for(int i=1 ; i<=N ; i++) {
			p[i] = i;
		}
		
		int ans = 0;
		int cnt = 0;
		for(int i=0 ; i<M ; i++) {
			if(cnt == N-2) break;
			
			int x = find(edges[i].x);
			int y = find(edges[i].y);
			if(x != y) {
				union(x, y);
				ans += edges[i].w;
				cnt++;
			}
		}
		
		System.out.println(ans);
		br.close();
	}
	
	static int[] p;
	
	private static int find(int x) {
		if(x != p[x]) p[x] = find(p[x]);
		return p[x];
	}
	
	private static void union(int x, int y) {
		p[y] = x;
	}
	
//	private static int cntSet() {
//		int cnt = 0;
//		for(int i=1 ; i<p.length ; i++) {
//			if(p[i] == i) cnt++;
//		}
//		return cnt;
//	}
	
}
