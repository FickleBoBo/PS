package day_01.SWEA_D6_1267;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1 ; tc<=10 ; tc++) {    // T : 각각의 테스트 케이스
			int V = sc.nextInt();    // V : 정점
			int E = sc.nextInt();    // E : 간선
			
			int[] degree = new int[1+V];    // degree : 각 정점의 진입 차수 배열
			int[][] adj = new int[1+V][1+V];    // adj : 인접 행렬
			for(int i=0 ; i<E ; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				adj[A][B]++;    // 유방향 인접 행렬 채워주고
				degree[B]++;    // 진입 차수 채워주고
			}
			
			Queue<Integer> topoSort = new LinkedList<>();    // topoSort : 위상정렬을 위한 큐
			for(int i=1 ; i<=V ; i++) {
				if(degree[i]==0) topoSort.offer(i);    // 진입 차수가 없는 애들 넣어주고
			}
			
			System.out.println("#" + tc + " ");
			while(!topoSort.isEmpty()) {
				int node = topoSort.poll();    // 하나씩 꺼내서
				System.out.print(node + " ");
				
				for(int i=1 ; i<=V ; i++) {
					if(adj[node][i] != 0) {    // 진출 차수가 있는 애 만나면
						degree[i]--;    // 진입 차수 갱신해주고
						if(degree[i]==0) {    // 진입 차수가 없어진 애는
							topoSort.offer(i);    // 위상정렬을 위한 큐에 넣어줌
						}
					}
				}
				
			}
			System.out.println();
		}
		
		sc.close();
	}
}
