package day_31.BOJ_2864;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int min = sixToFive(A) + sixToFive(B);
        int max = fiveToSix(A) + fiveToSix(B);

        sb.append(min).append(" ").append(max);

        bw.write(sb.toString());
        bw.flush();
    }

    private static int fiveToSix(int N) {
        int ans = 0;

        int q = 1;
        while (N > 0) {
            if (N % 10 == 5) ans += 6 * q;
            else ans += N % 10 * q;

            N = N / 10;
            q *= 10;
        }

        return ans;
    }

    private static int sixToFive(int N) {
        int ans = 0;

        int q = 1;
        while (N > 0) {
            if (N % 10 == 6) ans += 5 * q;
            else ans += N % 10 * q;

            N = N / 10;
            q *= 10;
        }

        return ans;
    }

}
