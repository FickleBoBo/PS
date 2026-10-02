package day_15.BOJ_1966;

import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int order;
        int num;

        public Node(int order, int num) {
            this.order = order;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Node> q = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                q.add(new Node(i, num));
            }

            int ans = 1;
            while (true) {
                int max = 0;
                for (Node node : q) {
                    max = Math.max(max, node.num);
                }

                Node node = q.remove();

                if (node.num == max && node.order == M) break;

                if (node.num >= max) {
                    ans++;
                    continue;
                }

                q.add(node);
            }

            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
