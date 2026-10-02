package day_20.BOJ_12869;

import java.io.*;
import java.util.*;

public class Main_DP {

    // 공격 조합에 대한 탐색 배열
    private static final int[] d1 = {1, 1, 3, 3, 9, 9};
    private static final int[] d2 = {3, 9, 1, 9, 1, 3};
    private static final int[] d3 = {9, 3, 9, 1, 3, 1};

    private static final int[][][] dp = new int[1 + 60][1 + 60][1 + 60];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i <= 60; i++) {
            for (int j = 0; j <= 60; j++) {
                for (int k = 0; k <= 60; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        recur(arr);

        System.out.println(dp[arr[0]][arr[1]][arr[2]]);
    }

    // SCV 체력을 담은 배열을 받아서 공격 후 변경된 체력을 배열로 반환
    private static int[] hit(int[] arr, int d1, int d2, int d3) {
        int[] tmp = arr.clone();
        tmp[0] = Math.max(tmp[0] - d1, 0);
        tmp[1] = Math.max(tmp[1] - d2, 0);
        tmp[2] = Math.max(tmp[2] - d3, 0);
        Arrays.sort(tmp);
        return tmp;
    }

    private static int recur(int[] node) {
        if (node[2] == 0) return 0;
        if (dp[node[0]][node[1]][node[2]] != Integer.MAX_VALUE) return dp[node[0]][node[1]][node[2]];

        for (int dir = 0; dir < 6; dir++) {
            int[] next = hit(node, d1[dir], d2[dir], d3[dir]);

            dp[node[0]][node[1]][node[2]] = Math.min(dp[node[0]][node[1]][node[2]], recur(next) + 1);
        }

        return dp[node[0]][node[1]][node[2]];
    }

}
