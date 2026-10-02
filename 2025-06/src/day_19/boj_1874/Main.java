package day_19.BOJ_1874;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        boolean isPossible = true;  // 스택 수열 가능 여부
        int num = 1;  // 1 ~ N 까지 입력 수열
        int before = 0;  // 이전 수

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            // 이전 수보다 크면 스택에 쭉 넣고 팝
            if (input > before) {
                for (int j = num; j <= input; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }

                num = input + 1;

                stack.pop();
                sb.append("-\n");
            }
            // 이전 수보다 작으면 팝
            else {
                if (stack.isEmpty() || stack.peek() != input) {
                    isPossible = false;
                    break;
                }

                stack.pop();
                sb.append("-\n");
            }

            before = input;
        }

        if (isPossible) {
            bw.write(sb.toString());
        } else {
            bw.write("NO");
        }

        br.close();
        bw.close();
    }
}
