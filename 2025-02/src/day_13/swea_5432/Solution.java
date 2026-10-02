package day_13.SWEA_5432;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(Solution.class.getResourceAsStream("sample_input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            char[] input = br.readLine().toCharArray();

            Deque<Character> stack = new ArrayDeque<>();
            char before = '\u0000';
            int cnt = 0;

            for (char c : input) {
                if (c == '(') {
                    stack.push('(');
                } else {
                    stack.pop();

                    if (before == '(') cnt += stack.size();
                    else cnt++;
                }

                before = c;
            }

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
