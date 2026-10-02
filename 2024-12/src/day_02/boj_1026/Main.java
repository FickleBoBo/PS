package day_02.BOJ_1026;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int S = 0;

        // 배열 A 입력 받아서 정렬
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        // 배열 B 입력 받아서 정렬
        int[] B = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B);

        // 큰 수와 작은 수의 곱의 합이 최소
        for (int i = 0; i < N; i++) {
            S += A[i] * B[N - 1 - i];
        }

        System.out.println(S);
    }
}
