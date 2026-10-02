package day_02.BOJ_S2_1406_Fail;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split("");		
		int M = Integer.parseInt(br.readLine());
		
		List<String> editor = new LinkedList<>(Arrays.asList(input));
		int cursor = editor.size();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<M ; i++) {
			sb.append(br.readLine() + " ");
		}
		StringTokenizer st = new StringTokenizer(sb.toString(), " ");
		
		while(st.hasMoreTokens()) {
			String command = st.nextToken();
			
			if(command.equals("P")){
				editor.add(cursor++, st.nextToken());
			}
			else {
				if(command.equals("L") && cursor != 0) {
//					cursor = Math.max(cursor-1, 0);
					cursor--;
				}
				else if(command.equals("D") && cursor != editor.size()) {
//					cursor = Math.min(cursor+1, editor.size());
					cursor++;
				}
				else if(command.equals("B") && cursor >= 1) {
					editor.remove(--cursor);
				}
			}
		}

		for(String s : editor) {
			bw.write(s);
		}
		
		bw.close();
		br.close();
		
	}
}
