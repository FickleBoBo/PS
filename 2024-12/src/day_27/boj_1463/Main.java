package day_27.BOJ_1463;

import java.io.*;
import java.util.*;

public class Main_BFS {

    private static class Node implements Comparable<Node> {
        int num;
        int cnt;

        public Node(int num, int cnt) {
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

        int N = Integer.parseInt(br.readLine());

        System.out.println(bfs(N));
    }

    private static int bfs(int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[1 + N];

        pq.add(new Node(N, 0));
        visited[N] = true;

        while (!pq.isEmpty()) {
            Node item = pq.poll();

            if (item.num == 1) return item.cnt;

            if (item.num % 3 == 0 && !visited[item.num / 3]) {
                pq.offer(new Node(item.num / 3, item.cnt + 1));
                visited[item.num / 3] = true;
            }
            if (item.num % 2 == 0 && !visited[item.num / 2]) {
                pq.offer(new Node(item.num / 2, item.cnt + 1));
                visited[item.num / 2] = true;
            }
            if (!visited[item.num - 1]) {
                pq.offer(new Node(item.num - 1, item.cnt + 1));
                visited[item.num - 1] = true;
            }
        }

        return -1;
    }

}
