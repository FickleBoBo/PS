package day_07.BOJ_2170;

import java.io.*;
import java.util.*;

public class Main2 {

    private static class Item implements Comparable<Item> {
        int s;
        int e;

        public Item(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Item o) {
            if (this.s != o.s) return Integer.compare(this.s, o.s);
            return Integer.compare(this.e, o.e);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Item> items = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            items.add(new Item(s, e));
        }

        int s = items.peek().s;
        int e = items.peek().e;
        items.remove();
        int sum = 0;

        while (!items.isEmpty()) {
            Item item = items.remove();

            if (item.s > e) {
                sum += e - s;
                s = item.s;
                e = item.e;
            } else {
                e = Math.max(e, item.e);
            }
        }
        sum += e - s;

        System.out.println(sum);
    }
}
