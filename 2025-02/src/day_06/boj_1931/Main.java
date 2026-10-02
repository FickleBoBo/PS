package day_06.BOJ_1931;

import java.io.*;
import java.util.*;

public class Main {

    private static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 회의 종료 시간을 기준으로 정렬
        // 종료 시간이 동일한 경우 일찍 시작하는 회의가 앞에 오게 정렬(회의의 시작 시간과 종료 시간이 동일할 수 있음)
        @Override
        public int compareTo(Node o) {
            if (this.end == o.end) return Integer.compare(this.start, o.start);
            return Integer.compare(this.end, o.end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Node(start, end));
        }

        int cnt = 0;
        int end = 0;
        while (!pq.isEmpty()) {
            Node node = pq.remove();
            if (node.start < end) continue;

            cnt++;
            end = node.end;
        }

        System.out.println(cnt);
    }
}
