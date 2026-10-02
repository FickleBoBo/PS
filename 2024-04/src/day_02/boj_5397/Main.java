package day_02.BOJ_S2_5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			char[] input = br.readLine().toCharArray();
			List<Character> password = new LinkedList<>();
			int cursor = 0;
			
			for(char c : input) {
				if(c=='<') {
					cursor = Math.max(cursor-1, 0);
				}
				else if(c=='>') {
					cursor = Math.min(cursor+1, password.size());
				}
				else if(c=='-') {
					if(cursor>=1) {
						password.remove(--cursor);
					}
				}
				else {
					password.add(cursor++, c);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(char c : password) {
				sb.append(c);
			}
			System.out.println(sb.toString());
		}
		
		br.close();
		
	}
}
