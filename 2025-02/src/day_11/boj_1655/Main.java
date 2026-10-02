package day_11.BOJ_1655;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 작은 절반
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 큰 절반
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (i % 2 == 1) {
                if (!pq2.isEmpty() && num <= pq2.peek()) {
                    pq.add(num);
                } else {
                    pq2.add(num);
                    pq.add(pq2.remove());
                }
            } else {
                if (!pq.isEmpty() && num >= pq.peek()) {
                    pq2.add(num);
                } else {
                    pq.add(num);
                    pq2.add(pq.remove());
                }
            }

            sb.append(pq.peek()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
