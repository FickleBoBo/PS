package day_25.BOJ_12865;

import java.io.*;
import java.util.*;

public class Main_1D {

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

        int[] dp = new int[1 + K];
        for (int i = 1; i <= N; i++) {
            // 배낭의 최대 무게부터 현재 물건의 무게까지만 탐색하면 됨(더 작아지면 어차피 못 담음)
            for (int j = K; j >= items[i].W; j--) {
                dp[j] = Math.max(dp[j], dp[j - items[i].W] + items[i].V);
            }
        }

        System.out.println(dp[K]);
    }
}
