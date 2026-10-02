package day_08.BOJ_11728;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int pivotA = 0;
        int pivotB = 0;

        while (!(pivotA == N && pivotB == M)) {
            if (pivotA == N) sb.append(B[pivotB++]).append(" ");
            else if (pivotB == M) sb.append(A[pivotA++]).append(" ");
            else sb.append(A[pivotA] < B[pivotB] ? A[pivotA++] : B[pivotB++]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
