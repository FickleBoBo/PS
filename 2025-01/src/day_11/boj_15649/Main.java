package day_11.BOJ_15649;

import java.io.*;
import java.util.*;

public class Main {

    private static final StringBuilder sb = new StringBuilder();

    private static int[] arr;
    private static boolean[] visited;
    private static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        sel = new int[M];

        permutation(0);

        bw.write(sb.toString());
        bw.flush();
    }

    // 순열
    private static void permutation(int selIdx) {
        if (selIdx == sel.length) {
            for (int n : sel) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;

            sel[selIdx] = i + 1;
            visited[i] = true;
            permutation(selIdx + 1);
            visited[i] = false;
        }
    }

}
