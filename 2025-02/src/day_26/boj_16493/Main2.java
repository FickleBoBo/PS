package day_26.BOJ_16493;

import java.io.*;
import java.util.*;

public class Main_DP_2D {

    private static class Item {
        int day;
        int page;

        public Item(int day, int page) {
            this.day = day;
            this.page = page;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Item[] items = new Item[1 + M];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int page = Integer.parseInt(st.nextToken());
            items[i] = new Item(day, page);
        }

        int[][] dp = new int[1 + M][1 + N];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (j < items[i].day) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i].day] + items[i].page);
            }
        }

        System.out.println(dp[M][N]);
    }
}
