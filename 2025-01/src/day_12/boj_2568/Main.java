package day_12.BOJ_2568;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 0열은 A 전봇대의 위치, 1열은 B 전봇대의 위치
        int[][] map = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map, ((o1, o2) -> Integer.compare(o1[0], o2[0])));

        int[] dp = new int[1 + N];

        int[] before = new int[N];

        int len = 0;
        for (int i = 0; i < N; i++) {
            int idx = binarySearchLowerBound(dp, len, map[i][1]);
            dp[idx] = map[i][1];
            if (idx == len + 1) len++;

            before[i] = idx;
        }

        sb.append(N - len).append("\n");

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--) {
            if (before[i] != len) {
                stack.push(map[i][0]);
                continue;
            }

            len--;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    // arr[]에서 target 이상인 가장 작은 원소의 인덱스를 반환하는 Lower Bound 이분 탐색
    private static int binarySearchLowerBound(int[] arr, int len, int target) {
        int left = 1;
        int right = len + 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }

        return right;
    }

}
