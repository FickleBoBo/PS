package day_03.BOJ_1106;

import java.io.*;
import java.util.*;

public class Main_1D {

    private static class Item {
        int cost;
        int cnt;

        public Item(int cost, int cnt) {
            this.cost = cost;
            this.cnt = cnt;
        }
    }

    private static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Item[] items = new Item[1 + N];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            items[i] = new Item(cost, cnt);
        }

        int[] dp = new int[1 + C + 100];
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        int min = MAX;

        for (int i = 1; i <= N; i++) {
            for (int j = items[i].cnt; j <= C + 100; j++) {
                dp[j] = Math.min(dp[j], dp[j - items[i].cnt] + items[i].cost);
            }
        }

        for (int i = C; i <= C + 100; i++) {
            min = Math.min(min, dp[i]);
        }
        System.out.println(min);
    }
}
