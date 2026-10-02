package day_06.SWEA_D3_1217;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int tc=1 ; tc<=10 ; tc++){    // 테스트 케이스 돌리기
            sc.nextInt();                 // dummy 받아주기
            int N = sc.nextInt();         // N 입력 받기
            int M = sc.nextInt();         // M 입력 받기
            System.out.printf("#%d %d\n", tc, powerFunc(N, M));
        }

    }

    public static int powerFunc(int N, int M){    // N의 M승을 출력하는 재귀함수
        if(M == 1) return N;                      // M이 1일때 재귀 끝내야겠지?
        return powerFunc(N, M-1) * N;         // 1번 덜 제곱한만큼 N을 곱해줘야 값이 나오겠지?
    }

}