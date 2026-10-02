package day_13.SWEA_8931;

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
            int K = Integer.parseInt(br.readLine());

            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < K; i++) {
                int num = Integer.parseInt(br.readLine());

                if (num == 0) stack.pop();
                else stack.push(num);
            }

            int sum = 0;
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }

            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
