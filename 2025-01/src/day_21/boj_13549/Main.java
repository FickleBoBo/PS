package day_21.BOJ_13549;

import java.io.*;
import java.util.*;

public class Main_Dijkstra {

    private static class Node implements Comparable<Node> {
        int num;
        int time;

        public Node(int num, int time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }

    private static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int time = dijkstra(N, K);
        System.out.println(time);
    }

    // 다익스트라 알고리즘
    private static int dijkstra(int N, int K) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(N, 0));

        boolean[] visited = new boolean[1 + MAX];

        int[] time = new int[1 + MAX];
        Arrays.fill(time, 1 + MAX);
        time[N] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.remove();

            if (node.num == K) return node.time;

            if (visited[node.num]) continue;
            visited[node.num] = true;

            // X-1로 이동하려는 경우로 0보다 작은 위치로 이동 X
            if (node.num - 1 >= 0 && !visited[node.num - 1] && (time[node.num - 1] > time[node.num] + 1)) {
                pq.add(new Node(node.num - 1, node.time + 1));
                time[node.num - 1] = time[node.num] + 1;
            }

            // X+1로 이동하려는 경우로 K보다 큰 위치로 이동 X
            if (node.num + 1 <= K && !visited[node.num + 1] && (time[node.num + 1] > time[node.num] + 1)) {
                pq.add(new Node(node.num + 1, node.time + 1));
                time[node.num + 1] = time[node.num] + 1;
            }

            // 2*X로 이동하려는 경우로 100,000보다 큰 위치로 이동 X
            if (node.num * 2 <= MAX && !visited[node.num * 2] && (time[node.num * 2] > time[node.num])) {
                pq.add(new Node(node.num * 2, node.time));
                time[node.num * 2] = time[node.num];
            }
        }

        return -1;
    }

}
