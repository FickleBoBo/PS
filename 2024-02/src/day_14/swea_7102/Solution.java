package day_14.SWEA_D3_7102;

import java.util.Scanner;

public class Solution {
	
	static int[] tree;    // 배열로 만들 트리(스태틱 메서드에서 바로 쓰려고 여기 선언)
	
	static void inorder(int i, int N) {    // 중위 순회? 근데 바로 출력할게 아니라 큰 의미 없음
		if(i < 0 || i >= tree.length) {    // 인덱스 벗어나면 리턴
			return;
		}
		
		if(tree[i] == N) {        // 최댓값을 찾으면 해당 인덱스를 -1로 만들어서 일종의 표시를 함
			tree[i] = -1;
		}
		inorder(i * 2, N);        // 왼쪽 자식들
		inorder(i * 2 + 1, N);    // 오른쪽 자식들
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();             // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {    // tc : 각각의 테스트 케이스
			
			int N = sc.nextInt();      // N : 숫자 크기
			int M = sc.nextInt();      // M : 숫자 크기2
			
			tree = new int[N+M+1];     // 스태틱 변수인 트리를 여기서 할당해줌(테케마다 크기 바꾸려고)
			
			for(int i=1 ; i<=N ; i++) {
				for(int j=1 ; j<=M ; j++) {
					tree[i+j] += 1;    // 카운팅 배열처럼 더해주기(해당 인덱스 값이 빈도수가 됨)
				}
			}
			
			int max = Integer.MIN_VALUE;
			for(int i=0 ; i<N+M+1 ; i++) {    // 카운팅 배열 최댓값(==최빈값) 찾기
				max = max > tree[i] ? max : tree[i];
			}
			
			inorder(1, max);                  // 중위 순회로 root부터 동일한 값들 있는지 조사
			
			System.out.printf("#%d ", tc);
			for(int i=0 ; i<N+M+1 ; i++) {
				if(tree[i] == -1) {           // 표시해놓은 애들만 출력
					System.out.print(i + " ");
				}
			}
			System.out.println();
			
		}
		sc.close();
	}
}
