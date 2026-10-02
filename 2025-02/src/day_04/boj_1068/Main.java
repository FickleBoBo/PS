package day_04.BOJ_1068;

import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int root = 0;
        p = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            if (p[i] == -1) root = i;
        }

        int target = Integer.parseInt(br.readLine());

        // 루트 노드를 삭제하는 경우
        if (root == target) {
            System.out.println(0);
            return;
        }

        int cnt = dfs(root, target);
        System.out.println(cnt);
    }

    private static int dfs(int node, int target) {
        int cnt = 0;
        boolean isLeaf = true;

        for (int next = 0; next < N; next++) {
            if (p[next] == node && next != target) {
                cnt += dfs(next, target);
                isLeaf = false;
            }
        }

        if (isLeaf) cnt++;

        return cnt;
    }

}
