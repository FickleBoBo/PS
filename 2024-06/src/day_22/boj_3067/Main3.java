package day_22.BOJ_G5_3067;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2D_optimization {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(br.readLine());

            // 동전의 가치를 저장하는 배열로 계산 편의를 위해 패딩을 해주고 오름차순으로 주어지는 동전을 역순으로 넣음
            int[] coins = new int[1+N];
            for(int i=N ; i>0 ; i--){
                coins[i] = Integer.parseInt(st.nextToken());
            }

            // 1 ~ i번째 동전으로 j의 가치를 만들 수 있는 경우의 수를 저장하는 2차원 dp 테이블
            int[][] dp = new int[1+N][1+M];

            // 1 ~ i번째 동전까지 사용할 수 있을 때
            for(int i=1 ; i<=N ; i++){
                dp[i][0] = 1;    // 여길 1로 초기화하면 coins[i]원을 만들 수 있는 경우부터 1가지가 됨

                // coins[i] ~ j 원까지를 만들 수 있을 때
                for (int j=coins[i]; j<=M; j++){

                    // 동전의 가치를 오름차순으로 하면 다음 동전을 담을 수 없을 때, 이전 동전의 경우의 수를 그대로 넣어줘여 했다
                    // 근데 내림차순으로 하면 해당 동전의 시작점에서 이전 동전으로는 항상 만들 수 없어서 조건문을 없앨 수 있음
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                }
            }

            System.out.println(dp[N][M]);
        }

    }
}
