package day_23.BOJ_1182;

import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int S;
    private static int[] arr;

    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        powerSet(0, 0);

        if (S == 0) System.out.println(cnt - 1);
        else System.out.println(cnt);
    }

    private static void powerSet(int selIdx, int sum) {
        if (selIdx == N) {
            if (sum == S) cnt++;
            return;
        }

        powerSet(selIdx + 1, sum + arr[selIdx]);
        powerSet(selIdx + 1, sum);
    }

}
