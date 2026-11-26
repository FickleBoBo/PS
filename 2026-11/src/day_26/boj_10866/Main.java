package day_26.boj_10866;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX_N = 10000;
    static int[] deque = new int[MAX_N * 2];
    static int front = MAX_N, rear = MAX_N;

    static void push_front(int x) {
        deque[--front] = x;
    }

    static void push_back(int x) {
        deque[rear++] = x;
    }

    static int pop_front() {
        return deque[front++];
    }

    static int pop_back() {
        return deque[--rear];
    }

    static int size() {
        return rear - front;
    }

    static boolean empty() {
        return front == rear;
    }

    static int front() {
        return deque[front];
    }

    static int back() {
        return deque[rear - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String q = st.nextToken();

            if (q.equals("push_front")) {
                int x = Integer.parseInt(st.nextToken());
                push_front(x);
            } else if (q.equals("push_back")) {
                int x = Integer.parseInt(st.nextToken());
                push_back(x);
            } else if (q.equals("pop_front")) {
                if (empty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(pop_front()).append("\n");
                }
            } else if (q.equals("pop_back")) {
                if (empty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(pop_back()).append("\n");
                }
            } else if (q.equals("size")) {
                sb.append(size()).append("\n");
            } else if (q.equals("empty")) {
                if (empty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (q.equals("front")) {
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
