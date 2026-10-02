package day_26.BOJ_S4_18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<Integer> queue = new LinkedList<Integer>();
	
	static void push(int item) {
		queue.add(item);
	}
	
	static String pop() {
		if(queue.isEmpty()) {
			return "-1 ";
		}
		int item = queue.get(0);
		queue.remove(0);
		return item+" ";
	}
	
	static String size() {
		return queue.size()+" ";
	}
	
	static String empty() {
		if(queue.isEmpty()) {
			return "1 ";
		}
		return "0 ";
	}
	
	static String front() {
		if(queue.isEmpty()) {
			return "-1 ";
		}
		return queue.get(0)+" ";
	}
	
	static String back() {
		if(queue.isEmpty()) {
			return "-1 ";
		}
		return queue.get(queue.size()-1)+" ";
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<N ; i++) {
			sb.append(br.readLine() + " ");
		}
		
		StringTokenizer st = new StringTokenizer(sb.toString(), " ");
		
		sb = new StringBuilder();
		
		while(st.hasMoreTokens()) {
			
			String str = st.nextToken();
			
			if(str.equals("push")) {
				push(Integer.parseInt(st.nextToken()));
			}
			else if(str.equals("pop")) {
				sb.append(pop() + "\n");
			}
			else if(str.equals("size")) {
				sb.append(size() + "\n");
			}
			else if(str.equals("empty")) {
				sb.append(empty() + "\n");
			}
			else if(str.equals("front")) {
				sb.append(front() + "\n");
			}
			else {
				sb.append(back() + "\n");
			}
			
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}
