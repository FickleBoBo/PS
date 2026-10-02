package day_11.BOJ_9625;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        int[] A = new int[1 + K];
        int[] B = new int[1 + K];
        A[0] = 1;

        for (int i = 1; i <= K; i++) {
            B[i] = B[i - 1] + A[i - 1];
            A[i] = B[i - 1];
        }

        sb.append(A[K]).append(" ").append(B[K]);

        bw.write(sb.toString());
        bw.flush();
    }
}
