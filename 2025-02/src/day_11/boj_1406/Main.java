package day_11.BOJ_1406;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Character> deque = new ArrayDeque<>();
        Deque<Character> stack = new ArrayDeque<>();

        char[] input = br.readLine().toCharArray();
        for (char c : input) {
            deque.addLast(c);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            char order = st.nextToken().charAt(0);

            if (order == 'L') {
                if (!deque.isEmpty()) {
                    stack.push(deque.removeLast());
                }
            } else if (order == 'D') {
                if (!stack.isEmpty()) {
                    deque.addLast(stack.pop());
                }
            } else if (order == 'B') {
                if (!deque.isEmpty()) {
                    deque.removeLast();
                }
            } else {
                char c = st.nextToken().charAt(0);
                deque.addLast(c);
            }
        }

        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
