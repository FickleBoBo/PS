package day_20.boj_26099;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        if (n % 5 == 0) {
            System.out.println(n / 5);
        } else if (n >= 3 && (n - 3) % 5 == 0) {
            System.out.println((n - 3) / 5 + 1);
        } else if (n >= 6 && (n - 6) % 5 == 0) {
            System.out.println((n - 6) / 5 + 2);
        } else if (n >= 9 && (n - 9) % 5 == 0) {
            System.out.println((n - 9) / 5 + 3);
        } else if (n >= 12 && (n - 12) % 5 == 0) {
            System.out.println((n - 12) / 5 + 4);
        } else {
            System.out.println(-1);
        }
    }
}
