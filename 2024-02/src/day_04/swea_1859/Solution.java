package day_04.SWEA_D2_1859;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            int N = sc.nextInt();
            int[] nums = new int[N];
            for(int i=0 ; i<N ; i++){
                nums[i] = sc.nextInt();
            }
            int startIdx = 0;    // 시작 인덱스
            long ans = 0;        // 출력할 정답(long형으로 선언해야함)

            while(true) {           // 다 찾을 때까지 반복
                int max = 0;        // 판매해야되는 최댓값(자연수만 있어서 0으로 초기화)
                int maxIdx = -1;    // 최댓값일 때 인덱스 저장(인덱스는 음이 아닌 정수여서 -1로 초기화)

                for(int i=startIdx ; i<N ; i++){    // 새로운 구간마다 최댓값과 그 인덱스를 찾음
                    if(nums[i] >= max){
                        max = nums[i];
                        maxIdx = i;
                    }
                }

                for(int i=startIdx ; i<maxIdx ; i++){    // 최댓값까지 더하기
                    ans += max-nums[i];
                }

                if(maxIdx == N-1){    // 종료 조건
                    break;
                }

                startIdx = maxIdx + 1;    // 구간 갱신

            }

            System.out.printf("#%d %d\n", tc, ans);

        }

        sc.close();

    }
}
