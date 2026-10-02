package day_12.BOJ_18258;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> q = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            switch (order) {
                case "push":
                    int X = Integer.parseInt(st.nextToken());
                    q.offer(X);
                    break;

                case "pop":
                    if (q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.poll()).append("\n");
                    break;

                case "size":
                    sb.append(q.size()).append("\n");
                    break;

                case "empty":
                    int flag = q.isEmpty() ? 1 : 0;
                    sb.append(flag).append("\n");
                    break;

                case "front":
                    if (q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.peekFirst()).append("\n");
                    break;

                case "back":
                    if (q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.peekLast()).append("\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
