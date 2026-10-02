package day_11.BOJ_5397;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            Deque<Character> deque = new ArrayDeque<>();
            Deque<Character> stack = new ArrayDeque<>();

            char[] input = br.readLine().toCharArray();

            for (char c : input) {
                if (c == '-') {
                    if (!deque.isEmpty()) {
                        deque.removeLast();
                    }
                } else if (c == '<') {
                    if (!deque.isEmpty()) {
                        stack.push(deque.removeLast());
                    }
                } else if (c == '>') {
                    if (!stack.isEmpty()) {
                        deque.addLast(stack.pop());
                    }
                } else {
                    deque.addLast(c);
                }
            }

            while (!deque.isEmpty()) {
                sb.append(deque.removeFirst());
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
