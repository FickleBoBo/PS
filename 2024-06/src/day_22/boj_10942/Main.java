package day_22.BOJ_G4_10942;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[1+N+1];
        for(int i=1 ; i<=N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[1+N+1][1+N+1];
        for(int i=1 ; i<=N ; i++){
            dp[i][i] = 1;
            if(arr[i] == arr[i+1]){
                dp[i][i+1] = 1;
            }
        }

        for(int i=N ; i>=1 ; i--){
            for(int j=1 ; j<=N ; j++){
                if(arr[i] == arr[j] && dp[i+1][j-1] == 1){
                    dp[i][j] = 1;
                }
            }
        }

//        for(int i=1 ; i<=N ; i++){
//            for(int j=1 ; j<=N ; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        int M = Integer.parseInt(br.readLine());

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            sb.append(dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
