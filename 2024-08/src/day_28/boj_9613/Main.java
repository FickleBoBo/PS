package day_28.BOJ_S4_9613;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            for(int i=0 ; i<N ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // int형 범위를 넘을 수 있음
            long ans = 0;

            for(int i=0 ; i<N-1 ; i++){
                for(int j=i+1 ; j<N ; j++){
                    ans += GCD(arr[i], arr[j]);
                }
            }

            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int GCD(int a, int b){
        if(b == 0) return a;
        return GCD(b, a % b);
    }

}
