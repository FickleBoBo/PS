package day_12.BOJ_15663;

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
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        visited = new boolean[N];
        sel = new int[M];

        permutation(0);

        bw.write(sb.toString());
        bw.flush();
    }

    // 복수 순열
    private static void permutation(int selIdx) {
        if (selIdx == sel.length) {
            for (int n : sel) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            if (arr[i] == before) continue;

            sel[selIdx] = arr[i];
            before = arr[i];
            visited[i] = true;
            permutation(selIdx + 1);
            visited[i] = false;
        }
    }

}
