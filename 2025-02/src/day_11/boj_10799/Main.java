package day_11.BOJ_10799;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Character> stack = new ArrayDeque<>();
        int cnt = 0;

        char[] input = br.readLine().toCharArray();
        char before = '\u0000';
        for (char c : input) {
            if (c == '(') stack.push(c);
            else {
                stack.pop();
                if (before == '(') cnt += stack.size();  // 직전이 열린 괄호면 레이저
                else cnt += 1;  // 직전이 열린괄호가 아니면 막대의 끝
            }

            before = c;
        }

        System.out.println(cnt);
    }
}
