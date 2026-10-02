package day_21.ksa_a;

import java.io.*;
import java.util.*;

// 체감 실3
// 18:30 ~ 18:40
public class Main {

    static final int MAX = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        boolean[] isPrime = sieve();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        if (arr[arr.length - 2] == 1 && isPrime[arr[arr.length - 1]]) {
            sb.append("NO");
        } else {
            sb.append("YES\n");
            sb.append(2).append("\n");
            sb.append(arr[arr.length - 2]).append(" ").append(arr[arr.length - 1]);
        }

        System.out.println(sb);
    }

    static boolean[] sieve() {
        boolean[] isPrime = new boolean[1 + MAX];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }
}
