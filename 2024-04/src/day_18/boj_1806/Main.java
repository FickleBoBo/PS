package day_18.BOJ_G4_1806;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // step1 - 입력이 두 줄 고정이라 BufferedReader, StringBuilder, StringTokenizer로 받았는데 Scanner도 무난히 통과(224ms -> 676ms)
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0 ; i<N ; i++){
            nums[i] = sc.nextInt();
        }

        // step2 = 투 포인터 알고리즘 적용
        // 부분 수열은 시작 인덱스와 끝 인덱스를 포함한다고 생각
        int ans = Integer.MAX_VALUE;    // 최솟값을 찾을 때는 최댓값으로 초기화
        int start = 0;                  // 부분 수열의 시작 인덱스
        int end = 0;                    // 부분 수열의 끝 인덱스
        int sum = nums[0];              // 부분 수열의 합

        while(true){
            if(sum < S){                 // 부분 수열의 합이 S보다 작으면
                sum += nums[++end];      // 부분 수열의 끝 인덱스를 갱신하면서 부분합 갱신(큐 구현의 enQueue와 비슷)
            }
            if(sum >= S){                            // 부분 수열의 합이 S보다 크거나 같으면 계산 들어감
                ans = Math.min(ans, end-start+1);    // 지금까지 찾은 최소 길이(길이라 +1 해줘야 함)와 현재 부분 수열의 길이를 비교
                sum -= nums[start++];                // 부분합을 갱신하고 부분 수열의 시작 인덱스를 갱신(큐 구현의 deQueue와 비슷)
            }

            // 종료 조건이 중요한데 부분 수열의 끝 인덱스가 배열의 끝에 도착했으면서 부분합이 S보다 작으면 종료해야함
            // 부분 수열의 끝 인덱스가 배열의 끝에 있어도 부분합이 S보다 크면 시작 인덱스를 키워서 더 짧은 부분 수열을 만들 수 있음
            if(end == N-1 && sum < S) break;
        }

        if(ans == Integer.MAX_VALUE) System.out.println(0);    // ans를 한번도 갱신 못했으면 만족하는 부분합을 못 찾은거
        else System.out.println(ans);

        sc.close();
    }
}
