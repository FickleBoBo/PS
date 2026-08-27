package day_26.prms_120846;

import java.util.*;

class Solution2 {
    public int solution(int n) {
        boolean[] isPrime = sieve(n);
        int cnt = 0;

        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) cnt++;
        }

        return cnt;
    }

    static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[1 + n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }
}
