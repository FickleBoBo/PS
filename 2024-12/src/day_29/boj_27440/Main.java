package day_29.BOJ_27440;

import java.io.*;
import java.util.*;

public class Main {

    private static class Node implements Comparable<Node> {
        long num;
        int cnt;

        public Node(long num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cnt, o.cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        System.out.println(bfs(N));
    }

    private static int bfs(long N) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();

        pq.add(new Node(N, 0));
        visited.add(N);

        while (!pq.isEmpty()) {
            Node item = pq.poll();

            if (item.num == 1) return item.cnt;

            if (item.num % 3 == 0 && !visited.contains(item.num / 3)) {
                pq.offer(new Node(item.num / 3, item.cnt + 1));
                visited.add(item.num / 3);
            }
            if (item.num % 2 == 0 && !visited.contains(item.num / 2)) {
                pq.offer(new Node(item.num / 2, item.cnt + 1));
                visited.add(item.num / 2);
            }
            if (!visited.contains(item.num - 1)) {
                pq.offer(new Node(item.num - 1, item.cnt + 1));
                visited.add(item.num - 1);
            }
        }

        return -1;
    }

}
