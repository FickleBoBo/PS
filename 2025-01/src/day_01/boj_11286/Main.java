package day_01.BOJ_11286;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pqPositive = new PriorityQueue<>();
        PriorityQueue<Integer> pqNegative = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 0) pqPositive.add(x);
            else if (x < 0) pqNegative.add(x);
            else {
                if (pqPositive.isEmpty() && pqNegative.isEmpty()) sb.append(0).append("\n");
                else if (pqPositive.isEmpty()) sb.append(pqNegative.poll()).append("\n");
                else if (pqNegative.isEmpty()) sb.append(pqPositive.poll()).append("\n");
                else {
                    if (pqPositive.peek() + pqNegative.peek() >= 0) {
                        sb.append(pqNegative.poll()).append("\n");
                    } else {
                        sb.append(pqPositive.poll()).append("\n");
                    }
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
