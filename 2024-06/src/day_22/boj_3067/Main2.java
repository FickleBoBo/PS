package day_22.BOJ_G5_3067;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(br.readLine());

            // 동전의 가치를 저장하는 배열
            int[] coins = new int[N];
            for(int i=0 ; i<N ; i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }

            // 0 ~ i번째 동전으로 j의 가치를 만들 수 있는 경우의 수를 저장하는 1차원 dp 테이블
            int[] dp = new int[1+M];
            dp[0] = 1;    // 여길 1로 초기화하면 coins[i]원을 만들 수 있는 경우부터 1가지가 됨

            // 0 ~ i번째 동전까지 사용할 수 있을 때
            for(int i=0 ; i<N ; i++){

                // 1 ~ M 원까지를 만들 수 있을 때
                for (int j=coins[i] ; j<=M ; j++){

                    // 기존의 i-1 번째 동전으로 만들 수 있었던 경우의 수에서 새롭게 추가된 경우의 수를 더해줘야 됨
                    // 역방향으로 순회해서 찾을 경우 업데이트된 새로운 값을 반영하지 못함( 무한 배낭 문제 )
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }

            System.out.println(dp[M]);
        }

    }
}
