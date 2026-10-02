package day_11.BOJ_15652;

import java.io.*;
import java.util.*;

public class Main {

    private static final StringBuilder sb = new StringBuilder();

    private static int[] arr;
    private static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        sel = new int[M];

        combination(0, 0);

        bw.write(sb.toString());
        bw.flush();
    }

    // 중복 조합
    private static void combination(int idx, int selIdx) {
        if (selIdx == sel.length) {
            for (int n : sel) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            sel[selIdx] = i + 1;
            combination(i, selIdx + 1);
        }
    }

}
