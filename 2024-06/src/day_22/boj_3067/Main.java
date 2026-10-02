package day_22.BOJ_G5_3067;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(br.readLine());

            // 동전의 가치를 저장하는 배열로 계산 편의를 위해 패딩을 해줌
            int[] coins = new int[1+N];
            for(int i=1 ; i<=N ; i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }

            // 1 ~ i번째 동전으로 j의 가치를 만들 수 있는 경우의 수를 저장하는 2차원 dp 테이블
            int[][] dp = new int[1+N][1+M];

            // 1 ~ i번째 동전까지 사용할 수 있을 때
            for(int i=1 ; i<=N ; i++){
                dp[i][0] = 1;    // 여길 1로 초기화하면 coins[i]원을 만들 수 있는 경우부터 1가지가 됨

                // 1 ~ j 원까지를 만들 수 있을 때
                for (int j=1 ; j<=M; j++){

                    // 동전의 가치가 j 원보다 크면 해당 동전은 선택할 수 없음
                    if(j < coins[i]){
                        dp[i][j] = dp[i-1][j];
                    }
                    // 해당 동전을 선택하지 않는 경우의 수와 해당 동전을 선택하는 경우의 수의 합
                    // 선택하지 않는 경우는 바로 윗 행에서 구했고,
                    // 선택하는 경우는 같은 행에서 동전 가치만큼을 빼준 경우와 같다
                    else{
                        dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                    }
                }
            }

            System.out.println(dp[N][M]);
        }

    }
}
