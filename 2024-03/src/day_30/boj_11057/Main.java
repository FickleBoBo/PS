package day_30.BOJ_S1_11057;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dp = new int[1+N+1][10+1];    // dp 테이블 만드는데 앞에 1은 N=0 패딩으로 남기고, 뒤에 패딩은 정답 출력용

        Arrays.fill(dp[1], 0, 10, 1);    // dp 테이블 N=1(한자리 수)일 때 초기 세팅
        for(int i=2 ; i<=N+1 ; i++){
            for(int j=9 ; j>=0 ; j--){
                dp[i][j] = (dp[i-1][j] + dp[i][j+1])%10007;    // 누적합 돌리는데 바로바로 나눠줘야 함(아마 모듈러 연산은 아무렇게 해도 똑같아서 그런듯)
            }
        }
        
        System.out.println(dp[N+1][0]);

        sc.close();
    }
}
