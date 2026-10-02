package day_12.BOJ_14696;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
            while (st.hasMoreTokens()) {
                pq1.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            st.nextToken();
            PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
            while (st.hasMoreTokens()) {
                pq2.add(Integer.parseInt(st.nextToken()));
            }

            while (true) {
                if (pq1.isEmpty() && pq2.isEmpty()) {
                    sb.append("D\n");
                    break;
                }

                if (pq1.isEmpty()) {
                    sb.append("B\n");
                    break;
                }

                if (pq2.isEmpty()) {
                    sb.append("A\n");
                    break;
                }

                int num1 = pq1.remove();
                int num2 = pq2.remove();

                if (num1 > num2) {
                    sb.append("A\n");
                    break;
                }

                if (num1 < num2) {
                    sb.append("B\n");
                    break;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
