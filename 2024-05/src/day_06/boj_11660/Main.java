package day_06.BOJ_S1_11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<N+M ; i++){
            sb.append(br.readLine() + " ");
        }

        StringTokenizer st = new StringTokenizer(sb.toString(), " ");

        int[][] arr = new int[1+N][1+N];
        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=N ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[1+N][1+N];
        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=N ; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] -dp[i-1][j-1] + arr[i][j];
            }
        }

        for(int i=0 ; i<M ; i++){
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1]);
        }

    }
}
