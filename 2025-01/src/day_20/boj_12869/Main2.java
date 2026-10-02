package day_20.BOJ_12869;

import java.io.*;
import java.util.*;

public class Main_DFS {

    // 공격 조합에 대한 탐색 배열
    private static final int[] d1 = {1, 1, 3, 3, 9, 9};
    private static final int[] d2 = {3, 9, 1, 9, 1, 3};
    private static final int[] d3 = {9, 3, 9, 1, 3, 1};

    private static final boolean[][][] visited = new boolean[1 + 60][1 + 60][1 + 60];
    private static int ans = Integer.MAX_VALUE;

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

        dfs(arr, 0);

        System.out.println(ans);
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

    private static void dfs(int[] node, int depth) {
        if (node[2] == 0) {
            ans = Math.min(ans, depth);
            return;
        }

        if (visited[node[0]][node[1]][node[2]]) return;
        visited[node[0]][node[1]][node[2]] = true;

        for (int dir = 0; dir < 6; dir++) {
            int[] next = hit(node, d1[dir], d2[dir], d3[dir]);

            dfs(next, depth + 1);
        }
    }

}
