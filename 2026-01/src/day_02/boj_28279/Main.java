package day_02.boj_28279;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 2_000_000;
    static int[] deque = new int[MAX];
    static int front = MAX / 2, rear = MAX / 2;

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
            int q = Integer.parseInt(st.nextToken());

            if (q == 1) {
                int x = Integer.parseInt(st.nextToken());
                push_front(x);
            } else if (q == 2) {
                int x = Integer.parseInt(st.nextToken());
                push_back(x);
            } else if (q == 3) {
                if (empty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(pop_front()).append("\n");
                }
            } else if (q == 4) {
                if (empty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(pop_back()).append("\n");
                }
            } else if (q == 5) {
                sb.append(size()).append("\n");
            } else if (q == 6) {
                if (empty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (q == 7) {
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
