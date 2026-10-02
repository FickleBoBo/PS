package day_21.BOJ_14225;

import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] arr;
    private static final boolean[] visited = new boolean[1 + 2_000_000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        powerSet(0, 0);

        for (int i = 1; i < visited.length; i++) {
            if (visited[i]) continue;

            System.out.println(i);
            return;
        }
    }

    private static void powerSet(int selIdx, int sum) {
        if (selIdx == N) {
            visited[sum] = true;
            return;
        }

        powerSet(selIdx + 1, sum);
        powerSet(selIdx + 1, sum + arr[selIdx]);
    }

}
