package day_26.boj_18258;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX_N = 2_000_000;
    static int[] queue = new int[MAX_N];
    static int front = 0, rear = 0;

    static void push(int x) {
        queue[rear++] = x;
    }

    static int pop() {
        return queue[front++];
    }

    static int size() {
        return rear - front;
    }

    static boolean empty() {
        return front == rear;
    }

    static int front() {
        return queue[front];
    }

    static int back() {
        return queue[rear - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if (op.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                push(x);
            } else if (op.equals("pop")) {
                if (empty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(pop()).append("\n");
                }
            } else if (op.equals("size")) {
                sb.append(size()).append("\n");
            } else if (op.equals("empty")) {
                if (empty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (op.equals("front")) {
                if (empty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(front()).append("\n");
                }
            } else {
                if (empty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(back()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
