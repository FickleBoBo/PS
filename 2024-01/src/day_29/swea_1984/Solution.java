package day_29.SWEA_D2_1984;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();    // T : 테스트 케이스의 수

        for(int tc=1 ; tc<=T ; tc++){     // tc : 각 테스트 케이스

            int sum = 0;                  // sum : 총합(for문 안에 넣어야 다음 tc에서 초기화 됨)
            int[] nums = new int[10];     // nums : 10개의 숫자 배열
            for(int i=0 ; i<10 ; i++){    // 일단 for문으로 숫자 받기
                nums[i] = sc.nextInt();
            }

            int max = Integer.MIN_VALUE;    // 이정도면 그냥 암기
            int min = Integer.MAX_VALUE;    // 이정도면 그냥 암기2

            for(int i=0 ; i<10 ; i++){
                sum += nums[i];                       // 일단 총합을 구해주고 max, min을 빼는 식으로 구현
                max = max>nums[i] ? max : nums[i];    // 삼항 연산자로 max 구하기
                min = min<nums[i] ? min : nums[i];    // 삼항 연산자로 min 구하기
            }

            System.out.printf("#%d %.0f\n", tc, (double) (sum-max-min)/8);    // %.0f 로 반올림해서 정수 출력 가능한게 포인트~!

        }
        sc.close();
    }
}
