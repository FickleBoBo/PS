package day_12.boj_1106;

import java.io.*;
import java.util.*;

public class Main2 {

    static final int INF = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] costs = new int[n];
        int[] people = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1 + c + 100];
        Arrays.fill(dp, 1, dp.length, INF);
        for (int i = 0; i < n; i++) {
            int cost = costs[i];
            int person = people[i];

            for (int j = person; j <= c + 100; j++) {
                dp[j] = Math.min(dp[j - person] + cost, dp[j]);
            }
        }

        int min = INF;
        for (int j = c; j <= c + 100; j++) {
            min = Math.min(min, dp[j]);
        }

        System.out.println(min);
    }
}
