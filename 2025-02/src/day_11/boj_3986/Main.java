package day_11.BOJ_3986;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            Deque<Character> stack = new ArrayDeque<>();

            char[] input = br.readLine().toCharArray();
            for (char c : input) {
                if (stack.isEmpty()) stack.push(c);
                else {
                    if (stack.peek() != c) stack.push(c);
                    else stack.pop();
                }
            }

            if (!stack.isEmpty()) continue;

            cnt++;
        }

        System.out.println(cnt);
    }
}
