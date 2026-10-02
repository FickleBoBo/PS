package day_22.BOJ_G5_2294;

import java.io.*;
import java.util.*;

public class Main_2D {

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 동전의 가치를 저장하는 배열로 계산 편의를 위해 패딩을 해줌
        int[] coins = new int[1+N];
        for(int i=1 ; i<=N ; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 1 ~ i번째 동전으로 j의 가치를 만들 수 있는 동전 수의 최소값을 저장하는 2차원 dp 테이블
        int[][] dp = new int[1+N][1+K];
        Arrays.fill(dp[0], INF);    // 패딩 부분을 예상 가능한 개수의 최댓값보다 크게 초기화

        // 1 ~ i번째 동전까지 사용할 수 있을 때
        for(int i=1 ; i<=N ; i++){

            // 1 ~ j 원까지를 만들 수 있을 때
            for (int j=1 ; j<=K; j++){

                // 동전의 가치가 j 원보다 크면 해당 동전은 선택할 수 없음
                if(j < coins[i]){
                    dp[i][j] = dp[i-1][j];
                }
                // 해당 동전을 선택하지 않는 경우의 수와 해당 동전을 선택하는 경우의 수의 최소값
                // 선택하지 않는 경우는 바로 윗 행에서 구했고,
                // 선택하는 경우는 같은 행에서 동전 가치만큼을 빼준 경우 + 1 과 같다
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i]] + 1);
                }
            }
        }

        // 불가능한 경우에는 INF가 저장되어 있음
        System.out.println(dp[N][K]==INF ? -1 : dp[N][K]);
    }
}
