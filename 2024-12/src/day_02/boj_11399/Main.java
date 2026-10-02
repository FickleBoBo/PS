package day_02.BOJ_11399;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int sum = 0;

        // 인출하는데 걸리는 시간이 작은 사람부터 줄을 서야 최소
        int[] P = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(P);

        // 누적합 배열의 합이 모든 사람이 돈을 인출하는데 걸리는 시간의 합
        int[] prefixSum = new int[1 + N];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + P[i - 1];
            sum += prefixSum[i];
        }

        System.out.println(sum);
    }
}
