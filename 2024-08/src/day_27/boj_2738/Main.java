package day_27.BOJ_B3_2738;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for(int i=0 ; i<N * 2 ; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0 ; j<M ; j++){
                arr[i % N][j] += Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
