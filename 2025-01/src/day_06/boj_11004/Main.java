package day_06.BOJ_11004;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        while (st.hasMoreTokens()) {
            pq.add(Integer.parseInt(st.nextToken()));
            pq.poll();
        }

        System.out.println(pq.poll());
    }
}
