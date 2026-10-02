package day_22.BOJ_16200;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] cntArr = new int[1 + N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(st.nextToken());
            cntArr[X]++;
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (cntArr[i] < 0) {
                cntArr[i + 1] += cntArr[i];
                cntArr[i] = 0;
                continue;
            }

            int q = cntArr[i] / i;
            int r = cntArr[i] % i;

            ans += q;
            if (r != 0) {
                cntArr[i + 1] -= i - r;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
