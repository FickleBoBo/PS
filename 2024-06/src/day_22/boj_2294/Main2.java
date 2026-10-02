package day_22.BOJ_G5_2294;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1D {

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 동전의 가치를 저장하는 배열
        int[] coins = new int[1+N];
        for(int i=0 ; i<N ; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 0 ~ i번째 동전으로 j의 가치를 만들 수 있는 동전 수의 최소값을 저장하는 1차원 dp 테이블
        int[] dp = new int[1+K];
        for(int i=1 ; i<=K ; i++){
            dp[i] = INF;    // 최댓값으로 초기화하는데 패딩 부분을 제외해야 동전 1개를 사용한 순간부터 갱신이 됨
        }

        // 0 ~ i번째 동전까지 사용할 수 있을 때
        for(int i=0 ; i<N ; i++){

            // 1 ~ M 원까지를 만들 수 있을 때
            for (int j=coins[i] ; j<=K ; j++){

                // 기존의 i-1 번째 동전으로 만들 수 있었던 최소값에서 새롭게 추가된 개수를 비교해야함
                dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
            }
        }

        // 불가능한 경우에는 INF가 저장되어 있음
        System.out.println(dp[K]==INF ? -1 : dp[K]);
    }
}
