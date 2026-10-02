package day_29.SWEA_D1_2068;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();    // T : 테스트 케이스의 수

        for(int tc=1 ; tc<=T ; tc++){          // tc : 각 테스트 케이스마다 수행
            int max = Integer.MIN_VALUE;       // max에 int형 최솟값을 넣고 변경하는 식으로 계산
            for(int i=0 ; i<10 ; i++){
                int num = sc.nextInt();
                max = max>num ? max : num;     // 삼항 연산자 활용
            }
            System.out.printf("#%d %d\n", tc, max);
        }
        sc.close();
    }
}