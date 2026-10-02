package day_20.BOJ_20920;

import java.io.*;
import java.util.*;

public class Main {

    private static class Node implements Comparable<Node> {
        String word;
        int cnt;

        public Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        public int compareTo(Node o) {
            if (this.cnt != o.cnt) return Integer.compare(o.cnt, this.cnt);
            if (this.word.length() != o.word.length()) return Integer.compare(o.word.length(), this.word.length());
            return this.word.compareTo(o.word);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) continue;

            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Node> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Node(entry.getKey(), entry.getValue()));
        }
        Collections.sort(list);

        for (Node node : list) {
            sb.append(node.word).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
