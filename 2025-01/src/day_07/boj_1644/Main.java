package day_07.BOJ_1644;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 1은 예외처리
        if (N == 1) {
            System.out.println(0);
            return;
        }

        List<Integer> primes = getPrimes(N);
        int left = 0;
        int right = 0;
        int sum = 0;
        int cnt = 0;

        while (true) {
            if (sum < N) {
                sum += primes.get(right++);
            } else if (sum > N) {
                sum -= primes.get(left++);
            } else {
                sum -= primes.get(left++);
                cnt++;
            }

            if (right == primes.size() && sum < N) break;
        }

        System.out.println(cnt);
    }

    private static List<Integer> getPrimes(int N) {
        boolean[] isPrime = new boolean[1 + N];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) primes.add(i);
        }

        return primes;
    }

}
