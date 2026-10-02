package day_01.BOJ_S1_1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<N ; i++){
            sb.append(br.readLine() + " ");
        }

        StringTokenizer st = new StringTokenizer(sb.toString(), " ");

        int[][] triangle = new int[N][N];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<=i ; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        for(int i=0 ; i<N ; i++){
//            for(int j=0 ; j<N ; j++){
//                System.out.print(triangle[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        int[][] dp = new int[N][N+1];
        dp[0][1] = triangle[0][0];
        for(int i=1 ; i<N ; i++){
            for(int j=1 ; j<=i+1 ; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j-1];
            }
        }
//        for(int i=0 ; i<N ; i++){
//            for(int j=1 ; j<=N ; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        int ans = 0;
        for(int i=1 ; i<=N ; i++){
            ans = Math.max(ans, dp[N-1][i]);
        }
        System.out.println(ans);

        br.close();
    }
}
