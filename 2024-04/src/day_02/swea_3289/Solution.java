package day_02.SWEA_D4_3289;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	
	static int[] p;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1 ; tc<=T ; tc++) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			
			p = new int[1+n];
			for(int i=1 ; i<=n ; i++) {
				p[i] = i;
			}
			
			StringBuilder sb = new StringBuilder("#"+tc+" ");
			for(int i=0 ; i<m ; i++) {
				String[] order = br.readLine().split(" ");
				int x = find(Integer.parseInt(order[1]));
				int y = find(Integer.parseInt(order[2]));
				
				if(order[0].equals("0")) {
					union(x, y);
				}
				else {
					if(x==y) sb.append(1);
					else sb.append(0);
				}
				
			}
			sb.append("\n");
			bw.write(sb.toString());
			bw.flush();
		}
		bw.close();
		br.close();
	}
	
	private static int find(int x) {
		if (x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
	
	private static void union(int x, int y) {
		p[y] = x;
	}
	
}
