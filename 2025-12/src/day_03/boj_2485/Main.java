package day_03.boj_2485;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int g = arr[1] - arr[0];
        for (int i = 2; i < n; i++) {
            g = gcd(g, arr[i] - arr[i - 1]);
        }

        System.out.println((arr[n - 1] - arr[0]) / g + 1 - n);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
