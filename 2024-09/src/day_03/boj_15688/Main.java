package day_03.BOJ_S5_15688;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        final int MAX = 1_000_000;

        int[] cntArr = new int[MAX+1+MAX];
        for(int i=0 ; i<N ; i++){
            int n = Integer.parseInt(br.readLine());
            cntArr[n + MAX]++;
        }

        for(int i=0 ; i<=(MAX * 2) ; i++){
            for(int j=0 ; j<cntArr[i] ; j++){
                sb.append(i - MAX).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
