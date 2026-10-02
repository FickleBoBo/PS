package day_12.BOJ_10866;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> dq = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            switch (order) {
                case "push_front":
                    int X = Integer.parseInt(st.nextToken());
                    dq.addFirst(X);
                    break;

                case "push_back":
                    X = Integer.parseInt(st.nextToken());
                    dq.addLast(X);
                    break;

                case "pop_front":
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.pollFirst()).append("\n");
                    break;

                case "pop_back":
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.pollLast()).append("\n");
                    break;

                case "size":
                    sb.append(dq.size()).append("\n");
                    break;

                case "empty":
                    int flag = dq.isEmpty() ? 1 : 0;
                    sb.append(flag).append("\n");
                    break;

                case "front":
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.peekFirst()).append("\n");
                    break;

                case "back":
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.peekLast()).append("\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
