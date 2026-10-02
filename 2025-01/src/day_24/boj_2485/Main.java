package day_24.BOJ_2485;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int dist = arr[1] - arr[0];
        for (int i = 1; i < N - 1; i++) {
            dist = Math.min(dist, gcd(arr[i + 1] - arr[i], dist));
        }

        System.out.println((arr[N - 1] - arr[0]) / dist - N + 1);
    }

    // 유클리드 호제법
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}
