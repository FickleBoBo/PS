package day_22.BOJ_G2_2211_Fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class Node implements Comparable<Node>{
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		
		nodes = new ArrayList[1+N];
		for(int i=1 ; i<=N ; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for(int i=0 ; i<M ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			nodes[x].add(new Node(y, w));
			nodes[y].add(new Node(x, w));
		}
		
		List<int[]> ans = Dijkstra(1);
		
		System.out.println(ans.size());
		for(int[] arr : ans) {
			System.out.println(arr[0] + " " + arr[1]);
		}
		
		sc.close();
	}

	static int N;
	static List<Node>[] nodes;
	
	
	private static List<int[]> Dijkstra(int start) {
		List<int[]> ans = new ArrayList<>();
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[1+N];
		int[] dist = new int[1+N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		int startPos = 0;
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.v]) continue;
			
			visited[curr.v]= true;
			ans.add(new int[] {startPos, curr.v});
			startPos = curr.v;
			
			for(Node node : nodes[curr.v]) {
				if(!visited[node.v] && dist[node.v] > dist[curr.v]+node.w) {
					dist[node.v]= dist[curr.v] + node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}

		}
		
		System.out.println(Arrays.toString(dist));
		
		return ans;
	}
	
}
