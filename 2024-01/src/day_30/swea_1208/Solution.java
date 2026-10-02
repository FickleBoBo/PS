package day_30.SWEA_D3_1208;

import java.util.Scanner;

public class Solution{
	
	static int[] arr = new int[100];    // 그냥 남들도 하길래 static 변수로 만들어 봄
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1 ; tc<=10 ; tc++) {    // tc : 각 테스트 케이스
			
			int N = sc.nextInt();          // N : 덤프 횟수
			for(int i=0 ; i<100 ; i++) {
				arr[i] = sc.nextInt();
			}
			arr = countingSort(arr);       // 상자의 개수와 높이가 정수로 깔끔해서 Counting Sort 시도 후 대입
			
			int left = 0;                  // 왼쪽 피봇
			int right = 100;               // 오른쪽 피봇
			while(N > 0) {                 // 덤프 횟수만큼 반복
				
				while(arr[left]==0) {      // 가장 작은 숫자를 찾는다(가장 낮은 곳을 찾는다)
					left++;
				}
				while(arr[right]==0) {     // 가장 큰 숫자를 찾는다(가장 높은 곳을 찾는다)
					right--;
				}
				
				arr[left] -= 1;       // 가장 낮은 곳을 채워 준다와 같은 의미
				arr[left+1] += 1;     // 가장 낮은 곳을 채워 준다와 같은 의미
				arr[right] -= 1;      // 가장 높은 곳을 깎는다와 같은 의미
				arr[right-1] += 1;    // 가장 높은 곳을 깎는다와 같은 의미
				N--;
			}
			
			int height = right - left;      // 가장 큰 수와 가장 작은 수의 차가 높이겠지?
			if (arr[left] == 0) {           // 근데 while문 구조상 최신화를 한 번 해줘야함(이거 안하면 답 안나옴)
				height -= 1;
			} else if(arr[right] == 0) {    // 오른쪽도 꼼꼼하게 해주자
				height -= 1;
			}
			
			System.out.printf("#%d %d\n", tc, height);
		}
		sc.close();
	}
	
	public static int[] countingSort(int[] arr) {    // 수업때 배운 Counting Sort 활용(prefix 없이 가능)
		
		int[] count = new int[101];
		for(int i=0 ; i<100 ; i++) {
			count[arr[i]]++;
		}
		return count;
	}
	
}