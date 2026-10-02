package day_11.BOJ_1202;

import java.io.*;
import java.util.*;

public class Main {

    private static class Jewel {
        int m;
        int v;

        public Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 무게에 대한 오름차순 정렬
        PriorityQueue<Jewel> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.m, o2.m));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pq.add(new Jewel(m, v));
        }

        int[] knapsacks = new int[K];
        for (int i = 0; i < K; i++) {
            knapsacks[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(knapsacks);

        // 가격에 대한 내림차순 정렬
        PriorityQueue<Jewel> pq2 = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.v, o1.v));
        long sum = 0;
        for (int knapsack : knapsacks) {
            while (!pq.isEmpty() && pq.peek().m <= knapsack) {
                pq2.add(pq.remove());
            }

            if (pq2.isEmpty()) continue;

            sum += pq2.remove().v;
        }

        System.out.println(sum);
    }
}
