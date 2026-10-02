package day_16.SWEA_D3_7087;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	// 0부터 몇 번째 숫자(=알파벳)까지 연속인가 찾는 메서드
	static int calSeries(int[] arr) {
		int ans = 0;          // ans : 리턴할 값
		if(arr[0] > ans) {    // A부터 시작하지 않으면 바로 0 리턴
			return ans;
		}
		
		for(int i=1 ; i<arr.length ; i++) {    // 본격적으로 찾기
			if(arr[i]==ans) {                  // 연속된 숫자는 건너뜀
				continue;
			}
			else if(arr[i]==ans+1) {           // 다음 숫자(=알파벳)가 나오면 하나 키워줌
				ans++;
			}
			else {                             // 엉뚱한 애 오면 바로 브렠
				break;
			}
		}
		return ans+1;                          // 도착점도 포함해야 하므로 +1 해서 리턴
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();             // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {    // tc : 각각의 테스트 케이스
			int N = sc.nextInt();         // N : 문제 제목의 길이
			int[] head = new int[N];      // head : 제목 첫 글자 알파벳의 인덱스? 저장
			for(int i=0 ; i<N ; i++) {
				head[i] = sc.next().toCharArray()[0]-'A';    // char 뺄셈으로 A를 0으로 쭉 넘버링
			}
			
			Arrays.sort(head);            // 오름차순 정렬해줌
			int ans = calSeries(head);    // 몇 번까지 연속인가 메서드로 구현
			
			System.out.printf("#%d %d\n", tc, ans);
		}
		sc.close();
	}
}
