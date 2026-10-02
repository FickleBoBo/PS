package day_05.BOJ_2565;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map, ((o1, o2) -> Integer.compare(o1[0], o2[0])));

        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int min = N;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (map[j][1] < map[i][1]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            min = Math.min(min, N - dp[i]);
        }

        System.out.println(min);
    }
}
