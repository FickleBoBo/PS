package day_26.BOJ_16493;

import java.io.*;
import java.util.*;

public class Main_PowerSet {

    private static class Item {
        int day;
        int page;

        public Item(int day, int page) {
            this.day = day;
            this.page = page;
        }
    }

    private static int N;
    private static int M;
    private static Item[] items;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        items = new Item[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int page = Integer.parseInt(st.nextToken());
            items[i] = new Item(day, page);
        }

        powerSet(0, 0, 0);

        System.out.println(ans);
    }

    private static void powerSet(int selIdx, int day, int page) {
        if (day > N) return;

        if (selIdx == M) {
            ans = Math.max(ans, page);
            return;
        }

        powerSet(selIdx + 1, day, page);
        powerSet(selIdx + 1, day + items[selIdx].day, page + items[selIdx].page);
    }

}
