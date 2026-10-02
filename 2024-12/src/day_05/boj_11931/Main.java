package day_05.BOJ_11931;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        final int MAX = 1_000_000;
        boolean[] visited = new boolean[MAX + 1 + MAX];
        for (int i = 0; i < N; i++) {
            visited[Integer.parseInt(br.readLine()) + MAX] = true;
        }

        for (int i = visited.length - 1; i >= 0; i--) {
            if (visited[i]) sb.append(i - MAX).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
