package day_16.BOJ_G3_1238;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class Edge implements Comparable<Edge>{
		int st, ed, w;

		public Edge(int st, int ed, int w) {this.st = st; this.ed = ed; this.w = w;}

		@Override
		public int compareTo(Edge o) {return Integer.compare(this.w, o.w);}
	}

	static int N;
	static List<Edge>[] edges;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int X = sc.nextInt();
		
		edges = new ArrayList[1+N];
		for(int i=1 ; i<=N ; i++) {
			edges[i] = new ArrayList<Edge>();
		}
		for(int i=0 ; i<M ; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();
			edges[st].add(new Edge(st, ed, w));
		}
		
		/* 학생 마을 -> X 마을 -> 학생 마을로 가는 걸 구하는 문제로 유방향 그래프라서 다익스트라로 해결(무조건 연결 + 간선 양수)
		 * X 마을 -> 학생 마을은 한번만 구해서 사용해도 되는데 학생 마을 -> X 마을은 매번 구해야 됨(다익은 시작점 기준이라)
		 */
		int ans = 0;
		int[] XToHome = Dijkstra(X);
		for(int i=1 ; i<=N ; i++) {
			ans = Math.max(ans, Dijkstra(i)[X] + XToHome[i]);    // 다익에서는 최솟값을 찾아야하지만 출력 정답은 최솟값 중 최댓값을 찾아야 함
		}
		
		System.out.println(ans);
		sc.close();
	}

	private static int[] Dijkstra(int start) {
		boolean[] visited = new boolean[1+N];
		
		int[] dist = new int[1+N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();    // 유튜브 보니까 다익은 그냥 우선순위 큐로 하는게 좋아 보임(노드 많아지면 느리다고 함)
		for(Edge e : edges[start]) {
			dist[e.ed] = dist[e.st] + e.w;
			pq.add(e);
		}
		
		while(!pq.isEmpty()) {
            Edge curr = pq.poll();
            visited[curr.st] = true;
	            
            for (Edge e : edges[curr.ed]) {
	                
                if(visited[e.ed]) continue;
	            
                if(dist[e.ed] > dist[e.st] + e.w) {
                    dist[e.ed] = dist[e.st] + e.w;
                    pq.add(new Edge(e.st, e.ed, dist[e.ed]));    // 프림이랑 구현 비슷해보이지만 다름
                }
            }
        }
		
		return dist;
		
	}
	
}
