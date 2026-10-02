package day_11.BOJ_2696;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            sb.append((N + 1) / 2).append("\n");

            StringBuilder input = new StringBuilder();
            for (int i = 0; i <= N / 10; i++) {
                input.append(br.readLine()).append("\n");
            }

            // 작은 절반
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            // 큰 절반
            PriorityQueue<Integer> pq2 = new PriorityQueue<>();

            st = new StringTokenizer(input.toString());
            for (int i = 1; i <= N; i++) {
                int num = Integer.parseInt(st.nextToken());

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

                if (i % 2 == 1) sb.append(pq.peek()).append(" ");
                if (i % 20 == 0) sb.append("\n");
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
