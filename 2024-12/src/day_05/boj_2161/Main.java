package day_05.BOJ_2161;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while (true) {
            sb.append(q.poll()).append(" ");

            if (q.isEmpty()) break;
            q.offer(q.poll());
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
