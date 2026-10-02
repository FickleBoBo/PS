package day_06.BOJ_14267;

import java.io.*;
import java.util.*;

public class Main_DP1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 인덱스는 직원 번호, 값에는 직속 상사 번호 저장
        int[] p = new int[1 + N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        p[1] = 0;

        // 칭찬을 받기 시작한 첫번째 직원에 칭찬의 수치 저장
        int[] arr = new int[1 + N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[num] += w;
        }

        int[] dp = new int[1 + N];
        for (int i = 1; i <= N; i++) {
            dp[i] = arr[i] += arr[p[i]];
        }

        for (int i = 1; i <= N; i++) {
            sb.append(dp[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
