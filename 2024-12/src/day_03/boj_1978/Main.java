package day_03.BOJ_1978;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        boolean[] isPrime = getPrimes(1_000);
        int ans = 0;

        while (st.hasMoreTokens()) {
            if (isPrime[Integer.parseInt(st.nextToken())]) ans++;
        }

        System.out.println(ans);
    }

    // 에라토스테네스의 체
    private static boolean[] getPrimes(int max) {
        boolean[] isPrime = new boolean[1 + max];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

}
