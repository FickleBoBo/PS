package day_07.BOJ_2170;

import java.io.*;
import java.util.*;

public class Main {

    private static class Item {
        int s;
        int e;

        public Item(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Item> items = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.s, o2.s));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            items.add(new Item(s, e));
        }

        PriorityQueue<Item> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.e, o1.e));
        pq.add(items.remove());

        while (!items.isEmpty()) {
            Item item = items.remove();
            Item cur = pq.remove();

            if (item.s > cur.e || item.e < cur.s) {
                pq.add(cur);
                pq.add(item);
            } else {
                pq.add(new Item(Math.min(cur.s, item.s), Math.max(cur.e, item.e)));
            }
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            Item item = pq.remove();
            sum += item.e - item.s;
        }

        System.out.println(sum);
    }
}
