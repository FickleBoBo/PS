package day_21.boj_6603;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int k;
    static int[] arr;
    static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sel = new int[6];

            dfs(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int x : sel) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            sel[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }
}
