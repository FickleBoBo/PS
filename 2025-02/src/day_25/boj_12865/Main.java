package day_25.BOJ_12865;

import java.io.*;
import java.util.*;

public class Main_2D {

    private static class Item {
        int W;
        int V;

        public Item(int W, int V) {
            this.W = W;
            this.V = V;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Item[] items = new Item[1 + N];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            items[i] = new Item(W, V);
        }

        int[][] dp = new int[1 + N][1 + K];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                // 배낭의 무게가 현재 물건의 무게보다 작으면 못 담음
                if (j < items[i].W) dp[i][j] = dp[i - 1][j];

                // 배낭의 무게가 현재 물건의 무게보다 크거나 같으면 현재 물건을 담는 경우와 안 담는 경우를 비교
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i].W] + items[i].V);
            }
        }

        System.out.println(dp[N][K]);
    }
}
