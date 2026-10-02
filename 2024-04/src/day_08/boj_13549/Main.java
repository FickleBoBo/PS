package day_08.BOJ_G5_13549;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// 입력 받아서 0-1 BFS 돌리고 리턴한 값 바로 출력
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		System.out.println(BFS(N, K));
		
		sc.close();
	}

	// 0-1 BFS
	private static int BFS(int n, int k) {
		Deque<Integer> q = new LinkedList<>();    // Deque로 만들어야 함(앞에서 삽입할거라)
		boolean[] visited = new boolean[100_001];    // 방문 체크 안하면 1%에서 시간 초과 + 배열 범위 더 크게 해야 할 것 같은데 통과됨
		q.offer(n);
		visited[n] = true;
		int ans = 0;

		while(true) {    // 어차피 pos==k를 무조건 찾을거라 true로 함
			int len = q.size();
			for(int i=0 ; i<len ; i++) {    // 거리 구하는 구조로 작성
				int pos = q.poll();
				
				if(pos==k) return ans;    // 5 -> 17 을 284번째에 찾음

				/* 아래 3개 순서 바뀌면 pass 안됨
				 * 3가지 연산 순서도 중요함(*2 +1 -1 / -1 +1 -2 순서는 통과 안됨)
				 */
				if(pos-1>=0 && !visited[pos-1]) {
					q.offer(pos-1);
					visited[pos-1] = true;
				}

				if(pos+1<=100_000 && !visited[pos+1]) {
					q.offer(pos+1);
					visited[pos+1] = true;
				}
				if(pos*2<=100_000 && !visited[pos*2]) {
					q.addFirst(pos*2);
					visited[pos*2] = true;
					i--;    // *2는 거리로 안들어가서 반복문을 한번 더 돌게 하려고 이렇게 만듦(offer 했지만 안한것처럼) + 정석은 아닐 수 있음
				}

			}
			ans++;
		}

	}
}
