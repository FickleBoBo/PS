package day_12.BOJ_14002;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        int[] before = new int[N];
        Arrays.fill(before, -1);

        int max = 0;
        int maxIdx = 0;

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < k; i++) {
                if (arr[i] < arr[k]) {
                    if (dp[k] <= dp[i]) {
                        dp[k] = dp[i] + 1;
                        before[k] = i;
                    }
                }
            }
            max = Math.max(max, dp[k]);
        }

        for (int i = 0; i < N; i++) {
            if (dp[i] == max) {
                maxIdx = i;
                break;
            }
        }

        sb.append(max).append("\n");

        Deque<Integer> stack = new ArrayDeque<>();
        while (maxIdx != -1) {
            stack.push(arr[maxIdx]);
            maxIdx = before[maxIdx];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
