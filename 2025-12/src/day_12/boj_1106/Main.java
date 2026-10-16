package day_12.boj_1106;

import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] costs = new int[1 + n];
        int[] people = new int[1 + n];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[1 + n][1 + c + 100];
        Arrays.fill(dp[0], 1, dp[0].length, INF);
        for (int i = 1; i <= n; i++) {
            int cost = costs[i];
            int person = people[i];

            for (int j = 1; j <= c + 100; j++) {
                if (j < person) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - person] + cost, dp[i - 1][j]);
                }
            }
        }

        int min = INF;
        for (int j = c; j <= c + 100; j++) {
            min = Math.min(min, dp[n][j]);
        }

        System.out.println(min);
    }
}
