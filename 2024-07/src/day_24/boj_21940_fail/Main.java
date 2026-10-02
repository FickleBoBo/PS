package day_24.BOJ_G4_21940_Fail;

import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[1+N][1+N];
        for(int i=1 ; i<=N ; i++){
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            dp[a][b] = t;
        }

        for(int k=1 ; k<=N ; k++){
            for(int i=1 ; i<=N ; i++){
                for(int j=1 ; j<=N ; j++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[1+K];

        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=K ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sumArr = new int[1+N];
        int min = INF;

        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=K ; j++){
                sumArr[i] += dp[i][j] + dp[j][i];
            }

            min = Math.min(min, sumArr[i]);
        }

        for(int i=1 ; i<=N ; i++){
            if(sumArr[i] == min){
                sb.append(i).append(" ");
            }
        }

        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=N ; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(Arrays.toString(sumArr));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
