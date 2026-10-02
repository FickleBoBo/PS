package day_30.BOJ_14501;

import java.io.*;
import java.util.*;

public class Main_PowerSet {

    private static int[] t;
    private static int[] p;
    private static boolean[] visited;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        t = new int[1 + N];
        p = new int[1 + N];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[1 + N];
        powerSet(N, 1);

        System.out.println(max);
    }

    private static void powerSet(int N, int selIdx) {
        if (selIdx > N) {
            findMax(N);
            return;
        }

        visited[selIdx] = true;
        powerSet(N, selIdx + 1);

        visited[selIdx] = false;
        powerSet(N, selIdx + 1);
    }

    private static void findMax(int N) {
        int sum = 0;
        int[] schedule = new int[1 + N];

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) continue;

            sum += p[i];
            if (i + t[i] - 1 > N) return;

            for (int j = i; j < i + t[i]; j++) {
                schedule[j]++;
                if (schedule[j] > 1) return;
            }
        }

        max = Math.max(max, sum);
    }

}
