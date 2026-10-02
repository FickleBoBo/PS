package day_28.BOJ_S3_15649;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] sel;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sel = new int[M];
        visited = new boolean[1+N];    // 인덱스와 수열 값을 맞춰주기 위한 패딩

        permutation(0);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void permutation(int sidx){
        if(sidx == M){
            for(int n : sel){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1 ; i<=N ; i++){
            if(!visited[i]){
                sel[sidx] = i;
                visited[i] = true;
                permutation(sidx+1);
                visited[i] = false;
            }
        }
    }

}
