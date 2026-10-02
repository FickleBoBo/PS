package day_11.BOJ_1781;

import java.io.*;
import java.util.*;

public class Main {

    private static class Problem {
        int deadLine;
        int reward;

        public Problem(int deadLine, int reward) {
            this.deadLine = deadLine;
            this.reward = reward;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 데드라인에 대한 내림차순 정렬
        PriorityQueue<Problem> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.deadLine, o1.deadLine));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());
            pq.add(new Problem(deadLine, reward));
        }

        // 컵라면 수에 대한 내림차순 정렬
        PriorityQueue<Problem> pq2 = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.reward, o1.reward));
        int sum = 0;
        for (int day = N; day > 0; day--) {
            while (!pq.isEmpty() && pq.peek().deadLine >= day) {
                pq2.add(pq.remove());
            }

            if (pq2.isEmpty()) continue;

            sum += pq2.remove().reward;
        }

        System.out.println(sum);
    }
}
