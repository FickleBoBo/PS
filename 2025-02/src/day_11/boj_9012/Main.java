package day_11.BOJ_9012;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            Deque<Character> stack = new ArrayDeque<>();

            char[] input = br.readLine().toCharArray();
            boolean flag = true;
            for (char c : input) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!stack.isEmpty()) flag = false;

            if (flag) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.flush();
    }
}
