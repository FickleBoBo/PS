package day_03.BOJ_15965;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        List<Integer> primes = getPrimes(10_000_000);

        System.out.println(primes.get(K - 1));
    }

    // 에라토스테네스의 체
    private static List<Integer> getPrimes(int max) {
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

        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

}
