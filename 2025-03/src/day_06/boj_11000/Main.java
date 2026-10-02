package day_06.BOJ_11000;

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

        // 시작 시간을 기준으로 오름차순 정렬
        PriorityQueue<Item> items = new PriorityQueue<>((o1, o2) -> {
            if (o1.s != o2.s) return Integer.compare(o1.s, o2.s);
            return Integer.compare(o1.e, o2.e);
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            items.add(new Item(s, e));
        }

        // 종료 시간을 기준으로 오름차순 정렬
        PriorityQueue<Item> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.e, o2.e));
        pq.add(items.remove());

        // pq에서 종료 시간이 가장 빠른 강의 이후에 시작하는 강의면 해당 강의 뒤에 붙이는 개념
        while (!items.isEmpty()) {
            if (items.peek().s >= pq.peek().e) pq.remove();

            pq.add(items.remove());
        }

        System.out.println(pq.size());
    }
}
