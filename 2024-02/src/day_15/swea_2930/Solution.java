package day_15.SWEA_D3_2930;

import java.util.Scanner;

public class Solution {

	static int[] heap;    // max 힙으로 구현 예정
	static int heapSize;

	static void heapPush(int x) {    // 힙에다 x 받아서 넣은 메소드
		heap[++heapSize] = x;

		int ch = heapSize;
		int p = ch / 2;

		while (p > 0 && heap[p] < heap[ch]) {
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;

			ch = p;
			p = ch / 2;
		}
	}

	static int heapPop() {      // 힙에서 루트값을 리턴하는 메소드
		if (heapSize == 0) {    // 힙이 비었으면 -1 리턴하고 종료해야 함
			return -1;
		}

		int root = heap[1];
		heap[1] = heap[heapSize--];

		int p = 1;
		int ch = p * 2;

		// 왼쪽 자식이나 오른쪽 자식이 존재하며 부모보다 클 경우 바꿔야 함
		while ((ch <= heapSize && heap[p] < heap[ch]) || (ch + 1 <= heapSize && heap[p] < heap[ch + 1])) {
			if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {    // 오른쪽 자식이 왼쪽 자식보다 클 경우
				ch++;
			}
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;

			p = ch;
			ch = p * 2;
		}
		return root;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();                // T : 테스트 케이스의 수

		for (int tc = 1; tc <= T; tc++) {    // tc : 각각의 테스트 케이스
			int N = sc.nextInt();            // N : 명령문의 수
			heap = new int[100_000];         // 스태틱 변수 할당(테스트 케이스마다 새로 만들어야 함)
			heapSize = 0;                    // 스태틱 변수 할당(테스트 케이스마다 새로 만들어야 함)
			System.out.printf("#%d ", tc);

			for (int i = 0; i < N; i++) {
				int task = sc.nextInt();     // task : 1인지 2인지 확인

				if (task == 1) {             // 1이면 힙에다 푸시
					heapPush(sc.nextInt());
				}
				else {                       // 2면 힙에서 팝
					System.out.print(heapPop() + " ");
				}
			}
			System.out.println();            // 양식 맞추기 위한 개행
		}
		sc.close();
	}
}
