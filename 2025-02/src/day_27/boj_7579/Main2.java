package day_27.BOJ_7579;

import java.io.*;
import java.util.*;

public class Main_1D {

    private static class Item {
        int m;
        int c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Item[] items = new Item[1 + N];
        for (int i = 1; i <= N; i++) {
            items[i] = new Item();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i].m = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i].c = Integer.parseInt(st.nextToken());
            max += items[i].c;
        }

        int[] dp = new int[1 + max];

        for (int i = 1; i <= N; i++) {
            for (int j = max; j >= items[i].c; j--) {
                dp[j] = Math.max(dp[j], dp[j - items[i].c] + items[i].m);
            }
        }

        for (int i = 0; i <= max; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                return;
            }
        }
    }
}
