package day_11.BOJ_9935;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque<Character> deque = new ArrayDeque<>();
        Deque<Character> stack = new ArrayDeque<>();

        char[] input = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();
        int len = bomb.length;

        for (char c : input) {
            deque.addLast(c);
            if (c != bomb[len - 1]) continue;

            boolean flag = true;
            for (int i = len - 1; i >= 0; i--) {
                if (deque.isEmpty()) {
                    flag = false;
                    break;
                }
                stack.push(deque.removeLast());
                if (stack.peek() != bomb[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                stack.clear();
            } else {
                while (!stack.isEmpty()) {
                    deque.addLast(stack.pop());
                }
            }
        }

        if (deque.isEmpty()) {
            sb.append("FRULA");
        } else {
            while (!deque.isEmpty()) {
                sb.append(deque.removeFirst());
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
